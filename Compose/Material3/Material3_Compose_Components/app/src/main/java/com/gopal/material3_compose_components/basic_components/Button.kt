package com.gopal.material3_compose_components.basic_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gopal.material3_compose_components.util.basicLayoutItem

@Preview
@Composable
private fun ButtonComposables_Prev() {
    ButtonComposable_Usages_Examples()
}

@Composable
fun ButtonComposable_Usages_Examples() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
    ) {
        basicLayoutItem {
            Button(onClick = { //do nothing
            }) {
                Text(text = "SimpleButton")
            }
        }
    }
}