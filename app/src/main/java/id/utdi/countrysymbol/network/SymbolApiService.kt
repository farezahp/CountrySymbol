// Package yang menyimpan kelas-kelas terkait jaringan (network) untuk aplikasi Country Symbol
package id.utdi.countrysymbol.network

// Mengimpor model Symbol dan anotasi GET dari Retrofit
import id.utdi.countrysymbol.model.Symbol
import retrofit2.http.GET

// Interface yang mendefinisikan end-point API untuk mendapatkan simbol
interface SymbolApiService {
    // Anotasi GET menunjukkan bahwa ini adalah permintaan HTTP GET
    // Endpoint "provinces/200" akan digunakan untuk mendapatkan simbol
    @GET("provinces/200")
    // Fungsi suspend untuk digunakan dengan fungsi eksternal yang bersifat penangguhan
    suspend fun getSymbol(): List<Symbol>
}
