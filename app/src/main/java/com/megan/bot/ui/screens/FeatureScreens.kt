@file:OptIn(ExperimentalMaterial3Api::class)
package com.megan.bot.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megan.bot.data.api.ApiClient
import com.megan.bot.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun CryptoScreen(navController: NavController) {
    var coin by remember { mutableStateOf("bitcoin") }
    var result by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("💱 Crypto", color = NorbotTextPrimary) },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back", tint = NorbotCyan) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            OutlinedTextField(value = coin, onValueChange = { coin = it }, modifier = Modifier.fillMaxWidth(), label = { Text("Coin (bitcoin, ethereum...)") })
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = {
                    scope.launch {
                        try {
                            val r = ApiClient.instance.getCryptoPrice(coin)
                            result = "💰 ${coin.uppercase()}: ${r.result?.price ?: "N/A"}"
                        } catch (e: Exception) { result = "❌ ${e.message}" }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = NorbotWarning),
                shape = RoundedCornerShape(12.dp)
            ) { Text("Get Price") }
            if (result.isNotEmpty()) {
                Spacer(Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = NorbotDarkCard)) {
                    Text(result, modifier = Modifier.padding(16.dp), color = NorbotTextPrimary)
                }
            }
        }
    }
}

@Composable
fun ForexScreen(navController: NavController) {
    var result by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        try {
            val r = ApiClient.instance.getForexRates()
            val rates = r.result?.rates
            result = buildString {
                append("💱 USD Base Rate\n")
                append("🇰🇪 KES: ${rates?.get("KES")}\n")
                append("🇪🇺 EUR: ${rates?.get("EUR")}\n")
                append("🇬🇧 GBP: ${rates?.get("GBP")}\n")
                append("🇺🇬 UGX: ${rates?.get("UGX")}\n")
                append("🇹🇿 TZS: ${rates?.get("TZS")}\n")
                append("🇳🇬 NGN: ${rates?.get("NGN")}\n")
                append("🇿🇦 ZAR: ${rates?.get("ZAR")}")
            }
        } catch (e: Exception) { result = "❌ ${e.message}" }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("💱 Forex", color = NorbotTextPrimary) },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back", tint = NorbotCyan) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
            Card(modifier = Modifier.padding(16.dp), colors = CardDefaults.cardColors(containerColor = NorbotDarkCard)) {
                Text(result, modifier = Modifier.padding(24.dp), color = NorbotTextPrimary, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun WeatherScreen(navController: NavController) {
    var city by remember { mutableStateOf("Nairobi") }
    var result by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🌤 Weather", color = NorbotTextPrimary) },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back", tint = NorbotCyan) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            OutlinedTextField(value = city, onValueChange = { city = it }, modifier = Modifier.fillMaxWidth(), label = { Text("City") })
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = {
                    scope.launch {
                        try {
                            val r = ApiClient.instance.getWeather(city)
                            val w = r.result
                            result = "📍 ${w?.location}\n🌡 ${w?.temperature}\n🤔 ${w?.feelsLike}\n💧 ${w?.humidity}\n🌥 ${w?.description}\n💨 ${w?.windSpeed}"
                        } catch (e: Exception) { result = "❌ ${e.message}" }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = NorbotCyan),
                shape = RoundedCornerShape(12.dp)
            ) { Text("Check Weather") }
            if (result.isNotEmpty()) {
                Spacer(Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = NorbotDarkCard)) {
                    Text(result, modifier = Modifier.padding(16.dp), color = NorbotTextPrimary)
                }
            }
        }
    }
}

@Composable
fun GamesScreen(navController: NavController) {
    var result by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    val games = listOf(
        "🎮 Rock Paper Scissors" to "rps",
        "📖 Dad Joke" to "joke",
        "🇰🇪 Kenyan Proverb" to "proverb",
        "🦁 Zodiac Sign" to "zodiac"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🎮 Fun & Games", color = NorbotTextPrimary) },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back", tint = NorbotCyan) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(games.size) { index ->
                val (name, id) = games[index]
                Card(
                    modifier = Modifier.fillMaxWidth().clickable {
                        scope.launch {
                            try {
                                result = when (id) {
                                    "rps" -> {
                                        val r = ApiClient.instance.playRPS("rock")
                                        "🤖 ${r.result?.computerEmoji} Computer: ${r.result?.computer}\n${r.result?.message}"
                                    }
                                    "joke" -> {
                                        val r = ApiClient.instance.getDadJoke()
                                        "😂 ${r.result?.joke}"
                                    }
                                    "proverb" -> {
                                        val r = ApiClient.instance.getKenyanProverb()
                                        "🇰🇪 ${r.result?.proverb}\n\nMeaning: ${r.result?.meaning}"
                                    }
                                    "zodiac" -> {
                                        val r = ApiClient.instance.getZodiac("leo")
                                        "${r.result?.symbol} ${r.result?.name}\n${r.result?.dailyHoroscope}"
                                    }
                                    else -> "Coming soon!"
                                }
                            } catch (e: Exception) { result = "❌ ${e.message}" }
                        }
                    },
                    colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(name, modifier = Modifier.padding(20.dp), color = NorbotTextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
                }
            }
            if (result.isNotEmpty()) {
                item {
                    Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = NorbotNeonGreen.copy(alpha = 0.1f))) {
                        Text(result, modifier = Modifier.padding(16.dp), color = NorbotTextPrimary)
                    }
                }
            }
        }
    }
}

@Composable
fun SecurityScreen(navController: NavController) {
    var domain by remember { mutableStateOf("google.com") }
    var result by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🛡 Security", color = NorbotTextPrimary) },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Filled.ArrowBack, "Back", tint = NorbotCyan) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            OutlinedTextField(value = domain, onValueChange = { domain = it }, modifier = Modifier.fillMaxWidth(), label = { Text("Domain") })
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = {
                    scope.launch {
                        try {
                            val r = ApiClient.instance.whoisLookup(domain)
                            val w = r.result
                            result = "🔍 ${w?.domain}\n📛 ${w?.name}\n📋 Status: ${w?.status?.joinToString()}"
                        } catch (e: Exception) { result = "❌ ${e.message}" }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = NorbotError),
                shape = RoundedCornerShape(12.dp)
            ) { Text("WHOIS Lookup") }
            if (result.isNotEmpty()) {
                Spacer(Modifier.height(16.dp))
                Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = NorbotDarkCard)) {
                    Text(result, modifier = Modifier.padding(16.dp), color = NorbotTextPrimary)
                }
            }
        }
    }
}
