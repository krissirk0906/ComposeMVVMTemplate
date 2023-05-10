package com.junenine.mvvmcompose.ui.theme

import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.junenine.mvvmcompose.ui.components.home.MyViewModel
import com.junenine.mvvmcompose.R
import com.junenine.mvvmcompose.data.model.SampleResponse

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Main(viewModel: MyViewModel) {
//    val viewModel = hiltViewModel<MyViewModel>()
    AppTheme() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {
            val quote: SampleResponse? by viewModel.quote.observeAsState()
            val loadingState: Boolean? by viewModel.isLoading.observeAsState()
            val answer: String? by viewModel.calculateResult.collectAsState()
            Text(text = quote?.content ?: "", color = Color.Black, fontSize = 20.sp)
            Button(
                onClick = { viewModel.callRepo() },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = if (loadingState == true) "loading" else "fetch quote",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            val textState = remember { mutableStateOf(TextFieldValue()) }
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it }
            )
            Button(
                onClick = { viewModel.calCalculate(textState.value) },
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Red
                )
            ) {
                Text("Calculate")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Math result", color = Color.Black, fontSize = 20.sp)
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = answer ?: "", color = Color.Black, fontSize = 20.sp)


            ShowAnimateContentSizeSample()
        }
    }
}

@Composable
fun ShowAnimateContentSizeSample(modifier: Modifier = Modifier) {

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .clickable {
                expanded = !expanded
            }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Text("Text which is showing all the time")
        Spacer(modifier.height(20.dp))
        if (expanded) {
            Text("Some text to show or hide with animation as the column is clicked")
        }
    }

}

@Composable
fun ShowSwitchSample() {
    val checkedState = remember { mutableStateOf(true) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(20.dp)
    ) {
        Text("Enable Switch")
        Switch(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it }
        )
    }
}

@Composable
fun ShowRadioButtonSample() {
    val genderRadioOptions = listOf("Male", "Female", "Transgender")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(genderRadioOptions[1]) }
    Column(verticalArrangement = Arrangement.Center) {
        genderRadioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}


@Composable
fun ShowCircularProgressSample() {
    val progress by remember { mutableStateOf(0.5f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.height(10.dp))
        Text("Indeterminate CircularProgressIndicator")
        CircularProgressIndicator()
        Spacer(Modifier.height(40.dp))
        Text("Determinate CircularProgressIndicator")
        CircularProgressIndicator(progress = animatedProgress)
    }
}

@Composable
fun ShowSurfaceSample() {
    Surface(
        modifier = Modifier.padding(8.dp),
        border = BorderStroke(2.dp, Color.Black),
        contentColor = Color.Blue,
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp),
        color = Color.DarkGray
    ) {
        CustomTextField(
            modifier = Modifier
                .padding(all = 10.dp)
                .fillMaxWidth(),
            labelResId = R.string.app_name,
            inputWrapper = "empName",
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            maxLength = 50,
            maxLines = 1
        ) {

        }
    }
}

@Composable
fun ScrollBoxes() {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .size(100.dp)
            .verticalScroll(rememberScrollState())
    ) {
        repeat(10) {
            Text("Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}

@Composable
fun CustomTextField(
    modifier: Modifier,
    keyboardOptions: KeyboardOptions = remember { KeyboardOptions.Default },
    inputWrapper: String,
    @StringRes labelResId: Int,
    maxLength: Int,
    maxLines: Int,
    onTextChanged: (String) -> Unit
) {
    var fieldValue by remember { mutableStateOf(inputWrapper) }
    val focusManager = LocalFocusManager.current
    Column {
        OutlinedTextField(
            value = fieldValue,
            label = { Text(stringResource(labelResId), style = MaterialTheme.typography.caption) },
            maxLines = maxLines,
            keyboardOptions = keyboardOptions,
            modifier = modifier,
            onValueChange = {
                if (it.length <= maxLength) {
                    fieldValue = it
                    //text = value.filter { it.isDigit() }
                    onTextChanged(it)
                }
            },
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                },
                onDone = {
                    focusManager.clearFocus()
                }
            ),
        )

    }
}

@Composable
fun ScrollableSample() {
    // actual composable state
    var offset by remember { mutableStateOf(0f) }
    Box(
        Modifier
            .size(150.dp)
            .scrollable(
                orientation = Orientation.Vertical,
                // Scrollable state: describes how to consume
                // scrolling delta and update offset
                state = rememberScrollableState { delta ->
                    offset += delta
                    delta
                }
            )
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(offset.toString())
    }
}

@Preview
@Composable
fun ReviewScrollBox() {
    ScrollBoxes()
}