package com.example.motivate_me;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MotivatingMusicActivity extends YouTubeBaseActivity {

    RecyclerView recyclerView;
    Vector<YouTube> youtubeVideos = new Vector<>();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successstories);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/btPJPFnesV4\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/04854XqcfCY\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/GGXzlRoNtHU\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/mk48xRzuNvA\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/xo1VInw-SKc\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/Xz-UvQYAmbg\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/QJO3ROT-A4E\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/NG2zyeVRcbs\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/7wtfhZwyrcc\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/RE87rQkXdNw\" frameborder=\"0\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }

}
