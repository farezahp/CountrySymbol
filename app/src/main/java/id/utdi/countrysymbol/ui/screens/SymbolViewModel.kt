// Package yang menyimpan kelas terkait layar UI (screens) pada aplikasi Country Symbol
package id.utdi.countrysymbol.ui.screens

// Mengimpor pustaka-pustaka yang diperlukan
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.utdi.countrysymbol.SymbolApplication
import id.utdi.countrysymbol.data.SymbolRepository
import id.utdi.countrysymbol.model.Symbol
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

// Sebuah antarmuka yang menyatakan berbagai keadaan UI yang mungkin terjadi
sealed interface SymbolUiState {
    data class Success(val symbol: List<Symbol>) : SymbolUiState
    object Error : SymbolUiState
    object Loading : SymbolUiState
}

// Kelas ViewModel yang bertanggung jawab untuk menangani logika bisnis dan state UI
class SymbolViewModel(private val symbolRepository: SymbolRepository) : ViewModel() {

    // Properti state UI yang diawasi (observable) menggunakan mutableStateOf
    var symbolUiState: SymbolUiState by mutableStateOf(SymbolUiState.Loading)
        private set

    // Blok inisialisasi untuk memanggil fungsi getSymbol() saat ViewModel dibuat
    init {
        getSymbol()
    }

    // Fungsi untuk mendapatkan simbol dari repository
    fun getSymbol() {
        viewModelScope.launch {
            // Mengubah state menjadi Loading sebelum mendapatkan simbol
            symbolUiState = SymbolUiState.Loading
            // Menggunakan blok try-catch untuk menangani IOException dan HttpException
            symbolUiState = try {
                SymbolUiState.Success(symbolRepository.getSymbol())
            } catch (e: IOException) {
                SymbolUiState.Error
            } catch (e: HttpException) {
                SymbolUiState.Error
            }
        }
    }

    // Companion object yang menyediakan ViewModel Factory untuk dependency injection
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // Mengambil instance SymbolApplication dari ViewModelProvider
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as SymbolApplication)
                // Mendapatkan repository simbol dari kontainer aplikasi
                val symbolRepository = application.container.symbolRepository
                // Membuat dan mengembalikan instance SymbolViewModel
                SymbolViewModel(symbolRepository = symbolRepository)
            }
        }
    }
}
