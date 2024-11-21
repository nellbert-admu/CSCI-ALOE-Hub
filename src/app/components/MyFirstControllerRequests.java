package app.components;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyFirstControllerRequests 
{

	// FOR DEMOJERSEY2
	@GET("http://localhost:9999/myfirstcontroller/hello")
	public Call<ResponseBody> test(@Query("n") String name, 
				       @Query("a") int age);

	@POST("http://localhost:9999/myfirstcontroller/buytoy")
	@FormUrlEncoded
	public Call<ResponseBody> test2(@Field("cc") String cc, 
				                    @Field("amt") double amt);

	
	// DEMO SEPT20

	@POST("http://localhost:9999/petitem/add")
	public Call<PetItemDto> test3(@Body PetItemDto petItem);

	
	@POST("http://localhost:9999/petitem/add")
	public Call<PetItemDto2> test4(@Body PetItemDto petItem);

}
