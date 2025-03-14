package com.longkd.yourdailypluse.android.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.longkd.yourdailypluse.source.domain.Source
import com.longkd.yourdailypluse.source.presentation.SourceViewModel
import org.koin.androidx.compose.getViewModel

/**
 * @Author: longkd
 * @Since: 21:26 - 14/3/25
 */

@Composable
fun SourceScreen(onBackButtonClick: () -> Unit, sourceViewModel: SourceViewModel = getViewModel()) {
    val sourceState = sourceViewModel.sourceState.collectAsState()
    Column {
        SourceToolbar(onBackButtonClick)
        if (sourceState.value.error != null)
            ErrorMessage(sourceState.value.error!!)
        if (sourceState.value.sources.isNotEmpty())
            SourceContentView(viewModel = sourceViewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SourceToolbar(onBackButtonClick: () -> Unit) {
    TopAppBar(
        title = { Text("Sources") },
        navigationIcon = {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Up Button"
                )
            }
        }
    )
}


@Composable
fun SourceContentView(viewModel: SourceViewModel) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(viewModel.sourceState.value.sources) { source ->
            SourceItemView(source = source)
        }
    }
}

@Composable
fun SourceItemView(source: Source) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = source.name,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.description.toString())
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = source.country,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}
