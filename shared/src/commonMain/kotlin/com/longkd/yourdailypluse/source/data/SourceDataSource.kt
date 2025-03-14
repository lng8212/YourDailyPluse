package com.longkd.yourdailypluse.source.data

import longkd.yourdailypluse.db.YourDailyPulseDatabase

/**
 * @Author: longkd
 * @Since: 20:24 - 14/3/25
 */
class SourceDataSource(private val database: YourDailyPulseDatabase) {
    fun getAllSources(): List<SourceRaw> =
        database.yourDailyPulseDatabaseQueries.selectAllSources(::mapToSourceRaw).executeAsList()

    fun clearSources() =
        database.yourDailyPulseDatabaseQueries.removeAllSources()

    fun insertSources(sources: List<SourceRaw>) {
        database.yourDailyPulseDatabaseQueries.transaction {
            sources.forEach { source ->
                insertSource(source)

            }
        }
    }

    private fun insertSource(source: SourceRaw) {
        database.yourDailyPulseDatabaseQueries.insertSource(
            name = source.name,
            desc = source.description,
            language = source.language,
            country = source.country
        )
    }


    private fun mapToSourceRaw(
        name: String,
        desc: String?,
        language: String,
        country: String
    ): SourceRaw = SourceRaw(name, desc, language, country)
}