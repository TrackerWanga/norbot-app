@file:OptIn(ExperimentalMaterial3Api::class)
package com.megan.bot.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megan.bot.ui.theme.*

data class ToolCategory(
    val name: String,
    val icon: ImageVector,
    val tools: List<ToolItem>
)

data class ToolItem(
    val name: String,
    val icon: ImageVector,
    val route: String,
    val color: Color
)

val toolCategories = listOf(
    ToolCategory("Crypto & Finance", Icons.Filled.CurrencyBitcoin, listOf(
        ToolItem("Crypto Prices", Icons.Filled.CurrencyBitcoin, "crypto", NorbotWarning),
        ToolItem("Forex Rates", Icons.Filled.TrendingUp, "forex", NorbotSuccess),
        ToolItem("Weather", Icons.Filled.Cloud, "weather", NorbotCyan)
    )),
    ToolCategory("Games & Fun", Icons.Filled.SportsEsports, listOf(
        ToolItem("Games", Icons.Filled.SportsEsports, "games", NorbotNeonGreen),
        ToolItem("Dad Jokes", Icons.Filled.EmojiEmotions, "dad_joke", NorbotWarning),
        ToolItem("Kenyan Proverbs", Icons.Filled.MenuBook, "proverbs", NorbotSuccess)
    )),
    ToolCategory("Security", Icons.Filled.Security, listOf(
        ToolItem("Security Tools", Icons.Filled.Shield, "security", NorbotError),
        ToolItem("Password Audit", Icons.Filled.Lock, "password_audit", NorbotWarning)
    ))
)

@Composable
fun ToolsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🛠️ Tools", color = NorbotTextPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(toolCategories) { category ->
                Text(category.name, fontWeight = FontWeight.SemiBold, color = NorbotTextPrimary, fontSize = 18.sp)
                category.tools.forEach { tool ->
                    Card(
                        modifier = Modifier.fillMaxWidth().clickable { navController.navigate(tool.route) },
                        colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(tool.icon, null, tint = tool.color, modifier = Modifier.size(32.dp))
                            Spacer(Modifier.width(16.dp))
                            Text(tool.name, color = NorbotTextPrimary, fontWeight = FontWeight.Medium)
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                }
            }
        }
    }
}
