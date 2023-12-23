package id.utdi.countrysymbol.model

import kotlinx.serialization.Serializable

@Serializable
data class Symbol(
    val title: String,          // Nama Provinsi
    val url: String,            // URL Gambar
)