package vn.junenine.moma.ui.base

import androidx.compose.runtime.Composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*

@Composable
fun JuneNineButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = Color.Blue,
    contentColor: Color = Color.White,
    textSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    buttonPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    shape: Shape = RoundedCornerShape(8.dp),
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        contentPadding = buttonPadding,
        shape = shape,
    ) {
        Text(
            text = text,
            fontSize = textSize,
            fontWeight = fontWeight,
        )
    }
}
