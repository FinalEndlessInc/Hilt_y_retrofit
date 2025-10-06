package com.example.libreriadelhorror.api

import com.example.libreriadelhorror.modelos.Publicacion
import retrofit2.http.GET

interface JSONPlaceholder {
    @GET("/posts")
    suspend fun obtener_publicaciones(): List<Publicacion>


}