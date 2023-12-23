package id.utdi.countrysymbol.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import id.utdi.countrysymbol.R
import id.utdi.countrysymbol.ui.screens.HomeScreen
import id.utdi.countrysymbol.ui.screens.SymbolViewModel

// Anotasi @OptIn untuk mengaktifkan fitur ExperimentalMaterial3Api
@OptIn(ExperimentalMaterial3Api::class)
// Fungsi komposabel utama untuk menampilkan aplikasi
@Composable
fun SymbolApp() {
    // Menerapkan komponen Scaffold sebagai struktur dasar layar
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            // Menampilkan TopAppBar dengan judul aplikasi
            TopAppBar(
                title = {
                    Text(
                        "Lambang Provinsi Indonesia",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            )
        }
    ) {
        // Menetapkan Surface (kontainer) dengan warna latar belakang dari tema
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Menginisialisasi ViewModel menggunakan extension function 'viewModel'
            val symbolViewModel: SymbolViewModel =
                viewModel(factory = SymbolViewModel.Factory)

            // Menampilkan HomeScreen yang berisi UI utama aplikasi
            HomeScreen(
                // Meneruskan state UI dari ViewModel
                symbolUiState = symbolViewModel.symbolUiState,
                // Meneruskan aksi untuk memuat ulang data dari ViewModel
                retryAction = symbolViewModel::getSymbol,
                modifier = Modifier.fillMaxSize(),
                // Meneruskan padding dari Scaffold
                contentPadding = it
            )
        }
    }
}