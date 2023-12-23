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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SymbolApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
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
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val symbolViewModel: SymbolViewModel =
                viewModel(factory = SymbolViewModel.Factory)
            HomeScreen(
                symbolUiState = symbolViewModel.symbolUiState,
                retryAction = symbolViewModel::getSymbol,
                modifier = Modifier.fillMaxSize(),
                contentPadding = it
            )
        }
    }
}