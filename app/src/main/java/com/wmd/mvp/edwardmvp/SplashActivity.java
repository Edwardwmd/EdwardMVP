package com.wmd.mvp.edwardmvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.yokeyword.fragmentation.SupportActivity;

public class SplashActivity extends SupportActivity implements View.OnClickListener {
    private Button showdata, sql;

    private void findViews() {
        showdata = (Button) findViewById(R.id.showdata);
        sql = (Button) findViewById(R.id.sql);

        showdata.setOnClickListener(this);
        sql.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == showdata) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (v == sql) {
            Intent intent = new Intent(this, SqliteActivity.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViews();
    }

}
