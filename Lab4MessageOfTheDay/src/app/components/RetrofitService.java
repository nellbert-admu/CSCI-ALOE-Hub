package app.components;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("/api/messages")
    Call<ResponseBody> getMessageByCategory(@Query("category") String category);
}