package com.example.tipapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tipapplication.ui.theme.TipApplicationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->
                    MainLayout();
                }
            }
        }
    }
}
class AppState {
    var priceOfOrder by mutableStateOf("");
    var numberOfDishes by mutableStateOf("");
    var percentage by mutableStateOf("");
    var selectedDiscountRadioButton by mutableStateOf("");

    var disccountOptions: List<Int> = listOf(3,5,7,10);
}

@Composable
fun PriceOfOrderInputField(state: AppState) {
    Row(modifier = Modifier.padding(16.dp),
        verticalAlignment = CenterVertically
    )
    {
        Text(
            text = "Сумма Заказа",
            modifier = Modifier.width(150.dp)
        )

        OutlinedTextField(
            value = state.priceOfOrder,
            onValueChange = { newText ->
                if (newText.all { it.isDigit() } || newText.isEmpty()) {
                    state.priceOfOrder = newText
                }
            },

            label = { Text("Введите число") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun NumberOfDishesInputField(state: AppState) {
    Row(modifier = Modifier.padding(16.dp),
        verticalAlignment = CenterVertically
    )
    {
        Text(
            text = "Количество блюд",
            modifier = Modifier.width(150.dp)
        )

        OutlinedTextField(
            value = state.numberOfDishes,
            onValueChange = { newText ->
                if (newText.all { it.isDigit() } || newText.isEmpty()) {
                    state.numberOfDishes = newText
                }
            },

            label = { Text("Введите число") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun PercentageSlider(state: AppState) {
}

@Composable
fun DiscountRadioButtons(state: AppState) {

}

@Composable
fun ResultTextField(state: AppState) {

}

@Preview
@Composable
fun MainLayout() {
    val state = remember { AppState() }

    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        PriceOfOrderInputField(state);
        NumberOfDishesInputField(state);
        PercentageSlider(state);
        DiscountRadioButtons(state);
        ResultTextField(state);
    }
}