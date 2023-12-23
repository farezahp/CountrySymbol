// Package yang menyimpan kelas aplikasi utama
package id.utdi.countrysymbol

// Mengimpor kelas-kelas yang diperlukan
import android.app.Application
import id.utdi.countrysymbol.data.AppContainer
import id.utdi.countrysymbol.data.DefaultAppContainer

// Kelas SymbolApplication yang merupakan turunan dari Application
class SymbolApplication : Application() {
    // Properti yang merepresentasikan kontainer aplikasi (dependency injection)
    lateinit var container: AppContainer

    // Metode onCreate() yang dipanggil ketika aplikasi dibuat
    override fun onCreate() {
        super.onCreate()
        // Menginisialisasi kontainer dengan implementasi DefaultAppContainer
        container = DefaultAppContainer()
    }
}