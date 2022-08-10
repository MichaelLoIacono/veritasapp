package com.example.poste.de.syntaxinstitut.veritasapp.remote

import com.example.poste.de.syntaxinstitut.veritasapp.Datamodel.ImageData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


const val BASE_URL = "http://syntax-institut.com/public/apps/MichaelLoIacono/"

/**
 * /**
 * sind Variable die in der Api umgewandelt werden.
*/
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface VeritasApiService {

    @GET("data.json")
    suspend fun getImages(): List<ImageData>
}

object VeritasApi {
    val retrofitService: VeritasApiService by lazy {
        retrofit.create(VeritasApiService::class.java)
    }
}