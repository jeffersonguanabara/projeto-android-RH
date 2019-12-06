package br.com.unipe.projetoAndroid.appRH

import android.app.Application
import android.content.Context

class AppRhApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance : Context? = null
        fun getInstance():Context{
            if(appInstance == null) {
                throw ExceptionInInitializerError("Informe a classe no arquivo do Manifest")
            } else {
                return appInstance as Context
            }
        }
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}