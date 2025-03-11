package com.gopal.material3_compose_components.basic_components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gopal.material3_compose_components.util.basicLayoutItem

@Preview
@Composable
private fun CardComposable_Prev() {
    CardComposable()
}

@Composable
fun CardComposable() {

    val sizeModifier = remember { Modifier.size(width = 240.dp, height = 100.dp) }
    val paddingModifier = remember { Modifier.padding(16.dp) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
    ) {

        basicLayoutItem {
            // basic card
            Card(
                modifier = sizeModifier
            ) {
                Text(text = "This is a basic card", modifier = paddingModifier)
            }

            // Filled Card
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
                modifier = sizeModifier
            ) {
                Text(
                    text = "Filled Card",
                    modifier = paddingModifier,
                    textAlign = TextAlign.Center,
                )
            }

            // Elevated Card
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                modifier = sizeModifier
            ) {
                Text(
                    text = "Elevated Card",
                    modifier = paddingModifier,
                    textAlign = TextAlign.Center,
                )
            }

            // Outlined Card
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                ),
                border = BorderStroke(1.dp, Color.Black),
                modifier = sizeModifier
            ) {
                Text(
                    text = "Outlined Card",
                    modifier = paddingModifier,
                    textAlign = TextAlign.Center,
                )
            }
        }

        // exploring the available card parameters
        basicLayoutItem {
            // Clickable Card
            CardWithSizeAndPaddingToText(
                textOnCard = "Clickable Card",
            )

            // different shaped card
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with Rectangle shape",
                shape = RectangleShape
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with Rounded corner shape",
                shape = RoundedCornerShape(10.dp)
            )

            // disabled card
            CardWithSizeAndPaddingToText(
                textOnCard = "Disabled Card",
                enabled = false
            )

            // Card with different colors
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with containerColor = Color.Magenta",
                colors = CardDefaults.cardColors(
                    containerColor = Color.Magenta
                )
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with contentColor = Color.Yellow",
                colors = CardDefaults.cardColors(
                    contentColor = Color.Yellow
                )
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with disabledContainerColor = Color.Blue",
                enabled = false,
                colors = CardDefaults.cardColors(
                    disabledContainerColor = Color.Blue
                ),
                textColor = Color.White
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with disabledContentColor = Color.Red",
                enabled = false,
                colors = CardDefaults.cardColors(
                    disabledContentColor = Color.Red
                )
            )

            // Card with different elevations
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with default elevation",
                elevation = CardDefaults.cardElevation()
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with elevated elevation",
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with pressed elevation",
                elevation = CardDefaults.cardElevation(
                    pressedElevation = 8.dp
                )
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with disabled elevation",
                enabled = false,
                elevation = CardDefaults.cardElevation(
                    disabledElevation = 10.dp
                )
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with hovered elevation",
                elevation = CardDefaults.cardElevation(
                    hoveredElevation = 10.dp
                )
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with dragged elevation",
                elevation = CardDefaults.cardElevation(
                    draggedElevation = 10.dp
                )
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with focused elevation",
                elevation = CardDefaults.cardElevation(
                    focusedElevation = 10.dp
                )
            )

            // Card with borders
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with border",
                border = BorderStroke(1.dp, Color.Black)
            )
            CardWithSizeAndPaddingToText(
                textOnCard = "Card with disabled state but with border",
                enabled = false,
                border = BorderStroke(1.dp, Color.Black)
            )

        }
    }
}

@Composable
private fun CardWithSizeAndPaddingToText(
    textOnCard: String,
    onClick: (() -> Unit)? = null,
    shape: Shape = CardDefaults.shape,
    enabled: Boolean = true,
    colors: CardColors = CardDefaults.cardColors(),
    elevation: CardElevation = CardDefaults.cardElevation(),
    border: BorderStroke = BorderStroke(width = 0.dp, color = Color.Unspecified),
    content: @Composable () -> Unit = {},
    @SuppressLint("ModifierParameter") sizeModifier: Modifier = Modifier.size(width = 240.dp, height = 100.dp),
    paddingModifier: Modifier = Modifier.padding(16.dp),
    textColor: Color = Color.Unspecified
) {
    Card(
        modifier = sizeModifier,
        onClick = { onClick?.invoke() },
        shape = shape,
        enabled = enabled,
        colors = colors,
        elevation = elevation,
        border = border
    ) {
        Text(
            text = textOnCard,
            modifier = paddingModifier,
            color = textColor
        )
        content()
    }
}