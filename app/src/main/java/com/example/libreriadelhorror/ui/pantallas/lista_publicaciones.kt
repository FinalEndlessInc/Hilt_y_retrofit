package com.example.libreriadelhorror.ui.pantallas

import android.util.Log
import androidx.compose.foundation.clickable
import com.example.libreriadelhorror.controladores.ControladorPublicaciones
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController

@Composable
fun ListaPublicaciones(
    modificador: Modifier = Modifier,
    controlador_publicaciones: ControladorPublicaciones = hiltViewModel(),
    navegar_a_publicacion: () -> Unit = {}
) {
    val controlador_de_navegacion = rememberNavController()
    Log.v("PantallaPublicacion", "Valor del controlador: ${controlador_publicaciones}")

    controlador_publicaciones.obtener_publicaciones()

    if(controlador_publicaciones.publicaciones.value.size > 0){
        Column(modifier = Modifier.verticalScroll(rememberScrollState())){
            for(publicacion in controlador_publicaciones.publicaciones.value){
                Column (modifier = Modifier.clickable{
                    controlador_publicaciones.seleccionar_publicacion(id = publicacion.id)
                    navegar_a_publicacion()
                }){
                    Text("Publicacion: ${publicacion.title}")
                    Text("${publicacion.body}")
                }
            }
        }
    }
    else {
        Text("Disculpa las molestias, pero estamos obteniendo las ultimas publicaciones. Espera...")
    }
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion(){
    ListaPublicaciones()
}