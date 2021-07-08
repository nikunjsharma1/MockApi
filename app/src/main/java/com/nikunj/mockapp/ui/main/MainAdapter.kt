package com.nikunj.mockapp.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nikunj.mockapp.R
import com.nikunj.mockapp.model.ClassesName
import com.nikunj.mockapp.util.OnClickItemPackage


class MainAdapter(val context: Context, private val articlesM: MutableList<ClassesName>):
    RecyclerView.Adapter<MainAdapter.ArticleViewHolder>() {
    var clickItemPackage: OnClickItemPackage? =null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articles = articlesM?.get(position)


        holder.name.text = articles.name

        holder.dose1.text =  articles.dose

        holder.strenth.text =  articles.strength
        holder.save.setOnClickListener {
            val popup = PopupMenu(context, holder.save)

            popup.inflate(R.menu.menu_rec)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu1 -> {
                        clickItemPackage?.onClick(articles,position)
                    }

                }
                false
            }

            popup.show()
        }

    }


    override fun getItemCount(): Int {
        return articlesM.size



    }
    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var save: ImageView =itemView.findViewById<ImageView>(R.id.deleteImg)


        var name = itemView.findViewById<TextView>(R.id.namea)
        var dose1 = itemView.findViewById<TextView>(R.id.dose)
        var strenth = itemView.findViewById<TextView>(R.id.strength)
    }

}