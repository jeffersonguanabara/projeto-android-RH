package br.com.unipe.projetoAndroid.appRH.activities


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.unipe.projetoAndroid.appRH.R
import br.com.unipe.projetoAndroid.appRH.model.Pessoa
import br.com.unipe.projetoAndroid.appRH.service.PessoaService
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class CadastrarActivity : AppCompatActivity() {

    lateinit var editTextName : EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextCPF: EditText
    lateinit var editTextUsername: EditText
    lateinit var editTextPassword: EditText
    lateinit var btnCadastrar : Button
    lateinit var checkBoxAdmin: CheckBox

    companion object {
        const val RESULT_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)

        editTextName = findViewById(R.id.id_editTextNomeCadastro)
        editTextEmail = findViewById(R.id.id_editTextEmailCadastro)
        editTextCPF = findViewById(R.id.id_editTextCPFCadastro)
        editTextUsername = findViewById(R.id.id_editTextUserNameCadastro)
        editTextPassword = findViewById(R.id.id_editTextSenhaCadastro)
        checkBoxAdmin = findViewById(R.id.id_checkBoxAdmin)
        btnCadastrar = findViewById(R.id.id_buttonCadastrar)


        var className = intent.getStringExtra("activity_name")

        btnCadastrar.setOnClickListener{

            var intent = Intent(CadastrarActivity@ this, ListarActivity::class.java)

            var pessoa = Pessoa()

            pessoa.nome = editTextName.text.toString()
            pessoa.email = editTextEmail.text.toString()
            pessoa.cpf = editTextCPF.text.toString()
            pessoa.userName = editTextUsername.text.toString()
            pessoa.senha = editTextPassword.text.toString()

            if (checkBoxAdmin.isChecked)
                pessoa.ehAdmin = 1
            else
                pessoa.ehAdmin = 0

            inserir(pessoa)

            if (className.equals("activity_main")) {
                startActivity(intent)
            } else if (className.equals("activity_listar")) {
                setResult(RESULT_CODE, intent)
                finish()
            }
        }
    }

    fun inserir(pessoa: Pessoa) {
        doAsync {
            PessoaService.inserir(pessoa)

            uiThread {
                Log.e("CadastrarActivity", "Usuário cadastrado com sucesso!")
            }
        }
    }
}
