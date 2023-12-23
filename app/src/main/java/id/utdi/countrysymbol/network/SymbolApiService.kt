package id.utdi.countrysymbol.network

import id.utdi.countrysymbol.model.Symbol
import retrofit2.http.GET

interface SymbolApiService {
    @GET("provinces/200")
    suspend fun getSymbol(): List<Symbol>
}