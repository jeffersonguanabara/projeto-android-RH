
package br.com.unipe.projetoAndroid.appRH.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unipe.projetoAndroid.appRH.R
import br.com.unipe.projetoAndroid.appRH.adapter.MyAdapter
import br.com.unipe.projetoAndroid.appRH.model.Pessoa
import br.com.unipe.projetoAndroid.appRH.service.PessoaService
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class ListarActivity : AppCompatActivity() {

    private lateinit var recicleView : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var floatingActionButton: FloatingActionButton


    private lateinit var pessoas : List<Pessoa>

    companion object {
        const val RESULT_CODE = 1
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)


        setSupportActionBar(findViewById(R.id.id_toolbarListar))
        salvar(intent)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == CadastrarActivity.RESULT_CODE) {
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


        doAsync {
            pessoas = PessoaService.listarTodas()

            uiThread {
                Log.e("ListarActivity", pessoas.toString())
            }
        }

        print(pessoas.toString())

        viewManager = LinearLayoutManager(this)
        viewAdapter =
            MyAdapter(pessoas, this)

        recicleView = findViewById<RecyclerView>(R.id.id_RecicleViewListar).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter
        }

        floatingActionButton = findViewById(R.id.id_floatingButtonAdicionar)

        floatingActionButton.setOnClickListener{
            var intent = Intent(ListarActivity@this, CadastrarActivity::class.java)
            intent.putExtra("activity_name", "activity_listar")
            startActivityForResult(intent,
                REQUEST_CODE
            )
        }
    }

}
