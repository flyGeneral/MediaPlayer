package com.chenjinghao.onlinemediaplayer.onlineProgram;

import android.view.View;
import android.widget.TextView;

import com.chenjinghao.onlinemediaplayer.R;

public class VideoViewHolder {

    public View mItemView;
    public TextView mProgramTitle;


    public VideoViewHolder(View view) {
        mItemView = view;
        mProgramTitle = mItemView.findViewById(R.id.tv_online_program_title);
    }
}
