package br.com.unipe.projetoAndroid.appRH

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var btnEntrar : Button
    lateinit var btnCadastrar : TextView

    companion object {
        const val REQUEST_CODE = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.id_editTextUser)
        password = findViewById(R.id.id_editPassword)
        btnEntrar = findViewById(R.id.id_btnEntrar)

        btnEntrar.setOnClickListener {

            if (username.text.toString().equals("")) {
                Toast.makeText(MainActivity@this, "Campo de usuário vazio",Toast.LENGTH_LONG).show()
            } else if (password.text.toString().equals("")){
                Toast.makeText(MainActivity@this, "Campo senha vazio", Toast.LENGTH_LONG).show()
            } else {
                var intent = Intent(MainActivity@this, ListarActivity::class.java)
                intent.putExtra("activity_name", "activity_main")
                intent.putExtra("username", username.text.toString())
                intent.putExtra("password", username.text.toString())
                startActivityForResult(intent, REQUEST_CODE)
            }
        }

        btnCadastrar = findViewById(R.id.id_textViewCadastrar)

        btnCadastrar.setOnClickListener{
            var intent = Intent(MainActivity@this, CadastrarActivity::class.java)
            intent.putExtra("activity_name", "activity_main")
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == ListarActivity.RESULT_CODE) {
            if (data != null) {
                Toast.makeText(MainActivity@this, "Nenhum usuário cadastrado!", Toast.LENGTH_LONG).show()
            }
        }
    }


}
