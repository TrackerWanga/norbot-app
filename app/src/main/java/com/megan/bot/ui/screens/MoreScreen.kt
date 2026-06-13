@file:OptIn(ExperimentalMaterial3Api::class)
package com.megan.bot.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megan.bot.ui.theme.*

data class MoreItem(val icon: ImageVector, val title: String, val subtitle: String, val route: String, val color: Color)

val moreItems = listOf(
    MoreItem(Icons.Filled.SportsEsports, "Games", "Fun games & challenges", "games", NorbotNeonGreen),
    MoreItem(Icons.Filled.Security, "Security Tools", "WHOIS, DNS, SSL & more", "security", NorbotError),
    MoreItem(Icons.Filled.CurrencyBitcoin, "Crypto", "Live cryptocurrency prices", "crypto", NorbotWarning),
    MoreItem(Icons.Filled.TrendingUp, "Forex", "Currency exchange rates", "forex", NorbotSuccess),
    MoreItem(Icons.Filled.Cloud, "Weather", "Check any city weather", "weather", NorbotCyan),
    MoreItem(Icons.Filled.Info, "About Norbot", "App info & developer", "about", NorbotPurple),
    MoreItem(Icons.Filled.ContactMail, "Contact Tracker", "Get in touch", "contact", NorbotCyan)
)

@Composable
fun MoreScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("More", color = NorbotTextPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(moreItems.size) { index ->
                val item = moreItems[index]
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { navController.navigate(item.route) },
                    colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(item.icon, null, tint = item.color, modifier = Modifier.size(36.dp))
                        Spacer(Modifier.width(16.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(item.title, color = NorbotTextPrimary, fontWeight = FontWeight.SemiBold)
                            Text(item.subtitle, color = NorbotTextSecondary, fontSize = 13.sp)
                        }
                        Icon(Icons.Filled.ChevronRight, null, tint = NorbotTextSecondary)
                    }
                }
            }

            // Norbot Info Card
            item {
                Spacer(Modifier.height(16.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = NorbotPurple.copy(alpha = 0.15f)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("🤖", fontSize = 48.sp)
                        Spacer(Modifier.height(8.dp))
                        Text("Norbot v1.0", color = NorbotTextPrimary, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text("by Tracker Wanga", color = NorbotTextSecondary, fontSize = 14.sp)
                        Spacer(Modifier.height(4.dp))
                        Text("🇰🇪 Made in Kenya", color = NorbotSuccess, fontSize = 13.sp)
                    }
                }
            }
        }
    }
}
