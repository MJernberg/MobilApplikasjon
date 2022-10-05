package com.example.handleliste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TjenesteAdapter(private val tjenesteListe:ArrayList<Tjeneste>)
    : RecyclerView.Adapter<TjenesteAdapter.TjenesteViewHolder>() {

    var onItemClick : ((Tjeneste) -> Unit)? = null

    class TjenesteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView : TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TjenesteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hver_tjeneste , parent , false)
        return TjenesteViewHolder(view)
    }

    override fun onBindViewHolder(holder: TjenesteViewHolder, position: Int) {
        val tjeneste = tjenesteListe[position]
        holder.imageView.setImageResource(tjeneste.image)
        holder.textView.text = tjeneste.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(tjeneste)
        }
    }

    override fun getItemCount(): Int {
        return tjenesteListe.size
    }

}