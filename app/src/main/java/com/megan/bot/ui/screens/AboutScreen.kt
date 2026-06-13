package com.megan.bot.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megan.bot.ui.theme.*

@Composable
fun AboutScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About Norbot", color = NorbotTextPrimary) },
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
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("🤖", fontSize = 72.sp)
            Spacer(Modifier.height(16.dp))
            Text("Norbot", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = NorbotTextPrimary)
            Text("AI-Powered Toolbox", fontSize = 16.sp, color = NorbotCyan)
            Spacer(Modifier.height(8.dp))
            Text("Version 1.0", color = NorbotTextSecondary)
            
            Spacer(Modifier.height(24.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Developer", fontWeight = FontWeight.Bold, color = NorbotTextPrimary, fontSize = 18.sp)
                    Spacer(Modifier.height(8.dp))
                    Text("Tracker Wanga", color = NorbotCyan, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("🇰🇪 Kenya", color = NorbotTextPrimary, fontSize = 16.sp)
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Norbot is your all-in-one AI assistant and toolbox. Access 33+ AI models, download media from social platforms, get news, play games, and much more!",
                        color = NorbotTextSecondary,
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text("Our Projects", fontWeight = FontWeight.Bold, color = NorbotTextPrimary, fontSize = 18.sp)
                    Spacer(Modifier.height(8.dp))
                    listOf(
                        "🌐 apis.megan.qzz.io" to "https://apis.megan.qzz.io",
                        "🎬 movieapi.megan.qzz.io" to "https://movieapi.megan.qzz.io",
                        "📱 apps.megan.qzz.io" to "https://apps.megan.qzz.io",
                        "🎥 movies.megan.qzz.io" to "https://movies.megan.qzz.io",
                        "🎵 music.megan.qzz.io" to "https://music.megan.qzz.io"
                    ).forEach { (name, url) ->
                        Text(
                            name,
                            color = NorbotCyan,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .clickable {
                                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                                }
                                .padding(vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(Modifier.height(32.dp))
            Text("Powered by Megan APIs", color = NorbotTextSecondary, fontSize = 12.sp, textAlign = TextAlign.Center)
        }
    }
}
