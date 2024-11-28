package com.junenine.composeTemplate.ui.custom

import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.junenine.composeTemplate.utils.findActivity

@Composable
fun FullScreenDialog(
    onDialogDismiss: () -> Unit = {},
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val activity = context.findActivity()

    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(
            usePlatformDefaultWidth = true,
            decorFitsSystemWindows = false
        )
    ) {
        val activityWindow = activity.window
        val dialogWindow = (LocalView.current.parent as? DialogWindowProvider)?.window
        val parentView = LocalView.current.parent as View
        SideEffect {
            if (activityWindow != null && dialogWindow != null) {
                val attributes = WindowManager.LayoutParams()
                attributes.copyFrom(activityWindow.attributes)
                attributes.type = dialogWindow.attributes.type
                dialogWindow.attributes = attributes
                parentView.layoutParams = FrameLayout.LayoutParams(
                    activityWindow.decorView.width,
                    activityWindow.decorView.height
                )
            }
        }

        content()
    }
}