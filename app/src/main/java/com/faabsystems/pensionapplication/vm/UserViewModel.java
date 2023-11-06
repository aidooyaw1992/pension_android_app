package com.faabsystems.pensionapplication.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.faabsystems.pensionapplication.data.remote.response.UsersResponse;
import com.faabsystems.pensionapplication.repo.UserRepository;
import com.faabsystems.pensionapplication.util.DataState;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class UserViewModel extends ViewModel {

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    private UserRepository userRepository;
    private MutableLiveData<DataState<List<UsersResponse>>> dataStateLiveData = new MutableLiveData<>();



    @Inject
    public UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public LiveData<DataState<List<UsersResponse>>> getUser() {
        dataStateLiveData.setValue(new DataState<>(DataState.Status.LOADING, null, null));

        Disposable disposable = userRepository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(onSubscribe ->dataStateLiveData.setValue(new DataState<>(DataState.Status.LOADING, null, null)))
                .subscribe( registrationModelResponse -> {
                            dataStateLiveData.setValue(new DataState<>(DataState.Status.SUCCESS, registrationModelResponse, null));
                        },
                        error -> {
                            dataStateLiveData.setValue(new DataState<>(DataState.Status.ERROR, null, "Request was not successful"));
                        }
                );
        compositeDisposable.add(disposable);
        return  dataStateLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }


}






