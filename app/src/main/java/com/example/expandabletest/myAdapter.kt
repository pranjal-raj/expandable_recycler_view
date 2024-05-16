package com.example.expandabletest

import androidx.transition.ChangeBounds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class myAdapter(val list  : ArrayList<String>) : RecyclerView.Adapter<myAdapter.myViewHolder>() {
    inner class myViewHolder(itemView : View,parent: ViewGroup ) : ViewHolder(itemView){
        val heading = itemView.findViewById<TextView>(R.id.heading)
        val description = itemView.findViewById<TextView>(R.id.desc)
        val root = itemView.findViewById<CardView>(R.id.root)
        val parent = parent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return myViewHolder(view, parent)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.heading.text = "Heading$position"
        holder.description.text = list[position]

        holder.root.setOnClickListener{
           expand(holder)
        }
    }

    private fun expand(holder: myViewHolder) {
        if(holder.description.visibility == View.VISIBLE)
        {
            TransitionManager.beginDelayedTransition(holder.parent, ChangeBounds() ).also {
                holder.description.visibility = View.GONE
            }

        }
        else {
            TransitionManager.beginDelayedTransition(holder.parent, ChangeBounds().apply { duration = 200 })
            holder.description.visibility = View.VISIBLE
        }
    }


    override fun getItemCount(): Int = list.size
}