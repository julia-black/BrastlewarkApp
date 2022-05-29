package com.juliablack.brastlewarkapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.juliablack.brastlewarkapp.R
import com.juliablack.brastlewarkapp.databinding.FragmentListBinding
import com.juliablack.brastlewarkapp.ui.details.DetailsFragment
import com.juliablack.brastlewarkapp.ui.list.view.InhabitantAdapter
import com.juliablack.brastlewarkapp.util.gone
import com.juliablack.brastlewarkapp.util.visible
import com.juliablack.domain.model.Inhabitant
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModel()

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setListeners()
    }

    private fun setListeners() {
        binding.reloadButton.setOnClickListener {
            viewModel.getInhabitants()
        }
    }

    private fun setObservers() {
        with(binding) {
            viewModel.liveInhabitants.observe(viewLifecycleOwner) {
                list.adapter = InhabitantAdapter(it) { item ->
                    toDetails(item)
                }
                list.layoutManager = LinearLayoutManager(context)
                messageError.gone()
                reloadButton.gone()
            }
            viewModel.liveError.observe(viewLifecycleOwner) {
                messageError.text = getString(R.string.error, it)
                messageError.visible()
                reloadButton.visible()
            }
        }
    }

    private fun toDetails(inhabitant: Inhabitant) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, DetailsFragment.newInstance(inhabitant))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun newInstance() = ListFragment()
    }
}