package com.longkd.yourdailypluse.source.data

/**
 * @Author: longkd
 * @Since: 20:24 - 14/3/25
 */
class SourceRepository(
    private val sourceDataSource: SourceDataSource,
    private val sourceService: SourceService
) {
    suspend fun getSources(forceFetch: Boolean): List<SourceRaw> {
        if (forceFetch) {
            sourceDataSource.clearSources()
            return fetchSources()
        }
        val sourceDbs = sourceDataSource.getAllSources()
        println("Got ${sourceDbs.size} from database")
        if (sourceDbs.isEmpty()) {
            return fetchSources()
        }
        return sourceDbs
    }

    private suspend fun fetchSources(): List<SourceRaw> {
        val fetchedSources = sourceService.fetchAllSource()
        sourceDataSource.insertSources(fetchedSources)
        return fetchedSources
    }
}