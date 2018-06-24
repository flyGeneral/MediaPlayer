package com.chenjinghao.onlinemediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import onlineProgram.ItemProgramAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView mProgramListViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgramListViews = findViewById(R.id.lv_online_program_list);
        mProgramListViews.setAdapter(new ItemProgramAdapter(this));
    }
}
