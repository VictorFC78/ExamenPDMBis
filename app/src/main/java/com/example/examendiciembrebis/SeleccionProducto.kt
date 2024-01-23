package com.example.examendiciembrebis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.examendiciembrebis.databinding.FragmentSeleccionProductoBinding

class SeleccionProducto : Fragment() {
  private var _binding:FragmentSeleccionProductoBinding?=null
    private val  binding get()=_binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentSeleccionProductoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args:SeleccionProductoArgs by navArgs()
        binding.tituloSeleccionProducto.text=getString(R.string.detalles_titulo,args.producto)
        binding.confirmar.setOnClickListener {
            val cantidad=binding.editIntroducirCantidad.text.toString()
            val nombrel=binding.editIntroducirNombre.text.toString()

            if(cantidad.isEmpty() ||cantidad.isBlank() ||cantidad.toInt()==0){
                Toast.makeText(context,getString(R.string.error_cantidad_vacia),Toast.LENGTH_SHORT).show()
        }
            else if(nombrel.isEmpty() || nombrel.isBlank()){
                Toast.makeText(context,getString(R.string.error_nombre_vacio),Toast.LENGTH_SHORT).show()
            }else{
                var horario=0
               if(binding.paraComer.isChecked) horario=0
                else horario=1
                val datos=SeleccionProductoDirections.actionSeleccionProductoToConfirmacionDatos(args.producto,nombrel,cantidad.toInt(),horario)
                findNavController().navigate(datos)
            }
        }
        binding.atras.setOnClickListener {
            findNavController().popBackStack()
        }


    }
}