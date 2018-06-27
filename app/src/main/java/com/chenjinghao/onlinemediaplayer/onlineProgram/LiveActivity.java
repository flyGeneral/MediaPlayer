package com.chenjinghao.onlinemediaplayer.onlineProgram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chenjinghao.onlinemediaplayer.R;

public class LiveActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "LiveActivity";
    private String mUrl;
    private String mTitle;

    private RelativeLayout mRlLoadingLayout;
    private ImageView mBackButton;
    private TextView mProgramTitle;
    private ImageView mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);

        mUrl = getIntent().getStringExtra("url");
        mTitle = getIntent().getStringExtra("title");

        Log.d(TAG, " url = "+ mUrl + "--- title = " + mTitle);

        initView();
    }

    private void initView() {
        mBackButton = findViewById(R.id.iv_back);
        mProgramTitle = findViewById(R.id.tv_program_title);
        mPlayButton = findViewById(R.id.iv_play);
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
