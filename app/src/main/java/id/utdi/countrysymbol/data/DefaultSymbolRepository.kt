package id.utdi.countrysymbol.data

import id.utdi.countrysymbol.model.Symbol
import id.utdi.countrysymbol.network.SymbolApiService

interface SymbolRepository {
    suspend fun getSymbol(): List<Symbol>
}

// Implementasi default dari RestaurantRepository
class DefaultSymbolRepository(
    private val symbolApiService: SymbolApiService
) : SymbolRepository {
    override suspend fun getSymbol(): List<Symbol> = symbolApiService.getSymbol()
}
