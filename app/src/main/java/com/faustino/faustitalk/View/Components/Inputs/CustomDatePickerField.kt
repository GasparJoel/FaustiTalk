package com.faustino.faustitalk.View.Components.Inputs

import android.app.DatePickerDialog
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faustino.faustitalk.ui.theme.Green300
import java.util.Calendar

@Composable
fun CustomDatePickerField(
    label: String,
    selectedDate: String,
    onDateSelected: (String) -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = "${selectedDay}/${selectedMonth + 1}/$selectedYear"
                onDateSelected(formattedDate)
            }, year, month, day
        )
    }

    OutlinedTextField(
        value = selectedDate,
        onValueChange = {},
        label = { androidx.compose.material3.Text(text = label) },
        placeholder = { androidx.compose.material3.Text(text = label, color = Color.White.copy(alpha = 0.5f)) },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    datePickerDialog.show()
                })
            },
        shape = RoundedCornerShape(15.dp),
        singleLine = true,
        colors = androidx.compose.material3.OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Green300,
            unfocusedBorderColor = Color.Transparent,
            focusedLabelColor = Green300,
            unfocusedContainerColor = Color.White.copy(alpha = 0.1f),
            focusedContainerColor = Color.White.copy(alpha = 0.04f)
        ),
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        ),
        readOnly = true
    )
}

//
//@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
//@Composable
//fun CustomDatePickerFieldPreview() {
//    var selectedDate by remember { mutableStateOf("Select Date") }
//
//    CustomDatePickerField(
//        label = "Select Date",
//        selectedDate = selectedDate,
//        onDateSelected = { date ->
//            selectedDate = date
//        }
//    )
//}
