package id.utdi.countrysymbol

import android.app.Application
import id.utdi.countrysymbol.data.AppContainer
import id.utdi.countrysymbol.data.DefaultAppContainer

class SymbolApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
