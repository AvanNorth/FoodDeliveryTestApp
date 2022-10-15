package com.example.fooddeliverytestapp.data.adapter

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddeliverytestapp.R
import com.example.fooddeliverytestapp.domain.entity.CardMenuDataClass
import com.google.android.material.button.MaterialButton


class MenuAdapter(private val context: Context, private val onItemClick: (dataList: MutableList<CardMenuDataClass>, position: Int) -> Unit) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    private var dataSet = mutableListOf<CardMenuDataClass>()
    private var lastListSize = 0

    internal fun setDataList(dataSet: MutableList<CardMenuDataClass>) {
        this.dataSet = dataSet
        notifyItemRangeInserted(lastListSize, dataSet.size)
        saveListSize()
    }

    class ViewHolder(itemView: View, private val onItemClick: (dataSet: MutableList<CardMenuDataClass>, pos: Int) -> Unit, dataSet: MutableList<CardMenuDataClass>) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView
        var descrTextView: TextView
        var imageView: ImageView
        var priceButton: MaterialButton

        init {
            itemView.setOnClickListener {
                onItemClick(dataSet, adapterPosition)
            }

            titleTextView = itemView.findViewById(R.id.titleTV)
            descrTextView = itemView.findViewById(R.id.descrTV)
            imageView = itemView.findViewById(R.id.pizzaIV) as ImageView
            priceButton = itemView.findViewById(R.id.priceBtn)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_cards, parent, false)
        return ViewHolder(view, onItemClick, dataSet)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val titleTextView = holder.titleTextView
        val descrTextView = holder.descrTextView
        val imageView: ImageView = holder.imageView
        val priceBtn: MaterialButton = holder.priceButton

        titleTextView.text = dataSet[listPosition].title
        descrTextView.text = dataSet[listPosition].description
        imageView.setImageResource(dataSet[listPosition].image)
        priceBtn.text = context.getString(R.string.price, dataSet[listPosition].price.toString())
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    private fun saveListSize() {
        lastListSize = dataSet.size
    }
}