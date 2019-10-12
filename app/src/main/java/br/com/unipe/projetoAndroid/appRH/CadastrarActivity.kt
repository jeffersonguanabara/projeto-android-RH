package br.com.unipe.projetoAndroid.appRH


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastrarActivity : AppCompatActivity() {

    lateinit var editTextName : EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextCPF: EditText
    lateinit var editTextUsername: EditText
    lateinit var editTextPassword: EditText
    lateinit var btnCadastrar : Button

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
        btnCadastrar = findViewById(R.id.id_buttonCadastrar)

        var className = intent.getStringExtra("activity_name")

        btnCadastrar.setOnClickListener{

            if (className.equals("activity_main")) {
                var intent = Intent(CadastrarActivity@ this, ListarActivity::class.java)
                intent.putExtra("activity_name", "activity_cadastrar")
                intent.putExtra("nome", editTextName.text.toString())
                intent.putExtra("email", editTextEmail.text.toString())
                intent.putExtra("CPF", editTextCPF.text.toString())
                intent.putExtra("username", editTextUsername.text.toString())
                intent.putExtra("senha", editTextPassword.text.toString())
                startActivity(intent)
            } else if (className.equals("activity_listar")){
                var intent = Intent(CadastrarActivity@ this, ListarActivity::class.java)
                intent.putExtra("activity_name", "activity_cadastrar")
                intent.putExtra("nome", editTextName.text.toString())
                intent.putExtra("email", editTextEmail.text.toString())
                intent.putExtra("CPF", editTextCPF.text.toString())
                intent.putExtra("username", editTextUsername.text.toString())
                intent.putExtra("senha", editTextPassword.text.toString())
                setResult(RESULT_CODE, intent)
                finish()
            }
        }
    }
}
