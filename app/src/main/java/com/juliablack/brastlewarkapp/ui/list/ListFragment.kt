package com.juliablack.brastlewarkapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.juliablack.brastlewarkapp.databinding.FragmentListBinding
import com.juliablack.brastlewarkapp.ui.list.view.InhabitantAdapter
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
        viewModel.getInhabitants()
    }

    private fun setObservers() {
        with(viewModel) {
            liveInhabitants.observe(viewLifecycleOwner) {
                val suitAdapter = InhabitantAdapter(it)
                with(binding.list) {
                    adapter = suitAdapter
                    layoutManager = LinearLayoutManager(context)
                }
            }
        }
    }

    companion object {
        fun newInstance() = ListFragment()
    }
}