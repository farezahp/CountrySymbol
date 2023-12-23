// Package yang menyimpan kelas-kelas terkait data dan repository untuk aplikasi Country Symbol
package id.utdi.countrysymbol.data

// Mengimpor model Symbol dan interface SymbolApiService
import id.utdi.countrysymbol.model.Symbol
import id.utdi.countrysymbol.network.SymbolApiService

// Interface yang mendefinisikan operasi-opsi untuk mendapatkan simbol dari sumber data
interface SymbolRepository {
    // Fungsi penangguhan (suspend) untuk mendapatkan simbol
    suspend fun getSymbol(): List<Symbol>
}

// Implementasi default dari SymbolRepository
class DefaultSymbolRepository(
    // Konstruktor yang menerima instance SymbolApiService sebagai dependensi
    private val symbolApiService: SymbolApiService
) : SymbolRepository {
    // Implementasi fungsi getSymbol() yang memanggil fungsi getSymbol() dari SymbolApiService
    override suspend fun getSymbol(): List<Symbol> = symbolApiService.getSymbol()
}

