package com.gopal.material3_compose_components.basic_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.SaverScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gopal.material3_compose_components.util.basicLayoutItem

@Preview
@Composable
private fun CheckboxComposable_Prev() {
    CheckboxComposable()
}

@Composable
fun CheckboxComposable() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
    ) {

        basicLayoutItem {
            // checkbox with checked state
            Checkbox(
                checked = true,
                onCheckedChange = {}
            )
            // checkbox with unchecked state
            Checkbox(
                checked = false,
                onCheckedChange = {},
            )
        }

        basicLayoutItem {
            // live working checkbox
            CheckboxComponent(
                text = "Live working checkbox"
            )

            // disabled checkbox
            CheckboxComponent(
                text = "Checkbox with disabled state",
                enabled = false
            )

            // checkbox with custom colors
            CheckboxComponent(
                text = "Checkbox with custom colors",
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Black,
                    checkmarkColor = Color.Red
                )
            )

            // checkbox with custom colors and disabled state
            CheckboxComponent(
                text = "Checkbox with custom colors and disabled state",
                enabled = false,
                colors = CheckboxDefaults.colors(
                    disabledCheckedColor = Color.Blue,
                    disabledUncheckedColor = Color.Green,
                    checkmarkColor = Color.Red
                )
            )
        }

        basicLayoutItem {
            NotificationPreferences()
        }
    }
}

@Composable
private fun NotificationPreferences() {
    // Use rememberSaveable with custom saver
    val notificationCategories = rememberSaveable(saver = NotificationCategorySaver) {
        mutableStateListOf(
            NotificationCategory("Marketing", false),
            NotificationCategory("Updates", false),
            NotificationCategory("Security Alerts", false)
        )
    }

    // Compute the parent checkbox state
    val parentState = when {
        notificationCategories.all { it.isSelected } -> ToggleableState.On
        notificationCategories.none { it.isSelected } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(modifier = Modifier.padding(16.dp)) {
        // Parent Tri-State Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Enable All Notifications", modifier = Modifier.weight(1f))
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState = parentState != ToggleableState.On
                    notificationCategories.replaceAll { it.copy(isSelected = newState) }
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Child Checkboxes
        notificationCategories.forEachIndexed { index, category ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(category.name, modifier = Modifier.weight(1f))
                Checkbox(
                    checked = category.isSelected,
                    onCheckedChange = { isChecked ->
                        notificationCategories[index] = category.copy(isSelected = isChecked)
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Display Selected Categories
        val selectedCategories = notificationCategories.filter { it.isSelected }
        Text(
            text = if (selectedCategories.isNotEmpty()) {
                "Enabled: ${selectedCategories.joinToString { it.name }}"
            } else {
                "No notifications enabled"
            },
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
    }
}

// Data class to hold notification categories
private data class NotificationCategory(val name: String, val isSelected: Boolean)

// Custom Saver for the NotificationCategory list
private object NotificationCategorySaver : Saver<MutableList<NotificationCategory>, List<Pair<String, Boolean>>> {
    override fun restore(value: List<Pair<String, Boolean>>): MutableList<NotificationCategory> {
        return value.map { NotificationCategory(it.first, it.second) }.toMutableStateList()
    }

    override fun SaverScope.save(value: MutableList<NotificationCategory>): List<Pair<String, Boolean>>? {
        return value.map { it.name to it.isSelected }
    }
}



@Composable
private fun CheckboxComponent(
    text: String,
    enabled: Boolean = true,
    colors: CheckboxColors = CheckboxDefaults.colors()
) {
    val (isChecked, onCheckedChange) = remember {  mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text)
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            colors = colors
        )
    }
}