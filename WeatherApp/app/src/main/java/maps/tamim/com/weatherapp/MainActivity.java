package maps.tamim.com.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.resulttext);

        Toast.makeText(getApplicationContext(),"on",Toast.LENGTH_SHORT).show();

        RestClient.WeatherApiInterface service = RestClient.getClient();
        //We need to pass our city ID and our openweathermap APPID
        Call<WeatherAPIResult> call = service.getWeather(1185241, "3c24821de94a710abbc6fa32f906eba6");
        call.enqueue(new Callback<WeatherAPIResult>() {
            @Override
            public void onResponse(Response<WeatherAPIResult> response, Retrofit retrofit) {
                if(response.isSuccess()) {
                    //Handle the received weather data here
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                    WeatherAPIResult result = response.body();
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    textView.setText(gson.toJson(result));
                } else {
                    Toast.makeText(getApplicationContext(),"unsuccess",Toast.LENGTH_SHORT).show();

                    textView.setText("Response received but request not successful. Response: " + response.raw());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                textView.setText(t.getMessage());
            }
        });

    }
}
