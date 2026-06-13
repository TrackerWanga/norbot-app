@file:OptIn(ExperimentalMaterial3Api::class)
package com.megan.bot.ui.screens

import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megan.bot.ui.theme.*

@Composable
fun ContactScreen(navController: NavController) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contact Tracker", color = NorbotTextPrimary) },
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
            Text("📞", fontSize = 64.sp)
            Spacer(Modifier.height(16.dp))
            Text("Get in Touch", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = NorbotTextPrimary)
            Text("Tracker Wanga", fontSize = 20.sp, color = NorbotCyan, fontWeight = FontWeight.Bold)
            Text("🇰🇪 Kenya", color = NorbotTextSecondary)
            
            Spacer(Modifier.height(32.dp))

            // WhatsApp Button 1
            Button(
                onClick = {
                    val url = "https://wa.me/254758476795"
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NorbotSuccess),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Filled.Chat, null)
                Spacer(Modifier.width(8.dp))
                Text("WhatsApp: +254 758 476 795", fontSize = 15.sp)
            }

            Spacer(Modifier.height(12.dp))

            // WhatsApp Button 2
            Button(
                onClick = {
                    val url = "https://wa.me/254769502217"
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = NorbotSuccess),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Filled.Chat, null)
                Spacer(Modifier.width(8.dp))
                Text("WhatsApp: +254 769 502 217", fontSize = 15.sp)
            }

            Spacer(Modifier.height(24.dp))

            // Visit Website
            OutlinedButton(
                onClick = {
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://apis.megan.qzz.io")))
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.5.dp)
            ) {
                Icon(Icons.Filled.Language, null, tint = NorbotCyan)
                Spacer(Modifier.width(8.dp))
                Text("Visit API Website", color = NorbotCyan)
            }

            Spacer(Modifier.height(12.dp))

            // GitHub
            OutlinedButton(
                onClick = {
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/megan-corp")))
                },
                modifier = Modifier.fillMaxWidth().height(56.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(Icons.Filled.Code, null)
                Spacer(Modifier.width(8.dp))
                Text("GitHub: megan-corp")
            }

            Spacer(Modifier.height(32.dp))
            Text("Built with ❤️ in Kenya 🇰🇪", color = NorbotTextSecondary, fontSize = 14.sp)
            Text("© 2026 Tracker Wanga | Falcon Tech", color = NorbotTextSecondary, fontSize = 12.sp)
        }
    }
}
