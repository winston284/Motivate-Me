package com.example.motivate_me;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RelationshipsActivity extends AppCompatActivity {
    private OkHttpClient httpClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studying);

        fetchData();

        doThis(0);

    }
    void doThis(int page){
        final int aaaah = page;
        Request request = new Request.Builder()
                //red panda album https://api.imgur.com/3/album/mDkzM/images/0.json
                //rising gallery https://api.imgur.com/3/gallery/user/rising/0.json

                .url("https://api.imgur.com/3/album/C05HBhk/images/0.json")
                .header("Authorization","Client-ID 964ce1f791b2d7f")
                .header("User-Agent","My Little App")
                .build();

        System.out.println("Calling API");

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("Calling API resulted in failure");
                String TAG ="";
                Log.e(TAG, "An error has occurred " + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("Calling API was successful");
                // More code goes here
                JSONObject data = null;
                try {
                    data = new JSONObject(response.body().string());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray items = null;
                try {
                    items = data.getJSONArray("data");
                    String TAG ="Data: ";
                    Log.e(TAG, data.toString(2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                final List<Photo> photos = new ArrayList<Photo>();

                for(int i=0; i<items.length();i++) {
                    JSONObject item = null;
                    try {
                        item = items.getJSONObject(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Photo photo = new Photo();
                    try {
//                        if(item.getBoolean("is_album")) {
//                            photo.id = item.getString("cover");
//                        } else {
//                            photo.id = item.getString("id");
//                        }
                        photo.id = item.getString("id");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        photo.title = item.getString("title");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    photos.add(photo); // Add photo to list
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Collections.shuffle(photos);
                        render(photos);
                        String TAG ="photos size: ";
                        Log.e(TAG, String.valueOf(photos.size()));
                    }
                });
            }
        });
    }

    private void render(final List<Photo> photos){
        ImagePagerAdapter adapter = new ImagePagerAdapter(photos);
        ViewPager viewPager = (ViewPager) findViewById(R.id.image_placeholder);
        viewPager.setAdapter(adapter);
    }
    private static class Photo {

        String id;
        String title;

    }
    private void fetchData() {
        httpClient = new OkHttpClient.Builder().build();
    }
    //Inspired by https://github.com/chiuki/android-swipe-image-viewer
    private class ImagePagerAdapter extends PagerAdapter{
        List<Photo> photos;
        ImagePagerAdapter(List<Photo> photos){
            this.photos = photos;
        }
        @Override
        public int getCount() {
            return photos.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view ==(object);
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position){
            Context context = RelationshipsActivity.this;
            ImageView imageView = new ImageView(context);
            int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
            imageView.setPadding(padding,padding,padding,padding);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            Picasso.get().load("https://i.imgur.com/" +
                    photos.get(position).id + ".jpg").into(imageView);
            ((ViewPager)container).addView(imageView,0);
            return imageView;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object){
            ((ViewPager)container).removeView((ImageView) object);
        }

    }
}
