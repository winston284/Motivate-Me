// link on the tutorial that i followed to put background music https://www.youtube.com/watch?v=nwPmuIrrsoA

package com.example.motivate_me;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

public class WelcomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {

                                      @Override
                                      public void run() {
                                          next();
                                      }
                                  }
                , SPLASH_TIME_OUT);

        //doBindService();
//        Intent music = new Intent();
//        music.setClass(this, MusicService.class);
//        startService(music);
    }

    private void next() {
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivityForResult(intent, 1);
    }
//    private boolean mIsBound = false;
//    private MusicService mServ;
//    private ServiceConnection Scon =new ServiceConnection(){
//
//        public void onServiceConnected(ComponentName name, IBinder
//                binder) {
//            mServ = ((MusicService.ServiceBinder)binder).getService();
//        }
//
//        public void onServiceDisconnected(ComponentName name) {
//            mServ = null;
//        }
//    };
//
//    void doBindService(){
//        bindService(new Intent(this,MusicService.class),
//                Scon, Context.BIND_AUTO_CREATE);
//        mIsBound = true;
//    }
//
//    void doUnbindService()
//    {
//        if(mIsBound)
//        {
//            unbindService(Scon);
//            mIsBound = false;
//        }
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        if (mServ != null) {
//            mServ.resumeMusic();
//        }
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        //UNBIND music service
//        doUnbindService();
//        Intent music = new Intent();
//        music.setClass(this,MusicService.class);
//        stopService(music);
//
//    }

}


