package com.example.libreriadelhorror.ui.pantallas

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.libreriadelhorror.controladores.ControladorPublicaciones

@Composable
fun PantallaPublicacion(
    modificador: Modifier = Modifier,
    controlador_publicaciones: ControladorPublicaciones = hiltViewModel()
){
    controlador_publicaciones.obtener_publicaciones()
    controlador_publicaciones.seleccionar_publicacion(1)

    val publicacion = controlador_publicaciones.publicacion_seleccionada.value
    val comentarios by controlador_publicaciones.comentarios

    Log.v("PantallaPublicacion", "Valor del controlador: ${controlador_publicaciones}")

    Column(modificador) {
        Text("Titulo: ${publicacion.title}")
        Text("Cuerpo: ${publicacion.body}")

        for(comentario in comentarios){
            Text("Comentario: ${comentario.body}")
        }
    }
}