package com.example.motivate_me;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Vector;

//import com.google.android.youtube.player.YouTubeBaseActivity;
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;

//import java.util.ArrayList;
//import java.util.List;
//
//public class SuccessStoriesActivity extends YouTubeBaseActivity {
//
//    private static final String TAG = "SuccessStoriesActivity";
//
//    YouTubePlayerView mYouTubePlayerView;
//    Button btnPlay;
//    YouTubePlayer.OnInitializedListener mOnInitializedListener;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_successstories);
//        Log.d(TAG, "onCreate: Starting.");
//        btnPlay = (Button) findViewById(R.id.btnPlay);
//        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);
//
//        mOnInitializedListener = new YouTubePlayer.OnInitializedListener(){
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b){
//                Log.d(TAG, "onClick: Done initializing.");
//                List<String> videoList = new ArrayList<>();
//                //videoList.add("LngxdiwFpno");
//                //videoList.add("PLcWa6kvxTA3Npc8MQiKG46f87iyZZQS1e");
//                 //youTubePlayer.loadVideos(videoList);
//                youTubePlayer.loadPlaylist("PLH5pFvnAKP4TDA7H4moqMAMf_hKHcdGNG");
//            }
//        @Override
//        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult){
//            Log.d(TAG, "onClick: Failed to  initialize.");
//            }
//        };
//        btnPlay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                Log.d(TAG, "onClick: Initializing YouTube Player.");
//                mYouTubePlayerView.initialize(YouTube.getApiKey(), mOnInitializedListener);
//                Log.d(TAG, "onClick: Done initializing.");
//            }
//        });
//
//    }
//
//}
public class SuccessStoriesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YouTube> youtubeVideos = new Vector<>();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successstories);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/LngxdiwFpno\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/zLYECIjmnQs\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/Bg_Q7KYWG1g\" frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTube ("<iframe width=\"100%\" height=\"300px\"  src=\"https://www.youtube.com/embed/tlY0PkWxCW8\" frameborder=\"0\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }

}
