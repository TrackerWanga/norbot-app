package com.megan.bot.data.models

import com.google.gson.annotations.SerializedName

// Base response with creator info
data class BaseResponse(
    @SerializedName("api_name") val apiName: String?,
    @SerializedName("version") val version: String?,
    @SerializedName("creator") val creator: String?,
    @SerializedName("tech") val tech: String?
)

// AI Chat
data class AIResponse(
    val status: Boolean?,
    val result: String?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// YouTube Download
data class DownloadResponse(
    val success: Boolean?,
    val title: String?,
    val videoId: String?,
    val format: String?,
    val quality: String?,
    val downloadUrl: String?,
    val proxyUrl: String?,
    val thumbnail: String?,
    val thumbnailMq: String?,
    val youtubeUrl: String?,
    val provider: String?,
    val error: String?,
    val isLocalFile: Boolean?,
    @SerializedName("_skippedProviders") val skippedProviders: List<String>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// TikTok
data class TikTokResponse(
    val success: Boolean?,
    val title: String?,
    val videoUrl: String?,
    val videoUrlNoWatermark: String?,
    val videoProxyUrl: String?,
    val videoNoWatermarkProxyUrl: String?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Instagram
data class InstagramResponse(
    val success: Boolean?,
    val provider: String?,
    val title: String?,
    val username: String?,
    val media: List<InstagramMedia>?,
    val duration: Double?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class InstagramMedia(
    val type: String?,
    val url: String?,
    val thumbnail: String?,
    val quality: String?,
    val proxyUrl: String?
)

// Facebook
data class FacebookResponse(
    val success: Boolean?,
    val provider: String?,
    val title: String?,
    val sdUrl: String?,
    val hdUrl: String?,
    val sdProxyUrl: String?,
    val hdProxyUrl: String?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// News
data class NewsResponse(
    val success: Boolean?,
    val articles: List<NewsArticle>?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class NewsArticle(
    val title: String?,
    val description: String?,
    val url: String?,
    val image: String?,
    val source: String?,
    val publishedAt: String?
)

// Spotify
data class SpotifyResponse(
    val success: Boolean?,
    val query: String?,
    val tracks: List<SpotifyTrack>?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class SpotifyTrack(
    val title: String?,
    val artist: String?,
    val album: String?,
    val albumArt: String?,
    val duration: String?,
    val previewUrl: String?
)

// Crypto
data class CryptoResponse(
    val success: Boolean?,
    val result: CryptoData?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class CryptoData(
    val coin: String?,
    val price: String?,
    val change24h: String?,
    val marketCap: String?
)

// Forex
data class ForexResponse(
    val success: Boolean?,
    val result: ForexData?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ForexData(
    val base: String?,
    val date: String?,
    val rates: Map<String, Double>?,
    val source: String?
)

// Weather
data class WeatherResponse(
    val success: Boolean?,
    val result: WeatherData?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class WeatherData(
    val location: String?,
    val temperature: String?,
    val feelsLike: String?,
    val humidity: String?,
    val description: String?,
    val windSpeed: String?,
    val visibility: String?,
    val pressure: String?
)

// Games
data class GameResponse(
    val success: Boolean?,
    val result: GameData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class GameData(
    val player: String?,
    val playerEmoji: String?,
    val computer: String?,
    val computerEmoji: String?,
    val result: String?,
    val message: String?
)

// Fun
data class FunResponse(
    val success: Boolean?,
    val result: FunData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class FunData(
    val joke: String?,
    val proverb: String?,
    val meaning: String?,
    val id: String?,
    val language: String?
)

// Wikipedia
data class WikiResponse(
    val success: Boolean?,
    val result: WikiData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class WikiData(
    val title: String?,
    val extract: String?,
    val description: String?,
    val thumbnail: String?,
    val url: String?
)

// QR Code
data class QRResponse(
    val success: Boolean?,
    val result: QRData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class QRData(
    val url: String?,
    val text: String?
)

// Short URL
data class ShortUrlResponse(
    val success: Boolean?,
    val result: ShortUrlData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ShortUrlData(
    val shortUrl: String?,
    val service: String?,
    val original: String?
)

// Zodiac
data class ZodiacResponse(
    val success: Boolean?,
    val result: ZodiacData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ZodiacData(
    val sign: String?,
    val name: String?,
    val symbol: String?,
    val dates: String?,
    val element: String?,
    val rulingPlanet: String?,
    val traits: List<String>?,
    val weaknesses: List<String>?,
    val compatibility: List<String>?,
    val dailyHoroscope: String?,
    val horoscopeDate: String?
)

// WHOIS
data class WhoisResponse(
    val success: Boolean?,
    val result: WhoisData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class WhoisData(
    val domain: String?,
    val name: String?,
    val status: List<String>?,
    val events: List<WhoisEvent>?
)

data class WhoisEvent(
    val eventAction: String?,
    val eventDate: String?
)

// Password
data class PasswordResponse(
    val success: Boolean?,
    val result: PasswordData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PasswordData(
    val password: String?,
    val length: Int?,
    val strength: String?,
    val score: String?,
    val hasLower: Boolean?,
    val hasUpper: Boolean?,
    val hasDigit: Boolean?,
    val hasSpecial: Boolean?,
    val findings: List<String>?,
    val timeToCrack: String?,
    val appearsInTop10k: Boolean?
)

// Phone
data class PhoneResponse(
    val success: Boolean?,
    val result: PhoneData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PhoneData(
    val valid: Boolean?,
    val error: String?,
    val country: String?
)

// SoundCloud
data class SoundCloudResponse(
    val success: Boolean?,
    val query: String?,
    val results: List<SoundCloudTrack>?,
    val totalResults: Int?,
    val service: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class SoundCloudTrack(
    val title: String?,
    val genre: String?,
    val duration: String?,
    val artwork: String?,
    val permalink: String?,
    val plays: Int?,
    val comments: Int?,
    val createdAt: String?
)

// TextPro
data class TextProListResponse(
    val success: Boolean?,
    val total: Int?,
    val effects: List<TextProEffect>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class TextProEffect(
    val id: String?,
    val name: String?,
    val endpoint: String?
)

data class TextProGenerateResponse(
    val success: Boolean?,
    val imageUrl: String?,
    val effect: String?,
    val text: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Ephoto
data class EphotoListResponse(
    val success: Boolean?,
    val effects: List<EphotoEffect>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class EphotoEffect(
    val id: String?,
    val name: String?,
    val slug: String?,
    val category: String?,
    val endpoint: String?,
    val params: List<EphotoParam>?
)

data class EphotoParam(
    val name: String?,
    val type: String?,
    val placeholder: String?
)

data class EphotoGenerateResponse(
    val success: Boolean?,
    val imageUrl: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Audio Effects
data class AudioEffectsResponse(
    val success: Boolean?,
    val count: Int?,
    val effects: List<AudioEffect>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class AudioEffect(
    val id: String?,
    val name: String?,
    val description: String?,
    val endpoint: String?,
    val method: String?,
    val params: Map<String, String>?,
    val ffmpegFilter: String?
)

// Image Search
data class ImageSearchResponse(
    val success: Boolean?,
    val results: List<ImageResult>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ImageResult(
    val url: String?,
    val thumbnail: String?,
    val title: String?,
    val source: String?
)

// Video Search
data class VideoSearchResponse(
    val success: Boolean?,
    val results: List<VideoResult>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class VideoResult(
    val url: String?,
    val thumbnail: String?,
    val title: String?,
    val duration: String?,
    val source: String?
)

// AI Image Generation
data class ImageGenResponse(
    val success: Boolean?,
    val url: String?,
    val prompt: String?,
    val provider: String?,
    val model: String?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// YouTube Info
data class YouTubeInfoResponse(
    val success: Boolean?,
    val videoId: String?,
    val url: String?,
    val thumbnail: String?,
    val thumbnailHD: String?,
    val embedUrl: String?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Twitter
data class TwitterResponse(
    val success: Boolean?,
    val title: String?,
    val author: String?,
    val media: List<TwitterMedia>?,
    val provider: String?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class TwitterMedia(
    val type: String?,
    val url: String?,
    val thumbnail: String?
)

// Snapchat
data class SnapchatResponse(
    val success: Boolean?,
    val videoUrl: String?,
    val title: String?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Shazam
data class ShazamResponse(
    val success: Boolean?,
    val query: String?,
    val results: List<ShazamTrack>?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ShazamTrack(
    val title: String?,
    val artist: String?,
    val album: String?,
    val artwork: String?,
    val trackId: String?
)

data class ShazamTrackResponse(
    val success: Boolean?,
    val track: ShazamTrackDetail?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ShazamTrackDetail(
    val title: String?,
    val artist: String?,
    val album: String?,
    val artwork: String?,
    val genres: List<String>?,
    val releaseDate: String?,
    val lyrics: String?
)

// Jobs
data class JobsResponse(
    val success: Boolean?,
    val jobs: List<JobData>?,
    val totalResults: Int?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class JobData(
    val title: String?,
    val company: String?,
    val location: String?,
    val description: String?,
    val url: String?,
    val postedDate: String?,
    val salary: String?
)

// Education
data class PapersResponse(
    val success: Boolean?,
    val papers: List<PaperData>?,
    val totalResults: Int?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PaperData(
    val title: String?,
    val authors: List<String>?,
    val year: String?,
    val abstract: String?,
    val url: String?,
    val citations: Int?
)

data class BooksResponse(
    val success: Boolean?,
    val books: List<BookData>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class BookData(
    val title: String?,
    val author: String?,
    val year: String?,
    val coverUrl: String?,
    val key: String?
)

data class DictionaryResponse(
    val success: Boolean?,
    val result: DictionaryData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class DictionaryData(
    val word: String?,
    val phonetic: String?,
    val meanings: List<MeaningData>?,
    val origin: String?
)

data class MeaningData(
    val partOfSpeech: String?,
    val definitions: List<DefinitionData>?
)

data class DefinitionData(
    val definition: String?,
    val example: String?
)

// Crypto All
data class CryptoAllResponse(
    val success: Boolean?,
    val coins: List<CryptoData>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Forex Convert
data class ForexConvertResponse(
    val success: Boolean?,
    val result: ForexConvertData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ForexConvertData(
    val from: String?,
    val to: String?,
    val amount: Double?,
    val result: Double?,
    val rate: Double?
)

// Stalker
data class StalkResponse(
    val success: Boolean?,
    val result: StalkData?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class StalkData(
    val username: String?,
    val name: String?,
    val bio: String?,
    val followers: Int?,
    val following: Int?,
    val posts: Int?,
    val avatar: String?,
    val url: String?
)

// Proverbs & Swahili
data class ProverbsResponse(
    val success: Boolean?,
    val count: Int?,
    val results: List<FunData>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class SwahiliPhrasesResponse(
    val success: Boolean?,
    val count: Int?,
    val results: List<SwahiliPhraseData>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class SwahiliPhraseData(
    val phrase: String?,
    val translation: String?,
    val category: String?
)

// Zodiac All
data class ZodiacAllResponse(
    val success: Boolean?,
    val signs: List<ZodiacData>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class CompatibilityResponse(
    val success: Boolean?,
    val result: CompatibilityData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class CompatibilityData(
    val sign1: String?,
    val sign2: String?,
    val score: Int?,
    val description: String?,
    val strengths: List<String>?,
    val challenges: List<String>?
)

// Converter
data class ConverterResponse(
    val success: Boolean?,
    val result: ConverterData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ConverterData(
    val type: String?,
    val inputFormat: String?,
    val outputFormat: String?,
    val base64Data: String?,
    val originalUrl: String?,
    val size: Int?
)

// Bible
data class BibleResponse(
    val success: Boolean?,
    val result: BibleData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class BibleData(
    val reference: String?,
    val text: String?,
    val translation: String?
)

// Screenshot
data class ScreenshotResponse(
    val success: Boolean?,
    val result: ScreenshotData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ScreenshotData(
    val url: String?,
    val screenshot: String?
)

// Timestamp
data class TimestampResponse(
    val success: Boolean?,
    val result: TimestampData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class TimestampData(
    val timestamp: Long?,
    val date: String?,
    val time: String?,
    val timezone: String?
)

// Password Generator
data class PasswordGenResponse(
    val success: Boolean?,
    val result: PasswordGenData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PasswordGenData(
    val password: String?,
    val length: Int?,
    val strength: String?
)

// Hash
data class HashResponse(
    val success: Boolean?,
    val result: HashData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class HashData(
    val text: String?,
    val algorithm: String?,
    val hash: String?
)

// Base64
data class Base64Response(
    val success: Boolean?,
    val result: Base64Data?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class Base64Data(
    val input: String?,
    val output: String?
)

// UUID
data class UUIDResponse(
    val success: Boolean?,
    val result: UUIDData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class UUIDData(
    val uuid: String?
)

// Validate
data class ValidateResponse(
    val success: Boolean?,
    val result: ValidateData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ValidateData(
    val valid: Boolean?,
    val input: String?,
    val message: String?
)

// Text Stats
data class TextStatsResponse(
    val success: Boolean?,
    val result: TextStatsData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class TextStatsData(
    val characters: Int?,
    val words: Int?,
    val sentences: Int?,
    val paragraphs: Int?,
    val readingTime: String?
)

// Lorem
data class LoremResponse(
    val success: Boolean?,
    val result: LoremData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class LoremData(
    val text: String?,
    val paragraphs: Int?
)

// Color
data class ColorResponse(
    val success: Boolean?,
    val result: ColorData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ColorData(
    val hex: String?,
    val rgb: String?,
    val name: String?
)

// URL Encode/Decode
data class URLEncodeResponse(
    val success: Boolean?,
    val result: URLEncodeData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class URLEncodeData(
    val input: String?,
    val output: String?
)

// DNS
data class DNSResponse(
    val success: Boolean?,
    val result: DNSData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class DNSData(
    val domain: String?,
    val records: List<DNSRecord>?,
    val nameservers: List<String>?
)

data class DNSRecord(
    val type: String?,
    val value: String?,
    val ttl: Int?
)

// WiFi
data class WiFiResponse(
    val success: Boolean?,
    val result: WiFiData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class WiFiData(
    val networks: List<WiFiNetwork>?,
    val currentNetwork: String?
)

data class WiFiNetwork(
    val ssid: String?,
    val signal: Int?,
    val security: String?
)

// Security - Subdomain
data class SubdomainResponse(
    val success: Boolean?,
    val result: SubdomainData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class SubdomainData(
    val domain: String?,
    val subdomains: List<String>?,
    val count: Int?
)

// Port Scan
data class PortScanResponse(
    val success: Boolean?,
    val result: PortScanData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PortScanData(
    val ip: String?,
    val openPorts: List<Int>?,
    val scanTime: String?
)

// SSL
data class SSLResponse(
    val success: Boolean?,
    val result: SSLData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class SSLData(
    val domain: String?,
    val valid: Boolean?,
    val issuer: String?,
    val expiresAt: String?,
    val daysRemaining: Int?
)

// Headers
data class HeadersResponse(
    val success: Boolean?,
    val result: HeadersData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class HeadersData(
    val url: String?,
    val headers: Map<String, String>?,
    val statusCode: Int?
)

// GeoIP
data class GeoIPResponse(
    val success: Boolean?,
    val result: GeoIPData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class GeoIPData(
    val ip: String?,
    val country: String?,
    val city: String?,
    val isp: String?,
    val lat: Double?,
    val lon: Double?
)

// Reverse IP
data class ReverseIPResponse(
    val success: Boolean?,
    val result: ReverseIPData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ReverseIPData(
    val ip: String?,
    val domains: List<String>?,
    val count: Int?
)

// Traceroute
data class TracerouteResponse(
    val success: Boolean?,
    val result: TracerouteData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class TracerouteData(
    val host: String?,
    val hops: List<TracerouteHop>?,
    val totalHops: Int?
)

data class TracerouteHop(
    val hop: Int?,
    val ip: String?,
    val time: String?
)

// Ping
data class PingResponse(
    val success: Boolean?,
    val result: PingData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PingData(
    val host: String?,
    val alive: Boolean?,
    val time: String?,
    val ip: String?
)

// MAC
data class MacResponse(
    val success: Boolean?,
    val result: MacData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class MacData(
    val mac: String?,
    val vendor: String?,
    val type: String?
)

// CMS
data class CMSResponse(
    val success: Boolean?,
    val result: CMSData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class CMSData(
    val url: String?,
    val cms: String?,
    val version: String?,
    val confidence: Int?
)

// Tech Stack
data class TechStackResponse(
    val success: Boolean?,
    val result: TechStackData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class TechStackData(
    val url: String?,
    val technologies: List<String>?,
    val categories: Map<String, List<String>>?
)

// Hash Identify
data class HashIdentifyResponse(
    val success: Boolean?,
    val result: HashIdentifyData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class HashIdentifyData(
    val hash: String?,
    val type: String?,
    val possibleTypes: List<String>?
)

// Metadata
data class MetadataResponse(
    val success: Boolean?,
    val result: MetadataData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class MetadataData(
    val url: String?,
    val title: String?,
    val description: String?,
    val image: String?,
    val siteName: String?,
    val type: String?
)

// GitHub Search
data class GitHubSearchResponse(
    val success: Boolean?,
    val total: Int?,
    val repos: List<GitHubRepo>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class GitHubRepo(
    val name: String?,
    val description: String?,
    val stars: Int?,
    val forks: Int?,
    val language: String?,
    val url: String?,
    val topics: List<String>?
)

// NPM Search
data class NPMSearchResponse(
    val success: Boolean?,
    val total: Int?,
    val packages: List<NPMPackage>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class NPMPackage(
    val name: String?,
    val version: String?,
    val description: String?,
    val keywords: List<String>?,
    val url: String?,
    val downloads: Double?
)

// PyPI Search
data class PyPISearchResponse(
    val success: Boolean?,
    val result: PyPIData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PyPIData(
    val name: String?,
    val version: String?,
    val summary: String?,
    val author: String?,
    val license: String?,
    val url: String?,
    val homepage: String?
)

// News Search
data class NewsSearchResponse(
    val success: Boolean?,
    val total: Int?,
    val articles: List<NewsArticle>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Reddit
data class RedditResponse(
    val success: Boolean?,
    val results: List<RedditPost>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class RedditPost(
    val title: String?,
    val subreddit: String?,
    val author: String?,
    val score: Int?,
    val comments: Int?,
    val url: String?,
    val selftext: String?
)

// StackOverflow
data class StackOverflowResponse(
    val success: Boolean?,
    val total: Int?,
    val questions: List<SOQuestion>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class SOQuestion(
    val title: String?,
    val score: Int?,
    val answers: Int?,
    val views: Int?,
    val tags: List<String>?,
    val url: String?,
    val isAnswered: Boolean?
)

// Urban Dictionary
data class UrbanDictResponse(
    val success: Boolean?,
    val word: String?,
    val definitions: List<UrbanDefinition>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class UrbanDefinition(
    val definition: String?,
    val example: String?,
    val author: String?,
    val thumbsUp: Int?,
    val thumbsDown: Int?
)

// Country
data class CountryResponse(
    val success: Boolean?,
    val results: List<CountryData>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class CountryData(
    val name: String?,
    val official: String?,
    val capital: String?,
    val population: Int?,
    val region: String?,
    val subregion: String?,
    val languages: List<String>?,
    val currencies: List<String>?,
    val flag: String?,
    val timezones: List<String>?
)

// Emoji
data class EmojiResponse(
    val success: Boolean?,
    val results: List<EmojiData>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class EmojiData(
    val character: String?,
    val name: String?,
    val slug: String?,
    val group: String?
)

// AI Translate
data class TranslateResponse(
    val success: Boolean?,
    val original: String?,
    val translated: String?,
    val from: String?,
    val to: String?,
    val provider: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// AI Summarize
data class SummarizeResponse(
    val success: Boolean?,
    val summary: String?,
    val provider: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// AI Code
data class CodeResponse(
    val success: Boolean?,
    val code: String?,
    val language: String?,
    val provider: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// AI Scanner
data class ScannerResponse(
    val success: Boolean?,
    val analysis: String?,
    val provider: String?,
    val tool: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// AI Humanizer
data class HumanizeResponse(
    val success: Boolean?,
    val original: String?,
    val humanized: String?,
    val provider: String?,
    val tool: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Pixabay/Images
data class PixabayResponse(
    val success: Boolean?,
    val query: String?,
    val featured: String?,
    val images: List<PixabayImage>?,
    val provider: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PixabayImage(
    val id: String?,
    val url: String?,
    val author: String?,
    val width: Int?,
    val height: Int?,
    val downloadUrl: String?
)

// Picsum
data class PicsumResponse(
    val success: Boolean?,
    val image: PicsumImage?,
    val provider: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PicsumImage(
    val id: String?,
    val url: String?,
    val author: String?,
    val width: Int?,
    val height: Int?,
    val originalWidth: Int?,
    val originalHeight: Int?,
    val downloadUrl: String?
)

// Dog
data class DogImageResponse(
    val success: Boolean?,
    val image: String?,
    val breed: String?,
    val provider: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Cat
data class CatImageResponse(
    val success: Boolean?,
    val image: String?,
    val id: String?,
    val tags: List<String>?,
    val provider: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Scraper
data class ScrapeResponse(
    val success: Boolean?,
    val result: ScrapeData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ScrapeData(
    val url: String?,
    val title: String?,
    val text: String?,
    val html: String?,
    val links: List<String>?,
    val images: List<String>?
)

// Links
data class LinksResponse(
    val success: Boolean?,
    val result: LinksData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class LinksData(
    val url: String?,
    val links: List<String>?,
    val internalLinks: List<String>?,
    val externalLinks: List<String>?
)

// Scripts
data class ScriptsResponse(
    val success: Boolean?,
    val result: ScriptsData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ScriptsData(
    val url: String?,
    val scripts: List<String>?,
    val inlineScripts: List<String>?
)

// Cookies
data class CookiesResponse(
    val success: Boolean?,
    val result: CookiesData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class CookiesData(
    val url: String?,
    val cookies: List<CookieData>?,
    val count: Int?
)

data class CookieData(
    val name: String?,
    val value: String?,
    val domain: String?,
    val path: String?,
    val expires: String?
)

// Dev Tools
data class DeobfuscateResponse(
    val success: Boolean?,
    val result: DeobfuscateData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class DeobfuscateData(
    val original: String?,
    val deobfuscated: String?,
    val type: String?
)

data class DeminifyResponse(
    val success: Boolean?,
    val result: DeminifyData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class DeminifyData(
    val original: String?,
    val formatted: String?,
    val language: String?
)

data class RunJSResponse(
    val success: Boolean?,
    val result: RunJSData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class RunJSData(
    val code: String?,
    val output: String?,
    val error: String?,
    val executionTime: String?
)

data class DecodeResponse(
    val success: Boolean?,
    val result: DecodeData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class DecodeData(
    val original: String?,
    val decoded: String?,
    val detectedType: String?
)

data class HeadlessResponse(
    val success: Boolean?,
    val result: HeadlessData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class HeadlessData(
    val url: String?,
    val content: String?,
    val statusCode: Int?,
    val headers: Map<String, String>?
)

// YouTube Search
data class YouTubeSearchResponse(
    val success: Boolean?,
    val results: List<YouTubeVideo>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class YouTubeVideo(
    val id: String?,
    val title: String?,
    val channelTitle: String?,
    val thumbnail: String?,
    val duration: String?,
    val views: String?
)

// Music Search
data class MusicSearchResponse(
    val success: Boolean?,
    val results: List<MusicTrack>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class MusicTrack(
    val title: String?,
    val artist: String?,
    val album: String?,
    val artwork: String?,
    val duration: String?,
    val url: String?
)

// Artist
data class ArtistResponse(
    val success: Boolean?,
    val result: ArtistData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class ArtistData(
    val name: String?,
    val bio: String?,
    val image: String?,
    val genres: List<String>?,
    val topTracks: List<MusicTrack>?
)

// Media Status
data class MediaStatusResponse(
    val success: Boolean?,
    val checkedAt: String?,
    val categories: Map<String, Any>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Status
data class StatusResponse(
    val success: Boolean?,
    val result: Any?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Endpoints
data class EndpointsResponse(
    val success: Boolean?,
    val result: Any?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Categories
data class CategoriesResponse(
    val success: Boolean?,
    val result: Any?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Anime
data class AnimeResponse(
    val success: Boolean?,
    val result: AnimeData?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class AnimeData(
    val url: String?,
    val type: String?,
    val source: String?
)

// PhotoFunia
data class PhotofuniaResponse(
    val success: Boolean?,
    val totalEffects: Int?,
    val effects: List<PhotofuniaEffect>?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class PhotofuniaEffect(
    val id: String?,
    val name: String?,
    val category: String?
)

data class PhotofuniaGenResponse(
    val success: Boolean?,
    val imageUrl: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Sports
data class SportsResponse(
    val success: Boolean?,
    val result: Any?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

// Upload
data class UploadResponse(
    val success: Boolean?,
    val result: UploadData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class UploadData(
    val url: String?,
    val display_url: String?,
    val thumb: String?,
    val medium: String?,
    val service: String?
)

// Audio Apply
data class AudioApplyResponse(
    val success: Boolean?,
    val result: AudioApplyData?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)

data class AudioApplyData(
    val url: String?,
    val effect: String?,
    val originalUrl: String?,
    val duration: String?
)

// Lyrics
data class LyricsResponse(
    val success: Boolean?,
    val query: String?,
    val title: String?,
    val author: String?,
    val album: String?,
    val duration: String?,
    val lyrics: String?,
    val syncedLyrics: String?,
    val error: String?,
    @SerializedName("api_name") val apiName: String?,
    val version: String?,
    val creator: String?,
    val tech: String?
)
