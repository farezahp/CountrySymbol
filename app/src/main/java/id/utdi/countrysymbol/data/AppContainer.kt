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
    private val BASE_URL = "https://symbolsofindonesia.vercel.app/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()


    private val retrofitService: SymbolApiService by lazy {
        retrofit.create(SymbolApiService::class.java)
    }


    override val symbolRepository: SymbolRepository by lazy {
        DefaultSymbolRepository(retrofitService)
    }
}

