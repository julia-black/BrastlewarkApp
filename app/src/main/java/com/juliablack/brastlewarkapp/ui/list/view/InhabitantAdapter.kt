package com.juliablack.brastlewarkapp.ui.list.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juliablack.brastlewarkapp.databinding.ViewInhabitantBinding
import com.juliablack.brastlewarkapp.util.displayImage
import com.juliablack.domain.model.Inhabitant

class InhabitantAdapter(
    private val inhabitants: List<Inhabitant>,
    private val onClick: (inhabitant: Inhabitant) -> Unit
) :
    RecyclerView.Adapter<InhabitantAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ViewInhabitantBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ViewInhabitantBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            inhabitants[position].let { item ->
                with(binding) {
                    name.text = item.name
                    image.displayImage(itemView.context, item.thumbnail, 80, 80)
                    root.setOnClickListener {
                        onClick.invoke(item)
                    }
                }
            }
        }
    }

    override fun getItemCount() = inhabitants.size
}