package br.com.unipe.projetoAndroid.appRH

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.node_item.view.*


class MyAdapter(private val myDataset: List<Pessoa>, private val context: Context):
    RecyclerView.Adapter<MyAdapter.MyViewHolder> () {

    class MyViewHolder(cardView: View) : RecyclerView.ViewHolder(cardView) {
        val nome = itemView.id_nodeItemNome
        val email = itemView.id_nodeItemEmail
        val username = itemView.id_nodeItemUsername
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val view = LayoutInflater.from(parent.context).inflate(R.layout.node_item, parent, false) as View


        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val node = myDataset.get(position)
        holder?.let {
            it.nome.text = node.nome
            it.email.text = node.email
            it.username.text = node.userName
        }

    }

    override fun getItemCount(): Int {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return myDataset.size
    }

}