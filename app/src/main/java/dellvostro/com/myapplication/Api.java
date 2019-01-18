package dellvostro.com.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 0 on 1/14/2019.
 */

public interface Api {

//    root url after add multiple servlets

    String  BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Modelclass>> getmodelclass();



}
