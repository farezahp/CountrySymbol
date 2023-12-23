package id.utdi.countrysymbol.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import id.utdi.countrysymbol.network.SymbolApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val symbolRepository: SymbolRepository
}

class DefaultAppContainer : AppContainer {
    // URL dasar dari API simbol
    private val BASE_URL = "https://symbolsofindonesia.vercel.app/"

// Instance Retrofit untuk berkomunikasi dengan API
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

// Lazy initialization untuk instance retrofitService
    private val retrofitService: SymbolApiService by lazy {
        retrofit.create(SymbolApiService::class.java)
    }

// Lazy initialization untuk instance symbolRepository
    override val symbolRepository: SymbolRepository by lazy {
    // Menggunakan implementasi default DefaultSymbolRepository dengan menyediakan retrofitService sebagai dependensi
        DefaultSymbolRepository(retrofitService)
    }
}

