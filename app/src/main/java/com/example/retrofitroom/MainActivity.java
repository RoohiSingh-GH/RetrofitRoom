package com.example.retrofitroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofitroom.Model.Actor;
import com.example.retrofitroom.ViewModal.ActorViewModal;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActorViewModal actorViewModal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actorViewModal = new ViewModelProvider(this).get(ActorViewModal.class);
        actorViewModal.getAllActor().observe(this, new Observer<List<Actor>>() {
            @Override
            public void onChanged(List<Actor> actorList) {
                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
