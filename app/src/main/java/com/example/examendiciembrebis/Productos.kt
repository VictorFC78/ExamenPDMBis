package com.example.examendiciembrebis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examendiciembrebis.databinding.FragmentProductosBinding


class Productos : Fragment() {
    private var _binding:FragmentProductosBinding?=null
    private val binding get()=_binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentProductosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.productoHamburgesa.setOnClickListener {
            val productoH=ProductosDirections.actionProductosToSeleccionProducto(getString(R.string.hamburguesa))
            findNavController().navigate(productoH)
        }
        binding.productopizza.setOnClickListener {
            val productoP=ProductosDirections.actionProductosToSeleccionProducto(getString(R.string.pizza))
            findNavController().navigate(productoP)
        }
        binding.productoEnsalada.setOnClickListener {
            val productoE=ProductosDirections.actionProductosToSeleccionProducto(getString(R.string.ensalada))
            findNavController().navigate(productoE)
        }
        binding.productoTaco.setOnClickListener {
            val productoT=ProductosDirections.actionProductosToSeleccionProducto(getString(R.string.taco))
            findNavController().navigate(productoT)
        }

    }
}