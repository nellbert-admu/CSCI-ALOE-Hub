package app.components;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.ResponseBody;


@Component
public class RetrofitTesterComponent 
{
	private Retrofit retrofit;
	private MyFirstControllerRequests r;
	
	public String getTest() throws IOException
	{
		
		Call<ResponseBody> call = r.test("Jeff", 50);
		Response<ResponseBody> response = call.execute();
		
		return response.body().string();
	}
	
	public String getTest2() throws IOException
	{		
		Call<ResponseBody> call = r.test2("My CC", 50.0);
		Response<ResponseBody> response = call.execute();		
		return response.body().string();
	}
	
	public PetItemDto testJson() throws IOException
	{
		PetItemDto item = new PetItemDto();
		item.setBrand("Princess");
		item.setDescription("Bad for cat");
		item.setDiscounted(true);
		item.setPrice(100.0);
		item.setQuantity(1);
		item.setType("food");
		
		
		Call<PetItemDto> call = r.test3(item);
		Response<PetItemDto> response = call.execute();		
		return response.body();
	}
	
	public PetItemDto2 testJson2(PetItemDto item) throws IOException
	{
		Call<PetItemDto2> call = r.test4(item);
		Response<PetItemDto2> response = call.execute();		
		return response.body();
	}
	
	
	@PostConstruct
	public void init()
	{
		retrofit = new Retrofit.Builder()
				               .baseUrl("https://bogus")
				               .addConverterFactory(GsonConverterFactory.create())
				               .build();
		
		r = retrofit.create(MyFirstControllerRequests.class);
	}

}
