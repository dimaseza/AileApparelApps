package com.daivers.aileapparel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AllJerseyAdapter(private var data: List<Jersey>,
                       private val listener: (Jersey) -> Unit)
    : RecyclerView.Adapter<AllJerseyAdapter.LeagueViewHolder>(){

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.item_jersey_vertical, parent, false)

        return LeagueViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val tv_title: TextView = view.findViewById(R.id.tv_title_jersey)
        private val tv_price: TextView = view.findViewById(R.id.tv_price_jersey)
        private val tv_desc: TextView = view.findViewById(R.id.tv_desc_jersey)
        private val imageJersey: ImageView = view.findViewById(R.id.iv_image)

        fun bindItem(data: Jersey, listener: (Jersey) -> Unit, context: Context, position: Int){

            tv_title.text = data.title
            tv_price.text = data.harga
            tv_desc.text = data.desc

            Glide.with(context)
                .load(data.image)
                .into(imageJersey)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}