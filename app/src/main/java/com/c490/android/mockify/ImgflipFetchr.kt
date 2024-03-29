package com.c490.android.mockify

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.Gallery
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import api.ImgflipApi
import okhttp3.Request
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.URL

private const val TAG = "ImgflipFetchr"
private const val baseURL = "https://api.imgflip.com/get_memes"


class ImgflipFetchr {
    private val imgflipApi: ImgflipApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        imgflipApi = retrofit.create(ImgflipApi::class.java)
    }

    @WorkerThread
    fun fetchPhoto(url: String): Bitmap? {
        val resp: Response<ResponseBody> = imgflipApi.fetchUrlBytes(url).execute()
        val bitmap = resp.body()?.byteStream()?.use(BitmapFactory::decodeStream)
        return bitmap
    }

    fun fetchSpongebob(url: String): LiveData<List<Spongebob>> {
        val ret = MutableLiveData<List<Spongebob>>()
        /*val jsonBody = JSONObject()
        jsonBody.put("template_id", "102156234")
        jsonBody.put("username", "walmartin")
        jsonBody.put("password", "")
        jsonBody.put("text0", "Hello")
        jsonBody.put("text1", "World")
        val requestBody = jsonBody.toString()
        val stringRequest = object:StringRequest(Request.Method.POST, baseURL, object:Response.Listener<String>() {*/

            imgflipApi.fetchPhoto(baseURL).enqueue(object: Callback<ImgflipResponse> {
            override fun onFailure(call: Call<ImgflipResponse>, t: Throwable) {
                Log.e(TAG, "Could not fetch meme: ${t}")
            }

            override fun onResponse(call: Call<ImgflipResponse>, response: Response<ImgflipResponse>) {
                ret.value = response.body()?.spongebob
            }

        })

        return ret

    }

    /*fun fetchContents(): LiveData<String> {
        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val flickrRequest = imgflipApi.fetchContents()

        flickrRequest.enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e(TAG, "Request failed: ${t}")
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d(TAG, "Response received")
                responseLiveData.value = response.body()
            }

        })

        return responseLiveData
    }*/
    /*fun fetchPhotos(): LiveData<List<GalleryItem>> {
        val responseLiveData: MutableLiveData<List<GalleryItem>> = MutableLiveData()
        flickrApi.fetchPhotos().enqueue(object: Callback<FlickrResponse> {
            override fun onResponse(
                call: Call<FlickrResponse>,
                response: Response<FlickrResponse>
            ) {
                val flickrResponse = response.body()
                val photoResponse = flickrResponse?.photos
                Log.d(TAG, "Number of photos: ${photoResponse?.total}")
                var galleryItems = photoResponse?.galleryItems
                    ?: mutableListOf()
                galleryItems = galleryItems.filterNot {
                    it.url.isBlank()
                }
                responseLiveData.value = galleryItems
            }

            override fun onFailure(call: Call<FlickrResponse>, t: Throwable) {
                Log.d(TAG, "$t")
            }

        })
        return responseLiveData
    }*/


}