package com.juliablack.brastlewarkapp.ui.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliablack.brastlewarkapp.databinding.ViewInhabitantBinding
import com.juliablack.brastlewarkapp.util.displayImage
import com.juliablack.domain.model.Inhabitant

class InhabitantAdapter(var inhabitants: List<Inhabitant>) :
    RecyclerView.Adapter<InhabitantAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ViewInhabitantBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ViewInhabitantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(inhabitants[position]) {
                binding.name.text = name
                binding.image.displayImage(itemView.context, thumbnail)
            }
        }
    }

    override fun getItemCount(): Int {
        return inhabitants.size
    }
}