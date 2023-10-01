package com.example.motionlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
//import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayout.databinding.ItemBinding

//import com.example.motionlayout.databinding.ItemBinding

class Adaptor (
    val context: Context,
    private val items: ArrayList<String>
) :
    RecyclerView.Adapter<Adaptor.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = items.size


    inner class ViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {

        fun bind(position: Int) {
            items[position].let { paymentLinkType ->

                binding.tvNAme.text = paymentLinkType


            }


        }


    }


}