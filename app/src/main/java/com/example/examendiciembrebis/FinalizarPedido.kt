package com.example.examendiciembrebis

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examendiciembrebis.databinding.FragmentFinalizarPedidoBinding

private var _binding:FragmentFinalizarPedidoBinding?=null
private val binding get() = _binding!!
class FinalizarPedido : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentFinalizarPedidoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imagenCancel.setOnClickListener {
            activity?.finish()
        }
        binding.layoutH2.setOnClickListener {
            activity?.finish()
        }
        binding.layoutH1.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "textMessage")
                type = "text/plain"
            }
            if (context?.let { it1 -> sendIntent.resolveActivity(it1.packageManager) } != null) {
                startActivity(sendIntent)
            }
        }
        binding.tituloCompartir.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "textMessage")
                type = "text/plain"
            }
            if (context?.let { it1 -> sendIntent.resolveActivity(it1.packageManager) } != null) {
                startActivity(sendIntent)
            }
        }
    }
}