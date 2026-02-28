package com.example.flightinfoapp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flightinfoapp.ui.theme.FlightinfoappTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FlightinfoappTheme {
                Greeting()
            }
        }
    }
}
data class Flight(
    val from: String,
    val to: String,
    val flightNo: String,
    val time: String,
    val status: String
)
@Composable
fun Greeting() {

    val flights = listOf(
        Flight("Hyderabad", "Delhi", "AI-202", "10:45 AM", "On Time"),
        Flight("Mumbai", "Chennai", "6E-450", "12:30 PM", "Delayed"),
        Flight("Bangalore", "Kolkata", "UK-808", "03:15 PM", "Boarding"),
        Flight("Delhi", "Goa", "AI-990", "06:00 PM", "On Time")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        items(flights) { flight ->
            FlightCard(flight)
        }
    }
}
@Composable
fun FlightCard(flight: Flight) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "${flight.from} → ${flight.to}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Flight: ${flight.flightNo}")
            Text("Departure: ${flight.time}")

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Status: ${flight.status}",
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}