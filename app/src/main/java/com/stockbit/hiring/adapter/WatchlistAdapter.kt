package com.stockbit.hiring.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.hiring.R
import com.stockbit.hiring.model.DataResponse
import kotlinx.android.synthetic.main.item_watchlist.view.*

/**
 * Created by Irsyad Abdillah on 14,August,2021
 */
class WatchlistAdapter: RecyclerView.Adapter<WatchlistAdapter.WatchlistViewHolder>() {

    private var list: MutableList<DataResponse> = mutableListOf()

    inner class WatchlistViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind (dataResponse: DataResponse) {

            itemView.txt_name.text = dataResponse.coinInfo.name
            itemView.txt_fullname.text = dataResponse.coinInfo.fullName
            itemView.txt_price.text = dataResponse.raw.usd.price.toString()
            itemView.txt_change24hour.text = dataResponse.raw.usd.change24hour.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchlistAdapter.WatchlistViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_watchlist, parent, false)
        return WatchlistViewHolder(view)
    }

    override fun onBindViewHolder(holder: WatchlistAdapter.WatchlistViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(data: List<DataResponse>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

}