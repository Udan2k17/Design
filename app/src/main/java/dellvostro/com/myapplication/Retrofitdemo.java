package dellvostro.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofitdemo extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        listView= (ListView)findViewById(R.id.listview);

//        Retrofitdemo.Builder builder =
//                new Retrofitdemo.Builder()
//                        .baseUrl(Api.BASE_URL)
//                        //THIS IS THE LINE WITH ERROR!!!!!!!!!!!!
//                        .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofitdemo = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofitdemo.create(Api.class);

        Call<List<Modelclass>> call= api.getmodelclass();
        call.enqueue(new Callback<List<Modelclass>>() {
            @Override
            public void onResponse(Call<List<Modelclass>> call, Response<List<Modelclass>> response) {
                List<Modelclass> modelclasses = response.body();
                for (Modelclass m :modelclasses){
                    Log.d("try",m.getName());
                    Log.d("try",m.getRealname());
                    Log.d("try",m.getBio());
                    Log.d("try",m.getImageurl());
                    Log.d("try",m.getCreatedby());
                    Log.d("try",m.getFirstappearance());
                }
            }

            @Override
            public void onFailure(Call<List<Modelclass>> call, Throwable t) {
                Toast.makeText(getApplicationContext()," On failure method calls",Toast.LENGTH_LONG).show();
            }
        });

    }
}
