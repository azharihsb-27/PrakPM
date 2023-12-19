package com.example.prakpm

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.prakpm.databinding.ItemDataBinding

class DataAdapter (val data: List<DataItem>?, private val click: OnClickItem) : RecyclerView.Adapter<DataAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun getItemCount() = data?.size ?:0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.onBind(data?.get(position))
        holder.binding.root.setOnClickListener {
            click.clicked(data?.get(position))
        }
        holder.binding.btnHapus.setOnClickListener {
            click.delete(data?.get(position))
        }

    }
    class MyHolder(val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(get: DataItem?) {
            binding.tvName.text = get?.staffName
            binding.tvPhone.text = get?.staffHp
            binding.tvAddress.text = get?.staffAddress
        }
    }

    interface OnClickItem {
        fun clicked (item: DataItem?)
        fun delete (item: DataItem?)
    }


}