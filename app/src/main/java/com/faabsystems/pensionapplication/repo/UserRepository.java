package com.faabsystems.pensionapplication.repo;

import com.faabsystems.pensionapplication.data.remote.PensionApi;
import com.faabsystems.pensionapplication.data.remote.response.UsersResponse;
import java.util.List;
import javax.inject.Inject;
import io.reactivex.Observable;

public class UserRepository {
    private PensionApi pensionApi;

    @Inject
    public UserRepository(PensionApi pensionApi) {
        this.pensionApi = pensionApi;
    }

    public Observable<List<UsersResponse>> getUsers() {
        return pensionApi.getUsers();
    }

}
