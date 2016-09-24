package com.kisannetwork.modal.pojo.restclient;


import com.kisannetwork.modal.pojo.MessageResponse;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;



public interface Api {

    @FormUrlEncoded
    @POST("json")
    Call<MessageResponse> sendMessage(@Field("api_key") String key, @Field("api_secret") String sec,@Field("from") String from,@Field("to") String to,@Field("text") String text);

}
