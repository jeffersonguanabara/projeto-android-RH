package br.com.unipe.projetoAndroid.appRH.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.unipe.projetoAndroid.appRH.dao.PessoaDAO
import br.com.unipe.projetoAndroid.appRH.model.Pessoa

@Database(entities = arrayOf(Pessoa::class), version = 1)
abstract class Database : RoomDatabase() {

    abstract fun pessoaDAO(): PessoaDAO

}