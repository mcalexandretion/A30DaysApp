package com.example.a30daysapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdviceAdapter(
    private val context: Context,
    private val adviceList: List<Advice>
) : RecyclerView.Adapter<AdviceAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.advice_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val advice = adviceList[position]
        holder.adviceImage.setImageResource(advice.imageResource)
        holder.adviceTitle.text = advice.title
        holder.adviceDay.text = advice.day
        holder.adviceExplanation.text = advice.explanation


        holder.adviceExplanation.visibility = View.GONE


        holder.adviceImage.setOnClickListener {
            if (holder.adviceExplanation.visibility == View.GONE) {
                holder.adviceExplanation.visibility = View.VISIBLE
            } else {
                holder.adviceExplanation.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return adviceList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val adviceImage: ImageView = view.findViewById(R.id.advice_image)
        val adviceTitle: TextView = view.findViewById(R.id.advice_title)
        val adviceDay: TextView = view.findViewById(R.id.advice_day)
        val adviceExplanation: TextView = view.findViewById(R.id.advice_explanation)
    }
}
