package com.megan.bot.data.api

import com.megan.bot.data.models.*
import retrofit2.http.*

interface MeganApi {
    // AI Chat
    @GET("api/ai/{model}")
    suspend fun chatWithAI(
        @Path("model") model: String,
        @Query("q") prompt: String
    ): AIResponse

    // YouTube Download
    @GET("download/ytmp4")
    suspend fun downloadYouTube(
        @Query("url") url: String,
        @Query("q") query: String? = null
    ): DownloadResponse

    // TikTok Download
    @GET("api/download/tiktok")
    suspend fun downloadTikTok(@Query("url") url: String): TikTokResponse

    // Instagram Download
    @GET("api/download/instagram")
    suspend fun downloadInstagram(@Query("url") url: String): InstagramResponse

    // Facebook Download
    @GET("api/download/facebook")
    suspend fun downloadFacebook(@Query("url") url: String): FacebookResponse

    // Kenya News
    @GET("api/news/kenya")
    suspend fun getKenyaNews(): NewsResponse

    // Spotify Search
    @GET("api/spotify/search")
    suspend fun searchSpotify(@Query("q") query: String): SpotifyResponse

    // Crypto Price
    @GET("api/crypto/price")
    suspend fun getCryptoPrice(@Query("coin") coin: String): CryptoResponse

    // Forex Rates
    @GET("api/forex/rates")
    suspend fun getForexRates(): ForexResponse

    // Weather
    @GET("api/tools/weather")
    suspend fun getWeather(@Query("city") city: String): WeatherResponse

    // Games - RPS
    @GET("api/game/rps")
    suspend fun playRPS(@Query("move") move: String): GameResponse

    // Fun - Dad Joke
    @GET("api/fun-data/dad-joke")
    suspend fun getDadJoke(): FunResponse

    // Fun - Kenyan Proverb
    @GET("api/fun-data/kenyan-proverb")
    suspend fun getKenyanProverb(): FunResponse

    // Wikipedia Search
    @GET("api/search/wiki")
    suspend fun searchWikipedia(@Query("q") query: String): WikiResponse

    // QR Code
    @GET("api/tools/qrcode")
    suspend fun generateQR(@Query("text") text: String): QRResponse

    // URL Shortener
    @GET("api/short/tinyurl")
    suspend fun shortenUrl(@Query("url") url: String): ShortUrlResponse

    // Zodiac
    @GET("api/zodiac/{sign}")
    suspend fun getZodiac(@Path("sign") sign: String): ZodiacResponse

    // Security - WHOIS
    @GET("api/security/whois")
    suspend fun whoisLookup(@Query("domain") domain: String): WhoisResponse

    // Password Audit
    @GET("api/tools/password-audit")
    suspend fun auditPassword(@Query("password") password: String): PasswordResponse

    // Phone Lookup
    @GET("api/tools/phone-lookup")
    suspend fun phoneLookup(@Query("phone") phone: String): PhoneResponse

    // SoundCloud Search
    @GET("api/soundcloud/search")
    suspend fun searchSoundCloud(@Query("q") query: String): SoundCloudResponse

    // Text Pro List
    @GET("api/textpro/list")
    suspend fun getTextProEffects(): TextProListResponse

    // Text Pro Generate
    @GET("api/textpro/generate")
    suspend fun generateTextPro(
        @Query("effect") effect: String,
        @Query("text") text: String
    ): TextProGenerateResponse

    // Ephoto List
    @GET("api/ephoto/list")
    suspend fun getEphotoEffects(): EphotoListResponse

    // Ephoto Generate
    @GET("api/ephoto/{effect}")
    suspend fun generateEphoto(
        @Path("effect") effect: String,
        @Query("text") text: String
    ): EphotoGenerateResponse

    // Audio Effects List
    @GET("api/audio/list")
    suspend fun getAudioEffects(): AudioEffectsResponse

    // Image Search
    @GET("api/search/images")
    suspend fun searchImages(@Query("q") query: String): ImageSearchResponse

    // Video Search
    @GET("api/search/videos")
    suspend fun searchVideos(@Query("q") query: String): VideoSearchResponse

    // Fun Tech Joke
    @GET("api/fun/tech-joke")
    suspend fun getTechJoke(): FunResponse

    // Fun Fortune Cookie
    @GET("api/fun/fortune-cookie")
    suspend fun getFortuneCookie(): FunResponse

    // AI Image
    @POST("api/ai/image/dall-e")
    suspend fun generateImage(@Body body: Map<String, String>): ImageGenResponse
}

    // ========== MISSING ENDPOINTS ==========
    
    // YouTube MP3
    @GET("download/audio")
    suspend fun downloadYouTubeMP3(
        @Query("url") url: String? = null,
        @Query("q") query: String? = null
    ): DownloadResponse

    // YouTube Info
    @GET("api/download/youtube/info")
    suspend fun getYouTubeInfo(@Query("url") url: String): YouTubeInfoResponse

    // Twitter/X Download
    @GET("api/download/twitter")
    suspend fun downloadTwitter(@Query("url") url: String): TwitterResponse

    // Snapchat Download
    @GET("api/download/snapchat")
    suspend fun downloadSnapchat(@Query("url") url: String): SnapchatResponse

    // Spotify Download
    @GET("api/spotify/download")
    suspend fun downloadSpotify(@Query("url") url: String): DownloadResponse

    // Shazam Search
    @GET("api/shazam/search")
    suspend fun searchShazam(@Query("q") query: String): ShazamResponse

    // Shazam Track Details
    @GET("api/shazam/track/{id}")
    suspend fun getShazamTrack(@Path("id") trackId: String): ShazamTrackResponse

    // Global News
    @GET("api/news/global")
    suspend fun getGlobalNews(): NewsResponse

    // Tuko News
    @GET("api/news/tuko")
    suspend fun getTukoNews(): NewsResponse

    // Nation News
    @GET("api/news/nation")
    suspend fun getNationNews(): NewsResponse

    // Standard News
    @GET("api/news/standard")
    suspend fun getStandardNews(): NewsResponse

    // Kenyans News
    @GET("api/news/kenyans")
    suspend fun getKenyansNews(): NewsResponse

    // Kenya Jobs
    @GET("api/jobs/kenya")
    suspend fun getKenyaJobs(@Query("page") page: Int = 1): JobsResponse

    // Bible AI
    @GET("api/bible/ai")
    suspend fun askBibleAI(
        @Query("q") question: String,
        @Query("translation") translation: String = "ESV"
    ): AIResponse

    // Education - Academic Papers
    @GET("api/education/papers")
    suspend fun searchPapers(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): PapersResponse

    // Education - Books
    @GET("api/education/books")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("page") page: Int = 1
    ): BooksResponse

    // Education - Dictionary
    @GET("api/education/dictionary")
    suspend fun lookupWord(@Query("word") word: String): DictionaryResponse

    // Crypto All
    @GET("api/crypto/all")
    suspend fun getAllCryptos(): CryptoAllResponse

    // Forex Convert
    @GET("api/forex/convert")
    suspend fun convertForex(
        @Query("amount") amount: Double = 1.0,
        @Query("from") from: String = "USD",
        @Query("to") to: String = "KES"
    ): ForexConvertResponse

    // Stalker - GitHub
    @GET("api/stalk/github")
    suspend fun stalkGitHub(@Query("username") username: String): StalkResponse

    // Stalker - Instagram
    @GET("api/stalk/instagram")
    suspend fun stalkInstagram(@Query("username") username: String): StalkResponse

    // Stalker - TikTok
    @GET("api/stalk/tiktok")
    suspend fun stalkTikTok(@Query("username") username: String): StalkResponse

    // Stalker - Twitter
    @GET("api/stalk/twitter")
    suspend fun stalkTwitter(@Query("username") username: String): StalkResponse

    // Stalker - IP
    @GET("api/stalk/ip")
    suspend fun stalkIP(@Query("ip") ip: String): StalkResponse

    // Fun - Swahili Phrase
    @GET("api/fun-data/swahili-phrase")
    suspend fun getSwahiliPhrase(): FunResponse

    // Fun - All Kenyan Proverbs
    @GET("api/fun-data/kenyan-proverbs")
    suspend fun getAllKenyanProverbs(): ProverbsResponse

    // Fun - All Swahili Phrases
    @GET("api/fun-data/swahili-phrases")
    suspend fun getAllSwahiliPhrases(): SwahiliPhrasesResponse

    // Fun - Affirmation
    @GET("api/fun-data/affirmation")
    suspend fun getAffirmation(): FunResponse

    // Fun - Never Have I Ever
    @GET("api/fun/never-have-i-ever")
    suspend fun getNeverHaveIEver(): FunResponse

    // Fun - Fortune Cookie
    @GET("api/fun/fortune-cookie")
    suspend fun getFortuneCookie(): FunResponse

    // Games - Flag Guess
    @GET("api/game/flag-guess")
    suspend fun startFlagGame(): GameResponse

    // Games - Flag Check
    @GET("api/game/flag-guess/{id}/check")
    suspend fun checkFlagGuess(
        @Path("id") gameId: String,
        @Query("answer") answer: String
    ): GameResponse

    // Games - Word Scramble
    @GET("api/game/word-scramble")
    suspend fun getWordScramble(): GameResponse

    // Games - Number Guess
    @GET("api/game/number-guess")
    suspend fun startNumberGame(): GameResponse

    // Games - Number Guess Check
    @POST("api/game/number-guess/{id}")
    suspend fun guessNumber(
        @Path("id") gameId: String,
        @Body guess: Map<String, Int>
    ): GameResponse

    // Zodiac - All Signs
    @GET("api/zodiac/all")
    suspend fun getAllZodiacs(): ZodiacAllResponse

    // Zodiac - By Element
    @GET("api/zodiac/element/{element}")
    suspend fun getZodiacByElement(@Path("element") element: String): ZodiacAllResponse

    // Zodiac - Compatibility
    @GET("api/zodiac/compatibility/{sign1}/{sign2}")
    suspend fun getZodiacCompatibility(
        @Path("sign1") sign1: String,
        @Path("sign2") sign2: String
    ): CompatibilityResponse

    // Converter - Image to Sticker
    @GET("api/converter/img-to-sticker")
    suspend fun imageToSticker(@Query("url") url: String): ConverterResponse

    // Converter - Video to GIF
    @GET("api/converter/video-to-gif")
    suspend fun videoToGif(@Query("url") url: String): ConverterResponse

    // Converter - GIF to Video
    @GET("api/converter/gif-to-video")
    suspend fun gifToVideo(@Query("url") url: String): ConverterResponse

    // Tools - Bible
    @GET("api/tools/bible")
    suspend fun getBibleVerse(@Query("ref") ref: String): BibleResponse

    // Tools - Dictionary
    @GET("api/tools/dictionary")
    suspend fun getDictionary(@Query("word") word: String): DictionaryResponse

    // Tools - Screenshot
    @GET("api/tools/screenshot")
    suspend fun takeScreenshot(@Query("url") url: String): ScreenshotResponse

    // Tools - Timestamp
    @GET("api/tools/timestamp")
    suspend fun getTimestamp(): TimestampResponse

    // Tools - Password Generator
    @GET("api/tools/password")
    suspend fun generatePassword(
        @Query("length") length: Int = 16
    ): PasswordGenResponse

    // Tools - Hash
    @GET("api/tools/hash")
    suspend fun hashText(
        @Query("text") text: String,
        @Query("algorithm") algorithm: String = "sha256"
    ): HashResponse

    // Tools - Base64 Encode
    @GET("api/tools/base64encode")
    suspend fun base64Encode(@Query("text") text: String): Base64Response

    // Tools - Base64 Decode
    @GET("api/tools/base64decode")
    suspend fun base64Decode(@Query("text") text: String): Base64Response

    // Tools - UUID Generate
    @GET("api/tools/uuid")
    suspend fun generateUUID(): UUIDResponse

    // Tools - Email Validate
    @GET("api/tools/email-validate")
    suspend fun validateEmail(@Query("email") email: String): ValidateResponse

    // Tools - IP Validate
    @GET("api/tools/ip-validate")
    suspend fun validateIP(@Query("ip") ip: String): ValidateResponse

    // Tools - Text Stats
    @GET("api/tools/textstats")
    suspend fun getTextStats(@Query("text") text: String): TextStatsResponse

    // Tools - Lorem Ipsum
    @GET("api/tools/lorem")
    suspend fun generateLorem(
        @Query("paragraphs") paragraphs: Int = 1
    ): LoremResponse

    // Tools - Random Color
    @GET("api/tools/color")
    suspend fun getRandomColor(): ColorResponse

    // Tools - URL Encode
    @GET("api/tools/urlencode")
    suspend fun urlEncode(@Query("text") text: String): URLEncodeResponse

    // Tools - URL Decode
    @GET("api/tools/urldecode")
    suspend fun urlDecode(@Query("text") text: String): URLEncodeResponse

    // Tools - DNS Inspector
    @GET("api/tools/dns-inspector")
    suspend fun dnsInspector(@Query("domain") domain: String): DNSResponse

    // Tools - WiFi Scan
    @GET("api/tools/wifi-scan")
    suspend fun wifiScan(): WiFiResponse

    // Security - DNS Lookup
    @GET("api/security/dns")
    suspend fun dnsLookup(@Query("domain") domain: String): DNSResponse

    // Security - Subdomain Scan
    @GET("api/security/subdomain")
    suspend fun subdomainScan(@Query("domain") domain: String): SubdomainResponse

    // Security - Port Scan
    @GET("api/security/portscan")
    suspend fun portScan(@Query("ip") ip: String): PortScanResponse

    // Security - SSL Check
    @GET("api/security/ssl")
    suspend fun sslCheck(@Query("domain") domain: String): SSLResponse

    // Security - HTTP Headers
    @GET("api/security/headers")
    suspend fun httpHeaders(@Query("url") url: String): HeadersResponse

    // Security - Geo IP
    @GET("api/security/geoip")
    suspend fun geoIP(@Query("ip") ip: String): GeoIPResponse

    // Security - Reverse IP
    @GET("api/security/reverse-ip")
    suspend fun reverseIP(@Query("ip") ip: String): ReverseIPResponse

    // Security - Traceroute
    @GET("api/security/traceroute")
    suspend fun traceroute(@Query("host") host: String): TracerouteResponse

    // Security - Ping
    @GET("api/security/ping")
    suspend fun pingHost(@Query("host") host: String): PingResponse

    // Security - MAC Lookup
    @GET("api/security/mac")
    suspend fun macLookup(@Query("mac") mac: String): MacResponse

    // Security - CMS Detect
    @GET("api/security/cms")
    suspend fun cmsDetect(@Query("url") url: String): CMSResponse

    // Security - Tech Stack
    @GET("api/security/techstack")
    suspend fun techStack(@Query("url") url: String): TechStackResponse

    // Security - Hash Identify
    @GET("api/security/hash-identify")
    suspend fun hashIdentify(@Query("hash") hash: String): HashIdentifyResponse

    // Security - Metadata Extract
    @GET("api/security/metadata")
    suspend fun metadataExtract(@Query("url") url: String): MetadataResponse

    // Search - GitHub
    @GET("api/search/github")
    suspend fun searchGitHub(@Query("q") query: String): GitHubSearchResponse

    // Search - NPM
    @GET("api/search/npm")
    suspend fun searchNPM(@Query("q") query: String): NPMSearchResponse

    // Search - PyPI
    @GET("api/search/pypi")
    suspend fun searchPyPI(@Query("q") query: String): PyPISearchResponse

    // Search - News
    @GET("api/search/news")
    suspend fun searchNews(
        @Query("q") query: String,
        @Query("lang") lang: String = "en"
    ): NewsSearchResponse

    // Search - Reddit
    @GET("api/search/reddit")
    suspend fun searchReddit(
        @Query("q") query: String,
        @Query("sort") sort: String = "relevance"
    ): RedditResponse

    // Search - StackOverflow
    @GET("api/search/stackoverflow")
    suspend fun searchStackOverflow(@Query("q") query: String): StackOverflowResponse

    // Search - Urban Dictionary
    @GET("api/search/urbandictionary")
    suspend fun searchUrbanDictionary(@Query("q") query: String): UrbanDictResponse

    // Search - Country
    @GET("api/search/country")
    suspend fun searchCountry(@Query("q") query: String): CountryResponse

    // Search - Emoji
    @GET("api/search/emoji")
    suspend fun searchEmoji(@Query("q") query: String): EmojiResponse

    // AI - Translate
    @POST("api/ai/translate")
    suspend fun translate(
        @Body body: Map<String, String>
    ): TranslateResponse

    // AI - Summarize
    @POST("api/ai/summarize")
    suspend fun summarize(@Body body: Map<String, String>): SummarizeResponse

    // AI - Code Generator
    @POST("api/ai/code")
    suspend fun generateCode(@Body body: Map<String, String>): CodeResponse

    // AI - Scanner
    @POST("api/ai/scanner")
    suspend fun scanText(@Body body: Map<String, String>): ScannerResponse

    // AI - Humanizer
    @POST("api/ai/humanizer")
    suspend fun humanizeText(@Body body: Map<String, String>): HumanizeResponse

    // AI - Image Pixabay
    @GET("api/ai/image/pixabay")
    suspend fun getPixabayImages(@Query("q") query: String): PixabayResponse

    // AI - Lorem Picsum
    @GET("api/ai/image/lorem-picsum")
    suspend fun getLoremPicsum(
        @Query("width") width: Int = 800,
        @Query("height") height: Int = 600
    ): PicsumResponse

    // AI - Dog Image
    @GET("api/ai/image/dog")
    suspend fun getDogImage(): DogImageResponse

    // AI - Cat Image
    @GET("api/ai/image/cat")
    suspend fun getCatImage(): CatImageResponse

    // Scraper - Full
    @POST("api/scrape/full")
    suspend fun fullScrape(@Body body: Map<String, String>): ScrapeResponse

    // Scraper - Links
    @GET("api/scrape/links")
    suspend fun extractLinks(@Query("url") url: String): LinksResponse

    // Scraper - Scripts
    @GET("api/scrape/scripts")
    suspend fun extractScripts(@Query("url") url: String): ScriptsResponse

    // Scraper - Cookies
    @GET("api/scrape/cookies")
    suspend fun getCookies(@Query("url") url: String): CookiesResponse

    // Dev Tools - Deobfuscate
    @POST("api/tools/deobfuscate")
    suspend fun deobfuscate(@Body body: Map<String, String>): DeobfuscateResponse

    // Dev Tools - Deminify
    @POST("api/tools/deminify")
    suspend fun deminify(@Body body: Map<String, String>): DeminifyResponse

    // Dev Tools - Run JS
    @POST("api/tools/run-js")
    suspend fun runJavaScript(@Body body: Map<String, String>): RunJSResponse

    // Dev Tools - Auto Decode
    @POST("api/tools/decode")
    suspend fun autoDecode(@Body body: Map<String, String>): DecodeResponse

    // Dev Tools - Headless
    @GET("api/tools/headless")
    suspend fun fetchHeadless(
        @Query("url") url: String,
        @Query("cookies") cookies: String? = null
    ): HeadlessResponse

    // YouTube Search
    @GET("api/search/youtube")
    suspend fun searchYouTube(@Query("q") query: String): YouTubeSearchResponse

    // YouTube Trending
    @GET("api/youtube/trending")
    suspend fun getYouTubeTrending(): YouTubeSearchResponse

    // YouTube Recommend
    @GET("api/youtube/recommend")
    suspend fun getYouTubeRecommend(@Query("id") videoId: String): YouTubeSearchResponse

    // Music Search
    @GET("api/music/search")
    suspend fun searchMusic(@Query("q") query: String): MusicSearchResponse

    // Music Trending
    @GET("api/music/trending")
    suspend fun getMusicTrending(): MusicSearchResponse

    // Music Artist
    @GET("api/music/artist")
    suspend fun searchArtist(@Query("q") artist: String): ArtistResponse

    // Media Status
    @GET("api/media/status")
    suspend fun getMediaStatus(): MediaStatusResponse

    // API Status
    @GET("api/status")
    suspend fun getApiStatus(): StatusResponse

    // API Endpoints
    @GET("api/endpoints")
    suspend fun getAllEndpoints(): EndpointsResponse

    // API Categories
    @GET("api/endpoints/categories")
    suspend fun getEndpointCategories(): CategoriesResponse

    // URL Shortener Services
    @GET("api/short/{service}")
    suspend fun shortenUrlService(
        @Path("service") service: String,
        @Query("url") url: String
    ): ShortUrlResponse

    // Anime
    @GET("api/anime/{type}")
    suspend fun getAnimeImage(@Path("type") type: String): AnimeResponse

    // PhotoFunia List
    @GET("api/photofunia/list")
    suspend fun getPhotofuniaEffects(): PhotofuniaResponse

    // PhotoFunia Generate
    @POST("api/photofunia/generate")
    suspend fun generatePhotofunia(@Body body: Map<String, String>): PhotofuniaGenResponse

    // Sports Live Scores
    @GET("api/sports/live")
    suspend fun getLiveScores(@Query("sport") sport: String? = null): SportsResponse

    // Sports Search Team
    @GET("api/sports/search/team")
    suspend fun searchTeam(@Query("q") query: String): SportsResponse

    // Sports Search Player
    @GET("api/sports/search/player")
    suspend fun searchPlayer(@Query("q") query: String): SportsResponse

    // Sports Leagues
    @GET("api/sports/leagues")
    suspend fun getSportsLeagues(): SportsResponse

    // Sports League Table
    @GET("api/sports/league/table")
    suspend fun getLeagueTable(
        @Query("id") id: String,
        @Query("season") season: String
    ): SportsResponse

    // Sports Team Details
    @GET("api/sports/team/details")
    suspend fun getTeamDetails(@Query("id") id: String): SportsResponse

    // Sports Player Details
    @GET("api/sports/player/details")
    suspend fun getPlayerDetails(@Query("id") id: String): SportsResponse

    // Sports Event Details
    @GET("api/sports/event/details")
    suspend fun getEventDetails(@Query("id") id: String): SportsResponse

    // Sports Events by Day
    @GET("api/sports/events/day")
    suspend fun getEventsByDay(@Query("date") date: String): SportsResponse

    // Image Upload (ImgBB)
    @POST("api/url/imgbb")
    suspend fun uploadImageImgBB(@Body body: Map<String, String>): UploadResponse

    // Image Upload (Catbox)
    @POST("api/url/catbox")
    suspend fun uploadImageCatbox(@Body body: Map<String, String>): UploadResponse

    // Audio Apply Effect
    @GET("api/audio/{effect}")
    suspend fun applyAudioEffect(
        @Path("effect") effect: String,
        @Query("url") url: String
    ): AudioApplyResponse

    // Lyrics
    @GET("download/lyrics")
    suspend fun getLyrics(@Query("q") query: String): LyricsResponse
