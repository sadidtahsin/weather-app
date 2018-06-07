package maps.tamim.com.weatherapp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import maps.tamim.com.weatherapp.WeatherAPIResult;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

//API REST client
public class RestClient {

    private static String baseUrl = "http://api.openweathermap.org";
    private static WeatherApiInterface weatherApiInterface;


    //Set up the REST client
    public static WeatherApiInterface getClient() {
        if (weatherApiInterface == null) {

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            weatherApiInterface = client.create(WeatherApiInterface.class);
        }
        return weatherApiInterface ;
    }

    //API REST methods
    public interface WeatherApiInterface {

        @GET("/data/2.5/forecast")
        Call<WeatherAPIResult> getWeather(@Query("id") int cityID, @Query("APPID") String appID);
    }
}
