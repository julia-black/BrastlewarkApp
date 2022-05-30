package com.juliablack.brastlewarkapp.ui.details.view


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliablack.brastlewarkapp.databinding.ViewSimpleTextBinding

class TextSimpleAdapter(private val strings: List<String>) :
    RecyclerView.Adapter<TextSimpleAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ViewSimpleTextBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ViewSimpleTextBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        strings[position].let { item ->
            holder.binding.title.text = item
        }
    }

    override fun getItemCount() = strings.size
}