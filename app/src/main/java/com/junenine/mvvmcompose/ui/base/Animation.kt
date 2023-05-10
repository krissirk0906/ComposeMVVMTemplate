package com.junenine.composeWithMVVM.ui.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.compose.*

@Composable
fun LottieAnimationView(
    animationSpec: LottieCompositionSpec,
    modifier: Modifier = Modifier,
    repeatCount: Int = LottieConstants.IterateForever
) {
    val composition by rememberLottieComposition(spec = animationSpec)
    val animationState =
        animateLottieCompositionAsState(composition = composition, iterations = repeatCount)
    LottieAnimation(
        modifier = modifier,
        composition = composition,
        contentScale = ContentScale.Fit,
        progress = { animationState.progress },
    )
}
