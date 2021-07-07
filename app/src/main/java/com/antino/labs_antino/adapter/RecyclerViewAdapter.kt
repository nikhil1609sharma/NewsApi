package com.antino.labs_antino.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.antino.labs_antino.Detailed
import com.antino.labs_antino.R
import com.antino.labs_antino.models.RecyclerData
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(val context: Context): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    var articles = ArrayList<RecyclerData>()


    fun setUpdatedData(articles : ArrayList<RecyclerData>){
        this.articles = articles
        notifyDataSetChanged()
    }


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        var tvTitle: TextView
        var tvAuthor: TextView
        var tvName: TextView
        var Image: ImageView
        var cardView: CardView

        init {
            tvTitle = view.findViewById(R.id.tvTitle)
            tvAuthor = view.findViewById(R.id.tvAuthor)
            tvName = view.findViewById(R.id.tvName)
            Image = view.findViewById(R.id.Image)
            cardView = view.findViewById(R.id.cardView)
        }


//        val urlToImage = view.findViewById<ImageView>(R.id.urlToImage)
//        val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
//        val tvAuthor = view.findViewById<TextView>(R.id.tvAuthor)
//        val tvName = view.findViewById<TextView>(R.id.tvName)
        //var cardView = view.findViewById<CardView>(R.id.cardView)


//        fun bind(data: RecyclerData){
//            tvTitle.text = data.title
//            tvAuthor.text = data.author
//            tvName.text = data.source.name
//
//
//
//            val url = data.urlToImage
//            Picasso.get()
//                .load(url)
//                .into(urlToImage)
//
//
//
//        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val  view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = articles[position]
        Picasso.get().load(data.urlToImage).error(R.drawable.logo).into(holder.Image)
        holder.tvTitle.text = data.title
        holder.tvAuthor.text = data.author
        holder.tvName.text = data.source.name
        holder.cardView.setOnClickListener {
            val intent = Intent(context , Detailed::class.java)
            intent.putExtra("Title", data.title)
            intent.putExtra("Name",data.source.name )
            intent.putExtra("desc", data.description)
            intent.putExtra("imageUrl", data.urlToImage)
            intent.putExtra("url", data.url)
            context.startActivity(intent)

        }


    }

    override fun getItemCount(): Int {
        return articles.size
    }
}