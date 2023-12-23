// Package yang menyimpan kelas untuk pengujian instrumental
package id.utdi.countrysymbol

// Mengimpor pustaka-pustaka yang diperlukan untuk pengujian
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Pengujian instrumental, yang akan dieksekusi pada perangkat Android.
 *
 * Lihat [dokumentasi pengujian](http://d.android.com/tools/testing).
 */
// Menentukan bahwa kelas ini akan dijalankan menggunakan AndroidJUnit4
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    // Metode pengujian yang menggunakan konteks aplikasi
    @Test
    fun useAppContext() {
        // Mengambil konteks dari aplikasi yang sedang diuji
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        // Memastikan bahwa nama paket aplikasi sesuai dengan yang diharapkan
        assertEquals("id.utdi.countrysymbol", appContext.packageName)
    }
}
