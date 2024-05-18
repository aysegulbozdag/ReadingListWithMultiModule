package com.example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.ui.databinding.FragmentBookBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BookFragment : Fragment() {

    private lateinit var binding: FragmentBookBinding
    private val viewModel : BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBookBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickListener()

        lifecycleScope.launch {
            viewModel.bookState.collect{
                binding.recyclerView.adapter= BookAdapter(it)
            }
        }

    }

    private fun clickListener(){
        binding.btnAdd.setOnClickListener {
            if (binding.txtBookName.text.isNotEmpty()){
                viewModel.addBook(binding.txtBookName.text.toString())
                binding.txtBookName.text.clear()
            }
        }
    }
}