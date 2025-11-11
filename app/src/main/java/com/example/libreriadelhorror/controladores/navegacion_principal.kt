package com.example.libreriadelhorror.controladores

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.libreriadelhorror.ui.pantallas.ListaPublicaciones
import com.example.libreriadelhorror.ui.pantallas.PantallaListaPublicaciones
import com.example.libreriadelhorror.ui.pantallas.PantallaPublicacion

@Composable
fun NavegacionPrincipal(modificador: Modifier = Modifier){
    val control_navegacion = rememberNavController()

    NavHost(navController = control_navegacion, startDestination = PantallaListaPublicaciones){
        composable<PantallaListaPublicaciones>{
            ListaPublicaciones(modificador, navegar_a_publicacion ={
                control_navegacion.navigate(PantallaPublicacion)
            })
        }

        composable<PantallaPublicacion>{
            PantallaPublicacion(modificador)
        }
    }
}

