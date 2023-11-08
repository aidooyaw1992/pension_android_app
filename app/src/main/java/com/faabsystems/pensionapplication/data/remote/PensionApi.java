package com.faabsystems.pensionapplication.data.remote;


import com.faabsystems.pensionapplication.data.remote.response.UsersResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PensionApi {
    @GET("todos")
    Observable<List<UsersResponse>> getUsers();
}
