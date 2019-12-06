package br.com.unipe.projetoAndroid.appRH.dao

import androidx.room.*
import br.com.unipe.projetoAndroid.appRH.model.Pessoa

@Dao
interface PessoaDAO {

    @Query("SELECT * FROM pessoa WHERE id = :id")
    fun findById(id:Long) : Pessoa
    @Query("SELECT * FROM pessoa")
    fun findAll():List<Pessoa>
    @Insert
    fun insert(pessoa: Pessoa)
    @Update
    fun update(pessoa: Pessoa)
    @Delete
    fun delete(pessoa: Pessoa)

}