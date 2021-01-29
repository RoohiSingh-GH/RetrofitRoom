package com.example.retrofitroom.ViewModal;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.retrofitroom.Model.Actor;
import com.example.retrofitroom.Repository.ActorRepository;

import java.util.List;

public class ActorViewModal extends AndroidViewModel {

    private ActorRepository repository;
    public LiveData<List<Actor>> getAllActors;

    public ActorViewModal(@NonNull Application application) {
        super(application);
        repository = new ActorRepository((application));
        getAllActors = repository.getGetAllActors();
    }
    public void insert(List<Actor>  actors){
        repository.insert(actors);
    }

    public LiveData<List<Actor>> getAllActor()
    {
        return getAllActors;
    }
}
