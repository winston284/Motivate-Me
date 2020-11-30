package com.example.motivate_me;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CategoriesActivity extends AppCompatActivity {
    MediaPlayer sound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        sound = MediaPlayer.create(this, R.raw.peace);
        sound.start();
    }

    public void launchThirdActivity(View view) {
        Intent intent = new Intent(this, StudyingActivity.class);
        startActivity(intent);
    }
    public void launchHealthActivity(View view) {
        Intent intent = new Intent(this, HealthActivity.class);
        startActivity(intent);
    }
    public void launchRelationshipsActivity(View view) {
        Intent intent = new Intent(this, RelationshipsActivity.class);
        startActivity(intent);
    }
    public void launchSuccessStoriesActivity(View view) {
        Intent intent = new Intent(this, SuccessStoriesActivity.class);
        startActivity(intent);
    }

    public void launchRelaxingMusicActivity(View view) {
        Intent intent = new Intent(this, MotivatingMusicActivity.class);
        startActivity(intent);
    }


    //MediaPlayer sound = MediaPlayer.create(CategoriesActivity.this, R.raw.peace);
    public void Play(View view){
        sound.start();
    }
    public void Pause(View view){
        if (sound.isPlaying()){
            sound.pause();
        }
    }
//    PlayMusic.setOnClickListener(new View.OnClickListener()
//
//    {
//        sound = MediaPlayer.create(WelcomeActivity.this, R.raw.peace);
//        @Override
//        public void onClick (View v){
//        sound.start();
//    }
//    });

//    PauseMusic.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            if (sound.isPlaying()){
//                sound.pause();
//            }
//        }
//    });
}
