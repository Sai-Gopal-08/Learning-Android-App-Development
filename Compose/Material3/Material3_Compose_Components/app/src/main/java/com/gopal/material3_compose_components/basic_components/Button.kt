package com.gopal.material3_compose_components.basic_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gopal.material3_compose_components.R
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

        // Button with icon
        basicLayoutItem {
            Button(
                onClick = {},
            ) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = stringResource(R.string.edit_icon_description),
                )

                Text(modifier = Modifier.padding(start = 10.dp), text = stringResource(R.string.edit))
            }
        }

        // Buttons with different shapes
        basicLayoutItem {
            Button(
                onClick = {},
                shape = RectangleShape
            ) {
                Text(text = "Button with Rectangle shape")
            }

            Button(
                onClick = {},
                shape = RoundedCornerShape(size = 16.dp)
            ) {
                Text(text = "Button with Rounded corner shape")
            }

            Button(
                onClick = {},
                shape = CutCornerShape(size = 10.dp)
            ) {
                Text(text = "Button with Cut corner shape")
            }
        }

        // highlight your button
        basicLayoutItem {
            Button(
                onClick = {},
                border = BorderStroke(width = 1.dp, color = Color.Red)
            ) {
                Text(text = "Button with Red border")
            }

            Button(
                onClick = {},
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 15.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Text(text = "Button with elevation")
            }

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green,
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray,
                    disabledContentColor = Color.DarkGray
                )
            ) {
                Text(text = "Button with colors")
            }

            Button(
                onClick = {},
                enabled = false
            ) {
                Text(text = "Button with disabled state")
            }
        }

        // different types of buttons
        basicLayoutItem {
            // Filled button
            Button(
                onClick = {}
            ) {
                Text(text = "Filled button")
            }

            // Tonal button
            FilledTonalButton(
                onClick = {}
            ) {
                Text(text = "Tonal button")
            }

            // Outlined button
            OutlinedButton(
                onClick = {}
            ) {
                Text(text = "Outlined button")
            }

            // Elevated button
            ElevatedButton(
                onClick = {}
            ) {
                Text(text = "Elevated button")
            }

            // TextButton
            TextButton(
                onClick = {}
            ) {
                Text(text = "Text button")
            }

            // Floating Action Button
            FloatingActionButton(
                onClick = {}
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = stringResource(R.string.edit_icon_description),
                    )
                    Text(text = "FAB")
                }
            }
        }

        // customizing button every possible way
        basicLayoutItem {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(0.25f)
            ) {
                Text(text = "Button occupies 25% of the width")
            }
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(0.75f)
            ) {
                Text(text = "Button occupies 75% of the width")
            }
            Button(
                onClick = {},
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp),
            ) {
                Text(text = "Button with custom padding")
            }
        }
    }
}