package com.faustino.faustitalk.View.Components.Inputs

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Calendar

@Composable
fun CustomDatePicker(
    value: (String) -> Unit
) {

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    var selectedDate by remember { mutableStateOf("dd/mm/yyyy") }

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            selectedDate = "${selectedDay}/${selectedMonth + 1}/$selectedYear"
            value(selectedDate)
        }, year, month, day
    )

    Row(
        modifier = Modifier

            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White.copy(alpha = 0.04f), RoundedCornerShape(15.dp))
            .border(1.dp, Color.Transparent, RoundedCornerShape(15.dp))
            .clickable { datePickerDialog.show() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = selectedDate,
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )

        Icon(
            imageVector = Icons.Filled.DateRange,
            contentDescription = "Calendar Icon",
            tint = Color.White.copy(alpha = 0.5f)
        )
    }
}
/*
@Preview(device = "spec:width=1344px,height=2992px,dpi=480")
@Composable
fun CustomDatePickerPreview() {
    CustomDatePicker(

    )
}
*/