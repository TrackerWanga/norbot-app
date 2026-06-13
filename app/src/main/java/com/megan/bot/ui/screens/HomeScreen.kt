package com.megan.bot.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megan.bot.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            "🤖 Norbot",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = NorbotTextPrimary
                        )
                        Text(
                            "by Tracker Wanga 🇰🇪",
                            fontSize = 14.sp,
                            color = NorbotTextSecondary
                        )
                    }
                    IconButton(onClick = { navController.navigate("about") }) {
                        Icon(Icons.Filled.Info, "About", tint = NorbotCyan)
                    }
                }
            }

            // Quick Actions
            item {
                Text("Quick Actions", fontWeight = FontWeight.SemiBold, color = NorbotTextPrimary)
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(quickActions) { action ->
                        QuickActionCard(action) {
                            when (action.route) {
                                "ai_chat" -> navController.navigate("ai_chat")
                                "youtube" -> navController.navigate("youtube_downloader")
                                "tiktok" -> navController.navigate("tiktok_downloader")
                                "instagram" -> navController.navigate("instagram_downloader")
                                "news" -> navController.navigate("news")
                                "crypto" -> navController.navigate("crypto")
                                "games" -> navController.navigate("games")
                                else -> scope.launch { snackbarHostState.showSnackbar("Coming soon!") }
                            }
                        }
                    }
                }
            }

            // AI Models
            item {
                Text("AI Models", fontWeight = FontWeight.SemiBold, color = NorbotTextPrimary)
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(aiModels.take(10)) { model ->
                        AIModelChip(model) { navController.navigate("ai_model/$model") }
                    }
                }
            }

            // Recent Activity
            item {
                Text("Trending Tools", fontWeight = FontWeight.SemiBold, color = NorbotTextPrimary)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        ToolRow("🎵 YouTube Downloader", "Most used today") { navController.navigate("youtube_downloader") }
                        ToolRow("🤖 GPT Chat", "33 AI models") { navController.navigate("ai_chat") }
                        ToolRow("📰 Kenya News", "Daily updates") { navController.navigate("news") }
                        ToolRow("💱 Forex Rates", "KES/USD live") { navController.navigate("forex") }
                    }
                }
            }
        }
    }
}

data class QuickAction(val icon: ImageVector, val label: String, val route: String, val color: Color)

val quickActions = listOf(
    QuickAction(Icons.Filled.Chat, "AI Chat", "ai_chat", NorbotPurple),
    QuickAction(Icons.Filled.YouTube, "YouTube", "youtube", NorbotCyan),
    QuickAction(Icons.Filled.MusicNote, "TikTok", "tiktok", NorbotNeonGreen),
    QuickAction(Icons.Filled.Camera, "Instagram", "instagram", NorbotWarning),
    QuickAction(Icons.Filled.Newspaper, "News", "news", NorbotSuccess),
    QuickAction(Icons.Filled.CurrencyBitcoin, "Crypto", "crypto", NorbotError),
    QuickAction(Icons.Filled.SportsEsports, "Games", "games", NorbotCyan)
)

val aiModels = listOf(
    "gpt", "claude", "mistral", "gemini", "deepseek", "llama",
    "mixtral", "phi", "qwen", "falcon", "vicuna", "codellama",
    "dolphin", "nous", "openhermes", "neural", "solar", "yi",
    "orca", "command", "nemotron", "internlm", "chatglm", "wormgpt"
)

@Composable
fun QuickActionCard(action: QuickAction, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = action.color.copy(alpha = 0.15f)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(action.icon, null, tint = action.color, modifier = Modifier.size(32.dp))
            Spacer(Modifier.height(8.dp))
            Text(action.label, fontSize = 11.sp, textAlign = TextAlign.Center, color = NorbotTextPrimary)
        }
    }
}

@Composable
fun AIModelChip(model: String, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        color = NorbotPurple.copy(alpha = 0.2f)
    ) {
        Text(
            "🤖 ${model.replaceFirstChar { it.uppercase() }}",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = NorbotTextPrimary,
            fontSize = 13.sp
        )
    }
}

@Composable
fun ToolRow(label: String, subtitle: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(label, color = NorbotTextPrimary, fontWeight = FontWeight.Medium)
            Text(subtitle, color = NorbotTextSecondary, fontSize = 12.sp)
        }
        Icon(Icons.Filled.ChevronRight, null, tint = NorbotTextSecondary)
    }
    HorizontalDivider(color = NorbotTextSecondary.copy(alpha = 0.1f))
}
