package com.juliablack.brastlewarkapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.juliablack.brastlewarkapp.R
import com.juliablack.brastlewarkapp.databinding.FragmentDetailsBinding
import com.juliablack.brastlewarkapp.ui.details.view.TextSimpleAdapter
import com.juliablack.brastlewarkapp.util.displayImage
import com.juliablack.domain.model.Inhabitant

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val inhabitant by lazy {
        arguments?.get(ARG_INHABITANT) as Inhabitant
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showInhabitant(inhabitant)
    }

    private fun showInhabitant(inhabitant: Inhabitant) {
        with(binding) {
            inhabitant.let {
                image.displayImage(requireContext(), it.thumbnail, 200, 200)
                name.text = it.name
                age.text = getString(R.string.age, it.age)
                weight.text = getString(R.string.weight, it.weight)
                height.text = getString(R.string.height, it.height)
                hairColor.text = getString(R.string.hair_color, it.hairColor)

                professions.adapter = TextSimpleAdapter(it.professions)
                professions.layoutManager = LinearLayoutManager(context)

                friends.adapter = TextSimpleAdapter(it.friends)
                friends.layoutManager = LinearLayoutManager(context)
            }
        }
    }

    companion object {
        private const val ARG_INHABITANT = "arg_inhabitant"

        fun newInstance(inhabitant: Inhabitant) = DetailsFragment().apply {
            arguments = bundleOf(ARG_INHABITANT to inhabitant)
        }
    }
}