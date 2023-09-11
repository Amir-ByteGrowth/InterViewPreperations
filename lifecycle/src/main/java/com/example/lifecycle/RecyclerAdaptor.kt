package com.example.lifecycle

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.ArrayList
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class WalletRecyclerAdapter(
    val context: Context,
    val walletDataArrayList: ArrayList<DataClass>,

) :
    RecyclerView.Adapter<WalletRecyclerAdapter.ViewHolder>() {

    interface ReviewRecyclerAdapterClickListener {

        fun onItemClickListener(type: String)
        fun onChildItemClick(position: Int)
    }




    private var onClickListener: ReviewRecyclerAdapterClickListener? = null

    fun setOnEntryClickListener(onEntryClickListener: ReviewRecyclerAdapterClickListener?) {
        onClickListener = onEntryClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return ViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = walletDataArrayList.size


    inner class ViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(
            inflater.inflate(
                R.layout.item_recyler_adaptor,
                parent,
                false
            )
        ) {


        private var tv1: TextView? = null
        private var tv2: TextView? = null


        init {
            tv1 = itemView.findViewById(R.id.tv1)
            tv2 = itemView.findViewById(R.id.tv2)

        }

        fun bind(position: Int) {
            val walletDataModel = walletDataArrayList[position]
            tv1?.text = walletDataModel.title
            tv2?.text = walletDataModel.description


        }

    }


}