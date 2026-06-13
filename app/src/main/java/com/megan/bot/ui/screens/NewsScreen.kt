package com.megan.bot.ui.screens

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.megan.bot.data.api.ApiClient
import com.megan.bot.data.models.NewsArticle
import com.megan.bot.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun NewsScreen(navController: NavController) {
    val scope = rememberCoroutineScope()
    var selectedSource by remember { mutableStateOf("kenya") }
    var articles by remember { mutableStateOf<List<NewsArticle>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    val sources = listOf(
        "kenya" to "🇰🇪 Kenya",
        "global" to "🌍 Global",
        "tuko" to "📰 Tuko",
        "nation" to "📰 Nation",
        "standard" to "📰 Standard"
    )

    LaunchedEffect(selectedSource) {
        isLoading = true
        error = null
        try {
            val response = when (selectedSource) {
                "kenya" -> ApiClient.instance.getKenyaNews()
                "global" -> ApiClient.instance.getGlobalNews()
                "tuko" -> ApiClient.instance.getTukoNews()
                "nation" -> ApiClient.instance.getNationNews()
                "standard" -> ApiClient.instance.getStandardNews()
                else -> ApiClient.instance.getKenyaNews()
            }
            articles = response.articles ?: emptyList()
        } catch (e: Exception) {
            error = e.message
        }
        isLoading = false
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📰 News", color = NorbotTextPrimary) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = NorbotDark)
            )
        }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            // Source selector
            LazyRow(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(sources) { (key, label) ->
                    FilterChip(
                        selected = selectedSource == key,
                        onClick = { selectedSource = key },
                        label = { Text(label, fontSize = 12.sp) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = NorbotPurple.copy(alpha = 0.3f),
                            selectedLabelColor = NorbotPurple
                        )
                    )
                }
            }

            if (isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = NorbotPurple)
                }
            } else if (error != null) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("❌", fontSize = 48.sp)
                        Spacer(Modifier.height(8.dp))
                        Text(error ?: "Unknown error", color = NorbotError)
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(articles) { article ->
                        NewsCard(article)
                    }
                }
            }
        }
    }
}

@Composable
fun NewsCard(article: NewsArticle) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = NorbotDarkCard),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            if (!article.image.isNullOrEmpty()) {
                AsyncImage(
                    model = article.image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    article.title ?: "No title",
                    color = NorbotTextPrimary,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    article.description ?: "",
                    color = NorbotTextSecondary,
                    fontSize = 13.sp,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(article.source ?: "", color = NorbotPurple, fontSize = 12.sp)
                    Text(article.publishedAt ?: "", color = NorbotTextSecondary, fontSize = 12.sp)
                }
            }
        }
    }
}
