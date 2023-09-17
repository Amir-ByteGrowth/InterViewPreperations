package com.example.recyclerviewimpl

import android.content.ClipData.Item
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.recyclerviewimpl.databinding.ItemBinding

class HighPerformanceAdaptor (
    val context: Context,
    private val devicesList: ArrayList<ItemsDataClass>
) :
    RecyclerView.Adapter<HighPerformanceAdaptor.ViewHolder>() {


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

    override fun getItemCount(): Int = devicesList.size


    inner class ViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {

        fun bind(position: Int) {
            devicesList[position].let {
//                binding.imgDeviceIcon.setBackgroundResource(it.deviceIcon)
                it.id.let {
                    binding.tvID.text = it.toString()
                }
                it.name.let {
                    binding.tvName.text = it
                }


                it.imgUrl.let {
                    Glide.with(context)
                        .load(it)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .placeholder(
                            com.google.android.material.R.drawable.ic_clock_black_24dp
                        )
                        .into(binding.img)
                }


            }


        }


    }


}