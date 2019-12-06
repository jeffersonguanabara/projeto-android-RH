package br.com.unipe.projetoAndroid.appRH.service

import br.com.unipe.projetoAndroid.appRH.database.DatabaseManager
import br.com.unipe.projetoAndroid.appRH.model.Pessoa

object PessoaService {

    fun inserir(pessoa:Pessoa) = DatabaseManager.pessoaDAO().insert(pessoa)
    fun alterar(pessoa: Pessoa) = DatabaseManager.pessoaDAO().update(pessoa)
    fun deletar(pessoa: Pessoa) = DatabaseManager.pessoaDAO().delete(pessoa)
    fun listarTodas():List<Pessoa> = DatabaseManager.pessoaDAO().findAll()
    fun buscarPorId(id:Long):Pessoa = DatabaseManager.pessoaDAO().findById(id)
}