package api

import com.c490.android.mockify.ImgflipResponse
import com.c490.android.mockify.BuildConfig
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface ImgflipApi {
    @GET("/")
    fun fetchContents(): retrofit2.Call<String>

    @GET("memegenerator/102156234" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s")
    fun fetchPhoto(@Url url: String): Call<ImgflipResponse>

    //@POST
}