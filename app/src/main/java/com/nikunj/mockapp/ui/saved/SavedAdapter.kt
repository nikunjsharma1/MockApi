package com.nikunj.mockapp.ui.saved

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nikunj.mockapp.R
import com.nikunj.mockapp.local.ClassesEntity
import com.nikunj.mockapp.model.ClassesName
import com.nikunj.mockapp.util.OnClickItemDelete
import com.nikunj.mockapp.util.OnClickItemPackage


class SavedAdapter(val context: Context, private val articlesM: MutableList<ClassesEntity>):
    RecyclerView.Adapter<SavedAdapter.ArticleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articles = articlesM?.get(position)


        holder.name.text = articles.name

        holder.dose1.text =  articles.dose

        holder.strenth.text =  articles.strength
       holder.save.visibility=View.INVISIBLE

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