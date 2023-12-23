// Package yang menyimpan kelas-kelas terkait aplikasi Country Symbol
package id.utdi.countrysymbol

// Mengimpor pustaka-pustaka yang diperlukan
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import id.utdi.countrysymbol.ui.SymbolApp
import id.utdi.countrysymbol.ui.theme.CountrySymbolTheme

// Kelas utama MainActivity yang merupakan turunan dari ComponentActivity
class MainActivity : ComponentActivity() {
    // Fungsi onCreate() yang dipanggil ketika aktivitas dibuat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menetapkan tata letak konten aktivitas menggunakan Compose
        setContent {
            // Menggunakan tema CountrySymbolTheme untuk seluruh aplikasi
            CountrySymbolTheme {
                // Menetapkan Surface (kontainer) dengan warna latar belakang dari tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Menampilkan UI aplikasi menggunakan komponen SymbolApp
                    SymbolApp()
                }
            }
        }
    }
}

