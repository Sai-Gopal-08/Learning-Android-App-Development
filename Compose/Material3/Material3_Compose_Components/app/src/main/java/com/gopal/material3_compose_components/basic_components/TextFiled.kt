package com.gopal.material3_compose_components.basic_components

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.PlatformImeOptions
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.gopal.material3_compose_components.util.basicLayoutItem
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TextFieldComposables(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
    ) {

        // BasicTextField - without any styling
        // https://developer.android.com/reference/kotlin/androidx/compose/foundation/text/package-summary#BasicTextField(androidx.compose.ui.text.input.TextFieldValue,kotlin.Function1,androidx.compose.ui.Modifier,kotlin.Boolean,kotlin.Boolean,androidx.compose.ui.text.TextStyle,androidx.compose.foundation.text.KeyboardOptions,androidx.compose.foundation.text.KeyboardActions,kotlin.Boolean,kotlin.Int,kotlin.Int,androidx.compose.ui.text.input.VisualTransformation,kotlin.Function1,androidx.compose.foundation.interaction.MutableInteractionSource,androidx.compose.ui.graphics.Brush,kotlin.Function1)
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            BasicTextField(value = inputText.value, onValueChange = { inputText.value = it })
        }

        // OutlinedTextField - with default styling
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it }
            )
        }

        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                enabled = inputText.value.isNotEmpty(), // validate input - valid or invalid
                readOnly = inputText.value.length > 10, // Make it read-only when certain conditions are met
                textStyle = TextStyle( // edit as per requirement
                    fontFamily = FontFamily.Cursive
                ),
                label = { // Until this composable is clicked/focused label stays in the field. Once clicked/focused label changes its position to the top of the field.
                    Text(text = "Label")
                },
                placeholder = { // Once this composable is clicked/focused placeholder is shown in the field suggesting user the type of data he can enter.
                    Text(text = "This is a Placeholder")
                },
                leadingIcon = { // Icon to the left of the text field.
                    Icon(imageVector = Icons.Default.Home, contentDescription = "Some home icon")
                },
                trailingIcon = { // Icon to the right of the text field.
                    IconButton(onClick = { inputText.value = "" }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Some clear icon"
                        )
                    }
                },
                prefix = { // Content to the left of the text field.
                    Text(text = "$ Prefix")
                },
                suffix = { // Content to the right of the text field.
                    Text(text = "Suffix")
                },
                supportingText = { // the optional supporting text to be displayed below the text field - can use it in conjunction with error to show error msg
                    Text(text = "This is supporting text")
                },
                isError = inputText.value.isEmpty(), // indicates input error - If set to true, the label, bottom indicator and trailing icon by default will be displayed in error color
                visualTransformation = if (inputText.value.length > 8) PasswordVisualTransformation() else VisualTransformation.None, //PasswordVisualTransformation will hide the input
            )
        }

        // KeyboardOptions
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            val keyboardOptionCapitalizationOptions by lazy {
                listOf(
                    KeyboardOptions(capitalization = KeyboardCapitalization.None),
                    KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                    KeyboardOptions(capitalization = KeyboardCapitalization.Characters),
                    KeyboardOptions(capitalization = KeyboardCapitalization.Sentences),
                )
            }
            val keyboardTypes = remember {
                listOf(
                    KeyboardType.Text,
                    KeyboardType.Uri,
                    KeyboardType.Number,
                    KeyboardType.Ascii,
                    KeyboardType.Email,
                    KeyboardType.Decimal,
                    KeyboardType.NumberPassword,
                    KeyboardType.Password,
                    KeyboardType.Phone
                )
            }

            val imeActions = remember {
                listOf(
                    ImeAction.Done,
                    ImeAction.Go,
                    ImeAction.Next,
                    ImeAction.Previous,
                    ImeAction.Search,
                    ImeAction.None,
                    ImeAction.Send,
                    ImeAction.Default,
                )
            }
            keyboardOptionCapitalizationOptions.forEach { keyboardOptions ->
                OutlinedTextField(
                    value = inputText.value,
                    onValueChange = { inputText.value = it },
                    keyboardOptions = keyboardOptions
                )
            }

            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    autoCorrect = true,
                )
            )

            keyboardTypes.forEach { keyboardType ->
                OutlinedTextField(
                    value = inputText.value,
                    onValueChange = { inputText.value = it },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        autoCorrect = true,
                        keyboardType = keyboardType,
                    )
                )
            }

            imeActions.forEach { imeAction ->
                OutlinedTextField(
                    value = inputText.value,
                    onValueChange = { inputText.value = it },
                    keyboardOptions = KeyboardOptions(
                        imeAction = imeAction,
                    )
                )
            }

            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                keyboardOptions = KeyboardOptions(
                    platformImeOptions = PlatformImeOptions() // Used to configure the platform specific IME options.
                )
            )
        }

        // KeyboardActions
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                keyboardActions = KeyboardActions.Default
            )

            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                keyboardActions = KeyboardActions(
                    onDone = {
                        // do something
                    },
                    onGo = {
                        // do something
                    },
                    onNext = {
                        // do something
                    },
                    onPrevious = {
                        // do something
                    },
                    onSearch = {
                        // do something
                    },
                    onSend = {
                        // do something
                    }
                )
            )
        }

        //SingleLineTextField
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                singleLine = true // Note that maxLines parameter will be ignored as the maxLines attribute will be automatically set to 1.
            )
        }

        // MaxLines - MinLines - It is required that 1 <= minLines<= maxLines.
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                maxLines = 5,
                minLines = 3
            )
        }

        // Custom Interaction Source
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            val interactionSource = remember {
                MutableInteractionSource()
            }
            LaunchedEffect(key1 = interactionSource) {
                interactionSource.interactions.collectLatest {
                    when (it) {
                        is PressInteraction.Press -> {
                            // do something
                        }

                        is PressInteraction.Release -> {
                            // do something
                        }

                        is PressInteraction.Cancel -> {
                            // do something
                        }

                        is DragInteraction.Start -> {
                            // do something
                        }

                        is DragInteraction.Stop -> {
                            // do something
                        }

                        is DragInteraction.Cancel -> {
                            // do something
                        }

                        is HoverInteraction.Enter -> {
                            // do something
                        }

                        is HoverInteraction.Exit -> {
                            // do something
                        }

                        is FocusInteraction.Focus -> {
                            // do something
                        }

                        is FocusInteraction.Unfocus -> {
                            // do something
                        }
                    }
                }
            }

            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                interactionSource = interactionSource
            )
        }

        // Shape
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                shape = OutlinedTextFieldDefaults.shape // give any custom shape
            )
        }

        // Colors
        basicLayoutItem {
            val inputText = remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = inputText.value,
                onValueChange = { inputText.value = it },
                colors = OutlinedTextFieldDefaults.colors(
                    // give any custom colors
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.secondary,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    errorCursorColor = MaterialTheme.colorScheme.error,
                    errorBorderColor = MaterialTheme.colorScheme.error,
                    errorLabelColor = MaterialTheme.colorScheme.error,
                    errorLeadingIconColor = MaterialTheme.colorScheme.error,
                    errorTrailingIconColor = MaterialTheme.colorScheme.error,
                    errorSupportingTextColor = MaterialTheme.colorScheme.error,
                )
            )

        }

    }


}
