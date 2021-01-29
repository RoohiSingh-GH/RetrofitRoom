package com.example.retrofitroom.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.retrofitroom.Dao.ActorDao;
import com.example.retrofitroom.Database.ActorDatabase;
import com.example.retrofitroom.Model.Actor;

import java.util.List;

public class ActorRepository {

    private ActorDatabase database;
    private LiveData<List<Actor>> getAllActors;

    public ActorRepository(Application application){
        database = ActorDatabase.getInstance(application);
        getAllActors = database.actorDao().getAllPosts();
    }

    public void insert(List<Actor> actorList){

        new InsertAsyncTask(database).execute(actorList);
    }

    public LiveData<List<Actor>> getGetAllActors(){
        return getAllActors;
    }

    private class InsertAsyncTask extends AsyncTask<List<Actor>,Void,Void> {

        private ActorDao actorDao;

        public InsertAsyncTask(ActorDatabase actorDatabase)
        {
           actorDao = actorDatabase.actorDao();
        }
        @Override
        protected Void doInBackground(List<Actor>... lists) {
            actorDao.insert(lists[0]);
            return null;
        }
    }
}
