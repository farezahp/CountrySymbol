// Package yang menyimpan kelas untuk pengujian unit lokal
package id.utdi.countrysymbol

// Mengimpor pustaka-pustaka yang diperlukan untuk pengujian unit
import org.junit.Test

import org.junit.Assert.*

/**
 * Contoh pengujian unit lokal, yang akan dieksekusi pada mesin pengembangan (host).
 *
 * Lihat [dokumentasi pengujian](http://d.android.com/tools/testing).
 */
// Kelas untuk pengujian unit lokal
class ExampleUnitTest {
    // Metode pengujian unit untuk memastikan bahwa penambahan berfungsi dengan benar
    @Test
    fun addition_isCorrect() {
        // Memastikan bahwa hasil penambahan dari 2 + 2 adalah 4
        assertEquals(4, 2 + 2)
    }
}
