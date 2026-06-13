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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megan.bot.ui.theme.*

data class DownloadOption(
    val icon: ImageVector,
    val title: String,
    val description: String,
    val route: String,
    val color: androidx.compose.ui.graphics.Color
)

val downloadOptions = listOf(
    DownloadOption(Icons.Filled.YouTube, "YouTube Downloader", "Download videos & audio", "youtube_downloader", NorbotCyan),
    DownloadOption(Icons.Filled.MusicNote, "TikTok Downloader", "No watermark videos", "tiktok_downloader", NorbotNeonGreen),
    DownloadOption(Icons.Filled.Camera, "Instagram Downloader", "Reels, posts, stories", "instagram_downloader", NorbotWarning),
    DownloadOption(Icons.Filled.Facebook, "Facebook Downloader", "Videos & reels", "facebook_downloader", NorbotPurple)
)

@Composable
fun DownloadScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📥 Downloads", color = NorbotTextPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(downloadOptions) { option ->
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { navController.navigate(option.route) },
                    colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(option.icon, null, tint = option.color, modifier = Modifier.size(40.dp))
                        Spacer(Modifier.width(16.dp))
                        Column {
                            Text(option.title, color = NorbotTextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                            Text(option.description, color = NorbotTextSecondary, fontSize = 13.sp)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun YouTubeDownloadScreen(navController: NavController) {
    DownloaderScreen(
        navController = navController,
        title = "YouTube Downloader",
        icon = "🎵",
        placeholder = "Paste YouTube URL or search..."
    )
}

@Composable
fun TikTokDownloadScreen(navController: NavController) {
    DownloaderScreen(
        navController = navController,
        title = "TikTok Downloader",
        icon = "🎬",
        placeholder = "Paste TikTok URL..."
    )
}

@Composable
fun InstagramDownloadScreen(navController: NavController) {
    DownloaderScreen(
        navController = navController,
        title = "Instagram Downloader",
        icon = "📸",
        placeholder = "Paste Instagram URL..."
    )
}

@Composable
fun FacebookDownloadScreen(navController: NavController) {
    DownloaderScreen(
        navController = navController,
        title = "Facebook Downloader",
        icon = "📘",
        placeholder = "Paste Facebook URL..."
    )
}

@Composable
fun DownloaderScreen(navController: NavController, title: String, icon: String, placeholder: String) {
    var url by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("$icon $title", color = NorbotTextPrimary) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "Back", tint = NorbotCyan)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = url,
                onValueChange = { url = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(placeholder, color = NorbotTextSecondary) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = NorbotPurple,
                    unfocusedBorderColor = NorbotTextSecondary.copy(alpha = 0.3f)
                )
            )
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    scope.launch {
                        isLoading = true
                        try {
                            val response = ApiClient.instance.downloadYouTube(url = url)
                            result = "✅ ${response.title}\nQuality: ${response.quality}\n${response.downloadUrl}"
                        } catch (e: Exception) {
                            result = "❌ ${e.message}"
                        }
                        isLoading = false
                    }
                },
                enabled = url.isNotBlank() && !isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = NorbotPurple),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                if (isLoading) CircularProgressIndicator(modifier = Modifier.size(20.dp), color = NorbotTextPrimary)
                else Text("Download", modifier = Modifier.padding(vertical = 8.dp))
            }

            if (result.isNotEmpty()) {
                Spacer(Modifier.height(16.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(result, modifier = Modifier.padding(16.dp), color = NorbotTextPrimary)
                }
            }
        }
    }
}
