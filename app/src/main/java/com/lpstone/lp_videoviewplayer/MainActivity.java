package com.lpstone.lp_videoviewplayer;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //视频路径
        String  path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/weiqi.mp4";

        videoView = (VideoView) findViewById(R.id.videoView);
        /**
         * 本地视频播放
         */
//        videoView.setVideoPath(path);
        /**
         *网络播放
         */
        videoView.setVideoURI(Uri.parse("http://192.168.1.6:8080/video/weiqi.mp4"));
        /**
         *使用MediaController控制视频播放
         */
        MediaController mediaController = new MediaController(this);
        /**
         * 设置VideoView与MediaController建立关联
         */
        videoView.setMediaController(mediaController);
        /**
         * 设置MediaController与VideoView建立关联
         */
        mediaController.setMediaPlayer(videoView);


    }

}
