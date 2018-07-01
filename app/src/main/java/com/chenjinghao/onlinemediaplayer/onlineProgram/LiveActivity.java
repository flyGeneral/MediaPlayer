package com.chenjinghao.onlinemediaplayer.onlineProgram;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chenjinghao.onlinemediaplayer.R;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

public class LiveActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "LiveActivity";
    private String mUrl;
    private String mTitle;

    private int RETRY_TIMES = 5;
    private int mCounts = 0;

    private RelativeLayout mRlLoadingLayout;
    private ImageView mBackButton;
    private TextView mProgramTitle;
    private ImageView mPlayButton;
    private VideoView mVideoView;
    private RelativeLayout mLoadingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        mUrl = getIntent().getStringExtra("url");
        mTitle = getIntent().getStringExtra("title");

        Log.d(TAG, " url = "+ mUrl + "--- title = " + mTitle);

        initView();
        initPlayer();
    }

    private void initPlayer() {
        Vitamio.isInitialized(getApplicationContext());
        mVideoView = findViewById(R.id.vv_surface_view);
        mVideoView.setVideoURI(Uri.parse(mUrl));
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
            }
        });
        mVideoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                if (mCounts > RETRY_TIMES){
                    new AlertDialog.Builder(LiveActivity.this)
                            .setMessage(R.string.app_name)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    LiveActivity.this.finish();
                                }
                            }).setCancelable(false).show();
                } else {
                    mVideoView.stopPlayback();
                    mVideoView.setVideoURI(Uri.parse(mUrl));
                }
                mCounts ++;
                return false;
            }
        });
        mVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                switch (what) {
                    case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                        mLoadingLayout.setVisibility(View.VISIBLE);
                        break;
                    case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                    case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:
                    case MediaPlayer.MEDIA_INFO_VIDEO_TRACK_LAGGING:
                        mLoadingLayout.setVisibility(View.GONE);
                        break;
                }
                return false;
            }
        });
    }

    private void initView() {
        mBackButton = findViewById(R.id.iv_back);
        mProgramTitle = findViewById(R.id.tv_program_title);
        mPlayButton = findViewById(R.id.iv_play);
        mLoadingLayout = findViewById(R.id.rl_loading_layout);
        mBackButton.setOnClickListener(this);
        mPlayButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_play:

                break;
        }
    }
}
