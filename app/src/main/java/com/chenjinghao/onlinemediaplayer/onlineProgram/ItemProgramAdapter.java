package com.chenjinghao.onlinemediaplayer.onlineProgram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chenjinghao.onlinemediaplayer.R;

public class ItemProgramAdapter extends BaseAdapter{
    private Context mContext;

    private String[] mDataList = new String[]{"CCTV3", "CCTV4", "CCTV5"};
    private String[] mUrlList = new String[]{
            "http://223.110.243.140/PLTV/2510088/224/3221227165/index.m3u8",
            "http://223.110.243.138/PLTV/2510088/224/3221227162/index.m3u8",
            "http://223.110.243.140/PLTV/2510088/224/3221227202/index.m3u8"
    };

    public ItemProgramAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return mDataList.length;
    }

    @Override
    public Object getItem(int pos) {
        return pos;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup viewGroup) {
        VideoViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.online_program_item, null);
            viewHolder = new VideoViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (VideoViewHolder) convertView.getTag();
        }
        viewHolder.mProgramTitle.setText(mDataList[pos]);
        viewHolder.mProgramTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LiveActivity.class);
                intent.putExtra("url", mUrlList[pos]);
                intent.putExtra("title", mDataList[pos]);
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }
}
