package br.com.unipe.projetoAndroid.appRH.database

import androidx.room.Room
import br.com.unipe.projetoAndroid.appRH.dao.PessoaDAO
import br.com.unipe.projetoAndroid.appRH.AppRhApplication

object DatabaseManager {

    var appDatabase : Database

    init {
        var appContext = AppRhApplication.getInstance()
        appDatabase = Room.databaseBuilder(
            appContext,
            Database::class.java,
            "dbAppRH.sqlite"
        ).build()
    }

    fun pessoaDAO():PessoaDAO{
        return appDatabase.pessoaDAO()
    }
}