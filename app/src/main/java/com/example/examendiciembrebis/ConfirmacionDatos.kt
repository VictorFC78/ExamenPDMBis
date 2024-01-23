package com.example.examendiciembrebis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examendiciembrebis.databinding.FragmentConfirmacionDatosBinding

class ConfirmacionDatos : Fragment() {
  private var _binding:FragmentConfirmacionDatosBinding?=null
    private val binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentConfirmacionDatosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val datos:ConfirmacionDatosArgs by navArgs()
        binding.tituloNombre.text=getString(R.string.nombre_confirmacion,datos.nombre)
        binding.textoCantidasProducto.text=getString(R.string.pedido_confirmacion,datos.cantidad,datos.producto)
        if(datos.horario==0){
            binding.textoHorario.text=getString(R.string.horario_confirmacion,getString(R.string.para_comer_horario))
        }
        else {
            binding.textoHorario.text=getString(R.string.horario_confirmacion,getString(R.string.para_cenar_horario))
        }
        binding.btonConfirmar.setOnClickListener {
            findNavController().navigate(R.id.finalizarPedido)
        }
        binding.btonAtras.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}