package com.megan.bot.data.api

import com.megan.bot.data.models.*
import retrofit2.http.*

interface MeganApi {
    // Core endpoints that we know work
    @GET("api/ai/{model}")
    suspend fun chatWithAI(@Path("model") model: String, @Query("q") prompt: String): AIResponse

    @GET("download/ytmp4")
    suspend fun downloadYouTube(@Query("url") url: String, @Query("q") query: String? = null): DownloadResponse

    @GET("api/download/tiktok")
    suspend fun downloadTikTok(@Query("url") url: String): TikTokResponse

    @GET("api/download/instagram")
    suspend fun downloadInstagram(@Query("url") url: String): InstagramResponse

    @GET("api/download/facebook")
    suspend fun downloadFacebook(@Query("url") url: String): FacebookResponse

    @GET("api/news/kenya")
    suspend fun getKenyaNews(): NewsResponse

    @GET("api/spotify/search")
    suspend fun searchSpotify(@Query("q") query: String): SpotifyResponse

    @GET("api/crypto/price")
    suspend fun getCryptoPrice(@Query("coin") coin: String): CryptoResponse

    @GET("api/forex/rates")
    suspend fun getForexRates(): ForexResponse

    @GET("api/tools/weather")
    suspend fun getWeather(@Query("city") city: String): WeatherResponse

    @GET("api/game/rps")
    suspend fun playRPS(@Query("move") move: String): GameResponse

    @GET("api/fun-data/dad-joke")
    suspend fun getDadJoke(): FunResponse

    @GET("api/fun-data/kenyan-proverb")
    suspend fun getKenyanProverb(): FunResponse

    @GET("api/search/wiki")
    suspend fun searchWikipedia(@Query("q") query: String): WikiResponse

    @GET("api/tools/qrcode")
    suspend fun generateQR(@Query("text") text: String): QRResponse

    @GET("api/short/tinyurl")
    suspend fun shortenUrl(@Query("url") url: String): ShortUrlResponse

    @GET("api/zodiac/{sign}")
    suspend fun getZodiac(@Path("sign") sign: String): ZodiacResponse

    @GET("api/security/whois")
    suspend fun whoisLookup(@Query("domain") domain: String): WhoisResponse

    @GET("api/tools/password-audit")
    suspend fun auditPassword(@Query("password") password: String): PasswordResponse

    @GET("api/tools/phone-lookup")
    suspend fun phoneLookup(@Query("phone") phone: String): PhoneResponse

    @GET("api/soundcloud/search")
    suspend fun searchSoundCloud(@Query("q") query: String): SoundCloudResponse

    @GET("api/textpro/list")
    suspend fun getTextProEffects(): TextProListResponse

    @GET("api/ephoto/list")
    suspend fun getEphotoEffects(): EphotoListResponse

    @GET("api/audio/list")
    suspend fun getAudioEffects(): AudioEffectsResponse

    @POST("api/ai/image/dall-e")
    suspend fun generateImage(@Body body: Map<String, String>): ImageGenResponse
}
