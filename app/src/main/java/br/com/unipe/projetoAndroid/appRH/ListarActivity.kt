
package br.com.unipe.projetoAndroid.appRH

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import java.util.*

class ListarActivity : AppCompatActivity() {

    private lateinit var recicleView : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var floatingActionButton: FloatingActionButton


    private var pessoas = LinkedList<Pessoa>()

    companion object {
        const val RESULT_CODE = 1
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)


        setSupportActionBar(findViewById(R.id.id_toolbarListar))
//        supportActionBar?.setDisplayShowHomeEnabled(true)
//        supportActionBar?.setDisplayShowTitleEnabled(true)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        salvar(intent)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ListarActivity.REQUEST_CODE && resultCode == CadastrarActivity.RESULT_CODE) {
            if (data != null) {
                salvar(data)
                Toast.makeText(ListarActivity@this, "Usuário cadastrado com sucesso!", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_app_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    fun salvar(intent: Intent) {
        var className = intent.getStringExtra("activity_name")
        var usuario = intent.getStringExtra("username")
        var senhaLogin = intent.getStringExtra("senha")

//        if (className.equals("activity_main")) {
////            if (pessoas.isEmpty()){
////                var intent = Intent()
////                intent.putExtra("mensagem", "Nenhum usuário cadastrado!")
////                setResult(RESULT_CODE, intent)
////                finish()
////            }
//
//        } else
        if(className.equals("activity_cadastrar")) {
            var nome = intent.getStringExtra("nome")
            var email = intent.getStringExtra("email")
            var cpf = intent.getStringExtra("CPF")
            var username = intent.getStringExtra("username")
            var senha = intent.getStringExtra("senha")
            pessoas.add(Pessoa(cpf, nome, email, username, senha))
        }
        print(pessoas.toString())

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(pessoas, this)

        recicleView = findViewById<RecyclerView>(R.id.id_RecicleViewListar).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }

        floatingActionButton = findViewById(R.id.floatingActionButton)

        floatingActionButton.setOnClickListener{
            var intent = Intent(ListarActivity@this, CadastrarActivity::class.java)
            intent.putExtra("activity_name", "activity_listar")
            startActivityForResult(intent, REQUEST_CODE)
        }
    }
}
