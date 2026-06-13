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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megan.bot.data.api.ApiClient
import com.megan.bot.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun AIChatScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }
    var response by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var selectedModel by remember { mutableStateOf("gpt") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🤖 AI Chat", color = NorbotTextPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Model selector
            Text("Select Model:", color = NorbotTextSecondary, fontSize = 14.sp)
            Spacer(Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(aiModels) { model ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedModel = model },
                        colors = CardDefaults.cardColors(
                            containerColor = if (model == selectedModel) NorbotPurple.copy(alpha = 0.3f) else NorbotDarkCard
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Filled.Chat, null, tint = if (model == selectedModel) NorbotPurple else NorbotTextSecondary)
                            Spacer(Modifier.width(12.dp))
                            Text(
                                model.replaceFirstChar { it.uppercase() },
                                color = NorbotTextPrimary,
                                fontWeight = if (model == selectedModel) FontWeight.Bold else FontWeight.Normal
                            )
                        }
                    }
                }
            }

            // Chat input
            if (response.isNotEmpty()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        response,
                        modifier = Modifier.padding(16.dp),
                        color = NorbotTextPrimary
                    )
                }
                Spacer(Modifier.height(8.dp))
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = message,
                    onValueChange = { message = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Ask $selectedModel...", color = NorbotTextSecondary) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NorbotPurple,
                        unfocusedBorderColor = NorbotTextSecondary.copy(alpha = 0.3f)
                    )
                )
                Spacer(Modifier.width(8.dp))
                FilledIconButton(
                    onClick = {
                        if (message.isNotBlank()) {
                            scope.launch {
                                isLoading = true
                                try {
                                    val result = ApiClient.instance.chatWithAI(selectedModel, message)
                                    response = result.result ?: result.error ?: "No response"
                                } catch (e: Exception) {
                                    response = "Error: ${e.message}"
                                }
                                isLoading = false
                            }
                        }
                    },
                    enabled = !isLoading,
                    colors = IconButtonDefaults.filledIconButtonColors(containerColor = NorbotPurple)
                ) {
                    if (isLoading) CircularProgressIndicator(modifier = Modifier.size(20.dp), color = NorbotTextPrimary)
                    else Icon(Icons.Filled.Send, "Send", tint = NorbotTextPrimary)
                }
            }
        }
    }
}

@Composable
fun AIModelScreen(navController: NavController, model: String) {
    val scope = rememberCoroutineScope()
    var message by remember { mutableStateOf("") }
    var chatHistory by remember { mutableStateOf(listOf<Pair<String, String>>()) }
    var isLoading by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🤖 ${model.replaceFirstChar { it.uppercase() }}", color = NorbotTextPrimary) },
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
                .padding(16.dp)
        ) {
            // Chat messages
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(chatHistory) { (user, ai) ->
                    Column {
                        // User message
                        Card(
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = CardDefaults.cardColors(containerColor = NorbotPurple.copy(alpha = 0.2f)),
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 16.dp)
                        ) {
                            Text(user, modifier = Modifier.padding(12.dp), color = NorbotTextPrimary)
                        }
                        Spacer(Modifier.height(4.dp))
                        // AI response
                        Card(
                            modifier = Modifier.fillMaxWidth(0.8f).align(Alignment.End),
                            colors = CardDefaults.cardColors(containerColor = NorbotCyan.copy(alpha = 0.15f)),
                            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomStart = 16.dp)
                        ) {
                            Text(ai, modifier = Modifier.padding(12.dp), color = NorbotTextPrimary)
                        }
                    }
                }
            }

            // Input
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = message,
                    onValueChange = { message = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Message $model...", color = NorbotTextSecondary) },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NorbotPurple,
                        unfocusedBorderColor = NorbotTextSecondary.copy(alpha = 0.3f)
                    )
                )
                Spacer(Modifier.width(8.dp))
                FilledIconButton(
                    onClick = {
                        if (message.isNotBlank()) {
                            scope.launch {
                                val userMsg = message
                                message = ""
                                isLoading = true
                                try {
                                    val result = ApiClient.instance.chatWithAI(model, userMsg)
                                    val aiMsg = result.result ?: result.error ?: "Error"
                                    chatHistory = chatHistory + (userMsg to aiMsg)
                                } catch (e: Exception) {
                                    chatHistory = chatHistory + (userMsg to "Error: ${e.message}")
                                }
                                isLoading = false
                            }
                        }
                    },
                    enabled = !isLoading,
                    colors = IconButtonDefaults.filledIconButtonColors(containerColor = NorbotPurple)
                ) {
                    if (isLoading) CircularProgressIndicator(modifier = Modifier.size(20.dp), color = NorbotTextPrimary)
                    else Icon(Icons.Filled.Send, "Send", tint = NorbotTextPrimary)
                }
            }
        }
    }
}
