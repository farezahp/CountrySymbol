package id.utdi.countrysymbol.ui.screens

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


sealed interface SymbolUiState {
    data class Success(val symbol: List<Symbol>) : SymbolUiState
    object Error : SymbolUiState
    object Loading : SymbolUiState
}

class SymbolViewModel (private val symbolRepository: SymbolRepository) : ViewModel() {

    var symbolUiState: SymbolUiState by mutableStateOf(SymbolUiState.Loading)
        private set

    init {
        getSymbol()
    }

    fun getSymbol() {
        viewModelScope.launch {
            symbolUiState = SymbolUiState.Loading
            symbolUiState = try {
                SymbolUiState.Success(symbolRepository.getSymbol())
            } catch (e: IOException) {
                SymbolUiState.Error
            } catch (e: HttpException) {
                SymbolUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as SymbolApplication)
                val symbolRepository = application.container.symbolRepository
                SymbolViewModel(symbolRepository = symbolRepository)
            }
        }
    }
}