package com.daivers.aileapparel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class SocialMediaActivity extends AppCompatActivity{

    private TextView aile_btn, daivers_btn, giveFeedback;

    private Context liContext = null;

    String urlAile = "https://www.instagram.com/aileapparel.id/";
    String urlDaivers = "https://www.instagram.com/daiversindonesia/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        aile_btn = (TextView) findViewById(R.id.tv_aile);
        daivers_btn = (TextView) findViewById(R.id.tv_daivers);
        giveFeedback = (TextView) findViewById(R.id.give_feedback);

        aile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(urlAile));
                    intent.setPackage("com.instagram.android");
                    startActivity(intent);
                }catch(ActivityNotFoundException anfe){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlAile)));
                }
            }
        });

        daivers_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(urlDaivers));
                    intent.setPackage("com.instagram.android");
                    startActivity(intent);
                }catch(ActivityNotFoundException anfe){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlDaivers)));
                }
            }
        });

        giveFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent feedbackIntent = new Intent(SocialMediaActivity.this, FeedbackActivity.class);
                startActivity(feedbackIntent);
                finish();
            }
        });

    }
}
