package com.dicoding.picodiploma.mycomputershopapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListItemsAdapter(private val listItems: ArrayList<Items>) : RecyclerView.Adapter<ListItemsAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_item, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val items = listItems[position]

        Glide.with(holder.itemView.context)
            .load(items.itemPhoto)
            .apply(RequestOptions().override(65, 65))
            .into(holder.itemPhoto)

        holder.itemName.text = items.itemName
        holder.itemDetail.text = items.itemDetail
        holder.itemPrice.text = "Rp ${items.itemPrice}"

        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listItems[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int {
        return listItems.size
    }


    inner class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.id_item_name)
        var itemDetail : TextView = itemView.findViewById(R.id.id_item_detail)
        var itemPrice : TextView = itemView.findViewById(R.id.id_item_price)
        var itemPhoto : ImageView = itemView.findViewById(R.id.id_item_img)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Items)
    }

}