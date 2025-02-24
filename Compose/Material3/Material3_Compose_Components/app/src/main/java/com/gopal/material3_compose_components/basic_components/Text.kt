package com.gopal.material3_compose_components.basic_components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.StampedPathEffectStyle
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.EmojiSupportMatch
import androidx.compose.ui.text.PlatformParagraphStyle
import androidx.compose.ui.text.PlatformSpanStyle
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gopal.material3_compose_components.ui.theme.cu_font_family
import com.gopal.material3_compose_components.util.basicLayoutItem


@Preview(showBackground = true)
@Composable
private fun TextComposable_Prev() {
    TextComposable_Usages_Examples()
}


@Composable
fun TextComposable_Usages_Examples() {
    val verticalArrangement = remember { Arrangement.spacedBy(8.dp, Alignment.Top) }
    val modifierWithFillMaxWidth = remember { Modifier.fillMaxWidth() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top)
    ) {

        // Aligning text to different edges
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextAlign.values().forEach {
                if (it == TextAlign.Justify) {
                    TextComposable(
                        // modifier = Modifier.fillMaxWidth(),
                        text = "This is justified text..i.e;" +
                                "\nlines of text, that end with a soft line break, will be stretched to fill the width of the container. " +
                                "Lines that end with hard line breaks are aligned towards the Start edge." +
                                "That is the reason first line is aligned to Start and remaining lines took full width even without fillMaxWidth modifier",
                        style = TextStyle(
                            textAlign = it
                        )
                    )
                } else {
                    TextComposable(
                        modifier = modifierWithFillMaxWidth,
                        text = "This is text aligned to $it",
                        style = TextStyle(
                            textAlign = it
                        )
                    )

                }
            }
        }

        // Coloured text
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is coloured red",
                style = TextStyle(
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is coloured blue",
                style = TextStyle(
                    color = Color.Blue,
                    textAlign = TextAlign.Center
                )
            )
        }

        // Changing font size
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is over-sized text with 40sp font size",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 40.sp
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is under-sized text with 10sp font size",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp
                )
            )
        }

        // Changing font weight
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is bold",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            )

            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is extra bold",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is extra light",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraLight
                )
            )
        }

        // Changing font style
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            FontStyle.values().forEach {
                TextComposable(
                    modifier = modifierWithFillMaxWidth,
                    text = "This text is $it",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontStyle = it
                    )
                )
            }
        }

        // Using a custom font
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered using a custom font",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFamily = cu_font_family // -> This is a custom font with italic typeface
                )
            )
        }

        /**
         * FontSynthesis is used to specify whether the system should fake bold or slanted glyphs when the FontFamily used does not contain bold or oblique Fonts.
         *
         * If the font family does not include a requested FontWeight or FontStyle, the system fakes bold or slanted glyphs when the Weight or Style, respectively, or both when All is set. If this is not desired, use None to disable font synthesis.
         *
         * It is possible to fake an increase of FontWeight but not a decrease. It is possible to fake a regular font slanted, but not vice versa.
         */
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is fake bold",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSynthesis = FontSynthesis.Weight,
                    fontFamily = cu_font_family, // -> This is a custom font without bold typeface
                    fontWeight = FontWeight.Bold,
                )
            )
        }

        // Font feature settings
        // https://developer.mozilla.org/en-US/docs/Web/CSS/@font-face/font-feature-settings
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "The font-feature-settings CSS descriptor allows you to define the initial settings to use for the font defined by the @font-face at-rule. " +
                        "You can further use this descriptor to control typographic font features such as ligatures, small caps, and swashes, for the font defined by @font-face.",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontFeatureSettings = "smcp"
                )
            )
        }

        // Letter spacing
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is will have more letter spacing than normal",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    letterSpacing = 2.sp
                )
            )
        }

        // BaselineShift
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/BaselineShift
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            Text(
                modifier = modifierWithFillMaxWidth,
                text = buildAnnotatedString {
                    append("This text is ")
                    withStyle(style = SpanStyle(baselineShift = BaselineShift.Subscript)) {
                        append("Subscript")
                    }
                },
                textAlign = TextAlign.Center
            )
            Text(
                modifier = modifierWithFillMaxWidth,
                text = buildAnnotatedString {
                    append("This text is ")
                    withStyle(style = SpanStyle(baselineShift = BaselineShift.Superscript)) {
                        append("Superscript")
                    }
                },
                textAlign = TextAlign.Center
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is normal",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    baselineShift = BaselineShift.None
                )
            )
            Text(
                modifier = modifierWithFillMaxWidth,
                text = buildAnnotatedString {
                    append("This text is ")
                    withStyle(style = SpanStyle(baselineShift = BaselineShift(2f))) {
                        append("shifted up with custom float value")
                    }
                },
                textAlign = TextAlign.Center
            )
        }

        // TextGeometricTransform
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextGeometricTransform
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is scaled horizontally by a factor of 2x using TextGeometricTransform",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    textGeometricTransform = TextGeometricTransform(
                        scaleX = 2f
                    )
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is scaled horizontally by a factor of 2x and skewed horizontally by a factor of 1x using TextGeometricTransform",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    textGeometricTransform = TextGeometricTransform(
                        scaleX = 2f,
                        skewX = 1f
                    )
                )
            )
        }

        // LocaleList
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/intl/LocaleList
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is written using locale-list. i.e; when region changes this text will change automatically",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    localeList = LocaleList(
                        Locale("en"),
                        Locale("ja"),
                        Locale("kok"),
                        Locale("Latn")
                    )
                )
            )
        }

        // TextDecoration
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDecoration
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is underlined",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is struck through",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.LineThrough
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is normal",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.None
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is written using 2 or more text decorators at a time",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
                )
            )
        }

        // Shadowed text
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/Shadow
        // https://developer.android.com/develop/ui/compose/text/style-text#shadow
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is shadowed with color blue and offset of 5f horizontally and vertically 10f with a blur radius of 5f",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    shadow = Shadow(
                        color = Color.Blue,
                        offset = Offset(5f, 10f),
                        blurRadius = 5f
                    )
                )
            )
        }

        // DrawStyle
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/graphics/drawscope/DrawStyle
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered by using a draw style - Fill",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    drawStyle = Fill
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered by using a draw style - Stroke with width 2f, miter 2f, cap square and join miter",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    drawStyle = Stroke(
                        width = 2f,
                        miter = 2f,
                        cap = StrokeCap.Square,
                        join = StrokeJoin.Miter
                    )
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered by using a draw style - Stroke with width 2f, miter 2f, cap round and join round",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    drawStyle = Stroke(
                        width = 2f,
                        miter = 2f,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered by using a draw style - Stroke with width 2f, miter 2f, cap butt and join bevel",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    drawStyle = Stroke(
                        width = 2f,
                        miter = 2f,
                        cap = StrokeCap.Butt,
                        join = StrokeJoin.Bevel
                    )
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered by using a draw style - Stroke with width 2f, miter 2f, default cap and join but with corner path-effect with radius 5f",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    drawStyle = Stroke(
                        width = 2f,
                        miter = 2f,
                        cap = Stroke.DefaultCap,
                        join = Stroke.DefaultJoin,
                        pathEffect = PathEffect.cornerPathEffect(radius = 5f)
                    )
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered by using a draw style - Stroke with width 2f, miter 2f, default cap and join but with dash path-effect with intervals 0.5f and 1.5f and phase 5f",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    drawStyle = Stroke(
                        width = 2f,
                        miter = 2f,
                        cap = Stroke.DefaultCap,
                        join = Stroke.DefaultJoin,
                        pathEffect = PathEffect.dashPathEffect(
                            intervals = floatArrayOf(0.5f, 1.5f),
                            phase = 5f
                        )
                    )
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered by using a draw style - Stroke with width 2f, miter 2f, default cap and join but with stamp path-effect with shape Path() and advance 4f and phase 2f",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    drawStyle = Stroke(
                        width = 2f,
                        miter = 2f,
                        cap = Stroke.DefaultCap,
                        join = Stroke.DefaultJoin,
                        pathEffect = PathEffect.stampedPathEffect(
                            shape = Path(),
                            advance = 4f,
                            phase = 2f,
                            style = StampedPathEffectStyle.Rotate
                        )
                    )
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered by using a draw style - Stroke with width 2f, miter 2f, default cap and join but with chain path-effect with outer PathEffect.cornerPathEffect(radius = 6f) and inner PathEffect.stampedPathEffect(shape = Path(), advance = 4f, phase = 5f, style = StampedPathEffectStyle.Morph)",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    drawStyle = Stroke(
                        width = 2f,
                        miter = 2f,
                        cap = Stroke.DefaultCap,
                        join = Stroke.DefaultJoin,
                        pathEffect = PathEffect.chainPathEffect(
                            outer = PathEffect.cornerPathEffect(
                                radius = 6f
                            ),
                            inner = PathEffect.stampedPathEffect(
                                shape = Path(),
                                advance = 4f,
                                phase = 5f,
                                style = StampedPathEffectStyle.Morph
                            )
                        )
                    )
                )
            )
        }

        // TextDirection
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextDirection
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            val textDirections = remember {
                listOf(
                    TextDirection.Content,
                    TextDirection.ContentOrLtr,
                    TextDirection.ContentOrRtl,
                    TextDirection.Ltr,
                    TextDirection.Rtl,
                )
            }
            textDirections.forEach {
                TextComposable(
                    modifier = modifierWithFillMaxWidth,
                    text = "This text is rendered with direction of $it",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        textDirection = it
                    )
                )
            }
        }

        // LineHeight
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/LineHeightStyle
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text will have a more line height. So if we want to observe the line height of this text, obviously we need more text right!! Let's see",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    lineHeight = 12.sp
                )
            )
        }

        // TextIndent
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextIndent
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "TextIndent: Specify the indentation of a paragraph. Public companion properties: TextIndent.None Constant for no text indent. Public constructors TextIndent(firstLine: TextUnit, restLine: TextUnit) firstLine the amount of indentation applied to the first line. restLine the amount of indentation applied to every line except the first line.",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    textIndent = TextIndent(
                        firstLine = 24.sp,
                        restLine = 8.sp
                    )
                )
            )
        }

        // PlatformStyle
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/PlatformTextStyle
        // https://unicode.org/emoji/charts/emoji-versions.html
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text uses an emoji \uD83D\uDE07 \uD83E\uDD70. It has emoji support match",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    platformStyle = PlatformTextStyle(emojiSupportMatch = EmojiSupportMatch.Default)
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text uses an emoji \uD83D\uDE07 \uD83E\uDD70. It has no emoji support match",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    platformStyle = PlatformTextStyle(emojiSupportMatch = EmojiSupportMatch.None)
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text uses platformStyle with spanStyle - PlatformSpanStyle() and paragraphStyle - PlatformParagraphStyle()",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    platformStyle = PlatformTextStyle(
                        spanStyle = PlatformSpanStyle(),
                        paragraphStyle = PlatformParagraphStyle()
                    )
                )
            )
        }

        /**
         * LineHeightStyle
         * https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/LineHeightStyle
         *
         * The configuration for line height such as alignment of the line in the provided line height, whether to apply additional space as a result of line height to top of first line top and bottom of last line.
         *
         * The configuration is applied only when a **line height** is defined on the text.
         *
         * trim feature is available only when **PlatformParagraphStyle.includeFontPadding** is false.
         */
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            val lineHeightStyleAlignments = remember {
                listOf(
                    LineHeightStyle.Alignment.Bottom,
                    LineHeightStyle.Alignment.Center,
                    LineHeightStyle.Alignment.Top,
                    LineHeightStyle.Alignment.Proportional
                )
            }
            val lineHeightStyleTrims = remember {
                listOf(
                    LineHeightStyle.Trim.None,
                    LineHeightStyle.Trim.Both,
                    LineHeightStyle.Trim.FirstLineTop,
                    LineHeightStyle.Trim.LastLineBottom
                )
            }
            lineHeightStyleAlignments.zip(lineHeightStyleTrims)
                .forEach { (lineHeightStyleAlignment, lineHeightStyleTrim) ->
                    TextComposable(
                        modifier = modifierWithFillMaxWidth,
                        text = "This text is rendered with line height style alignment of $lineHeightStyleAlignment and line height style trim of $lineHeightStyleTrim",
                        style = TextStyle(
                            textAlign = TextAlign.Center,
                            lineHeight = 5.sp,
                            lineHeightStyle = LineHeightStyle(
                                alignment = lineHeightStyleAlignment,
                                trim = lineHeightStyleTrim
                            )
                        )
                    )
                }
        }

        // LineBreak
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/LineBreak
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            val lineBreakStyles = remember {
                listOf(
                    LineBreak.Unspecified,
                    LineBreak.Paragraph,
                    LineBreak.Simple,
                    LineBreak.Heading
                )
            }
            lineBreakStyles.forEach {
                TextComposable(
                    modifier = modifierWithFillMaxWidth,
                    text = "This text is rendered with line break style of $it",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        lineBreak = it
                    )
                )
            }
            // custom lineBreak
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This text is rendered with custom line break style of strategy Balanced, strictness Strict, wordBreak Phrase",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    lineBreak = LineBreak(
                        strategy = LineBreak.Strategy.Balanced,
                        strictness = LineBreak.Strictness.Strict,
                        wordBreak = LineBreak.WordBreak.Phrase
                    )
                )
            )
        }

        // Hyphens
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/Hyphens
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            val hyphens = remember {
                listOf(
                    Hyphens.None,
                    Hyphens.Auto,
                    Hyphens.Unspecified
                )
            }
            hyphens.forEach {
                TextComposable(
                    modifier = modifierWithFillMaxWidth,
                    text = "This text is rendered with hyphens style of $it",
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        hyphens = it
                    )
                )
            }
        }

        // TextMotion
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/text/style/TextMotion
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            val infiniteTransition = rememberInfiniteTransition(label = "textScaleInfinite")
            val scale by infiniteTransition.animateFloat(
                initialValue = 1f,
                targetValue = 3f,
                animationSpec = infiniteRepeatable(tween(1000), RepeatMode.Reverse),
                label = "textScale"
            )

            Text(
                text = "Hello",
                modifier = modifierWithFillMaxWidth
                    .height(150.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        transformOrigin = TransformOrigin.Center
                    },
                // Text composable does not take TextMotion as a parameter.
                // Provide it via style argument
                style = TextStyle(textMotion = TextMotion.Animated)
            )
        }

        // AnnotatedString-rainbow colours
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            val rainbowColors = remember {
                listOf(
                    Color.Red, Color(0xFFFFA500), Color.Yellow,
                    Color.Green, Color.Blue, Color(0xFF4B0082), Color(0xFFEE82EE)
                )
            }
            TextComposable(
                modifier = modifierWithFillMaxWidth,
                text = "This is a text rendered with the rainbow colors. The text will have a horizontal linear gradient brush with the rainbow colors.",
                style = TextStyle(
                    brush = Brush.linearGradient(colors = rainbowColors)
                )
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth.background(
                    brush = Brush.linearGradient(colors = rainbowColors)
                ),
                annotatedString = buildAnnotatedString {
                    append("This is a text rendered with the rainbow colors. The text will have a horizontal linear gradient background with the rainbow colors.")
                }
            )
            TextComposable(
                modifier = modifierWithFillMaxWidth.background(
                    brush = Brush.verticalGradient(colors = rainbowColors)
                ),
                annotatedString = buildAnnotatedString {
                    append("This is a text rendered with the rainbow colors. The text will have a vertical linear gradient background with the rainbow colors.")
                }
            )
        }

        // Clickable Text
        // https://developer.android.com/reference/kotlin/androidx/compose/foundation/text/ClickableText
        // Practical use-case of ClickableText
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {
            val tnc = "Terms and Conditions"
            val privacyPolicy = "Privacy Policy"
            val annotatedString = remember {
                buildAnnotatedString {
                    append("I have read")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        pushStringAnnotation(tag = tnc, annotation = tnc)
                        append(tnc)
                    }
                    append(" and ")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        pushStringAnnotation(tag = privacyPolicy, annotation = privacyPolicy)
                        append(privacyPolicy)
                    }
                }
            }
            ClickableText(text = annotatedString, onClick = { offset ->
                annotatedString.getStringAnnotations(offset, offset)
                    .firstOrNull()?.let { span ->
                        println("Clicked on ${span.item}")
                    }
            })
        }

        // Selectable Text
        // https://developer.android.com/reference/kotlin/androidx/compose/foundation/text/selection/package-summary#SelectionContainer(androidx.compose.ui.Modifier,kotlin.Function0)
        // https://stackoverflow.com/questions/68779305/how-to-change-textfields-highlighted-text-color-on-jetpack-compose
        basicLayoutItem(
            verticalArrangement = verticalArrangement
        ) {

            SelectionContainer {
                Column {
                    TextComposable(
                        modifierWithFillMaxWidth,
                        "This text is selectable and it is in column-1"
                    )
                    TextComposable(
                        modifierWithFillMaxWidth,
                        "This text is selectable and it is in column-2"
                    )
                }
            }
            DisableSelection {
                TextComposable(
                    modifierWithFillMaxWidth,
                    "This text is not selectable as it is in DisableSelection composable"
                )
            }
            TextComposable(
                modifierWithFillMaxWidth,
                "This text has default behaviour as it is not in either of the SelectionContainer or DisableSelection composables"
            )

            val localHandleColor = LocalTextSelectionColors.current.handleColor
            val customBackgroundSelectionColor = remember {
                TextSelectionColors(
                    backgroundColor = Color.Red.copy(alpha = 0.3f),
                    handleColor = localHandleColor
                )
            }
            CompositionLocalProvider(value = LocalTextSelectionColors provides customBackgroundSelectionColor) {
                SelectionContainer {
                    TextComposable(
                        modifier = modifierWithFillMaxWidth,
                        text = "This text when selected has different background."
                    )
                }
            }

            val customTextSelectionColors = remember {
                TextSelectionColors(
                    backgroundColor = Color.Gray.copy(0.3f),
                    handleColor = Color.Green
                )
            }
            CompositionLocalProvider(value = LocalTextSelectionColors provides customTextSelectionColors) {
                SelectionContainer {
                    TextComposable(
                        modifier = modifierWithFillMaxWidth,
                        text = "This text when selected has different background and has different handle color."
                    )
                }
            }
        }

    }
}

/**
 * Use this composable to display text.
 *
 * @param text The text to display.
 * @param style The style of the text.
 * Instead of defining style parameters individually, you can use a TextStyle object.
 */
@Composable
private fun TextComposable(
    modifier: Modifier = Modifier,
    text: String = "This is some text",
    style: TextStyle = TextStyle.Default
) {
    Text(
        modifier = modifier,
        text = text,
        style = style
    )
}

@Composable
private fun TextComposable(
    modifier: Modifier = Modifier,
    annotatedString: AnnotatedString,
    style: TextStyle = TextStyle.Default
) {
    Text(
        modifier = modifier,
        text = annotatedString,
        style = style
    )
}



