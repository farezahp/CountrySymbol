// Package yang menyimpan kelas-kelas terkait tampilan layar utama aplikasi Country Symbol
package id.utdi.countrysymbol.ui.screens

// Mengimpor pustaka-pustaka yang diperlukan untuk membuat UI dengan Compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import id.utdi.countrysymbol.R
import id.utdi.countrysymbol.model.Symbol

// Fungsi komposabel untuk menampilkan layar utama aplikasi
@Composable
fun HomeScreen(
    symbolUiState: SymbolUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    // Menentukan tampilan berdasarkan state UI
    when (symbolUiState) {
        is SymbolUiState.Loading -> LoadingScreen(modifier.size(200.dp))
        is SymbolUiState.Success ->
            SymbolListScreen(
                symbol = symbolUiState.symbol,
                modifier = modifier
                    .padding(
                        start = 20.dp,
                        top = 20.dp,
                        end = 20.dp
                    ),
                contentPadding = contentPadding
            )
        else -> ErrorScreen(retryAction, modifier)
    }
}

// Fungsi komposabel untuk menampilkan layar loading
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    // Menampilkan gambar loading
    Image(
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "Loading",
        modifier = modifier
    )
}

// Fungsi komposabel untuk menampilkan layar error
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    // Menampilkan pesan error dan tombol "Coba Lagi"
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Gagal Memuat Data")
        Button(onClick = retryAction) {
            Text("Coba Lagi")
        }
    }
}

// Fungsi komposabel untuk menampilkan kartu simbol
@Composable
fun SymbolCard(symbol: Symbol, modifier: Modifier = Modifier) {
    // Menampilkan kartu dengan judul dan gambar simbol
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = symbol.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https://symbolsofindonesia.vercel.app/${symbol.url}")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                error = painterResource(id = R.drawable.broken_img),
                placeholder = painterResource(id = R.drawable.loading_img)
            )
        }
    }
}

// Fungsi komposabel untuk menampilkan daftar simbol
@Composable
private fun SymbolListScreen(
    symbol: List<Symbol>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    // Menampilkan daftar simbol dengan menggunakan LazyColumn
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(
            items = symbol,
            key = { sym ->
                sym.title
            }
        ) { symbol ->
            // Menampilkan kartu simbol untuk setiap item dalam daftar
            SymbolCard(symbol = symbol, modifier = Modifier.fillMaxSize())
        }
    }
}
