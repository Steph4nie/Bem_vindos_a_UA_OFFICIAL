package com.example.stephanie.bem_vindos_a_ua_official;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detailsEdificios extends AppCompatActivity {

    TextView dep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_edificios);
        dep = (TextView) findViewById(R.id.nomeDep);
        dep.setText(getIntent().getStringExtra("name"));
    }
}
