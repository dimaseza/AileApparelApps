package com.daivers.aileapparel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    private Button btnSendFeedback;
    private EditText etFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        btnSendFeedback = (Button) findViewById(R.id.btn_send_feedback);
        etFeedback = (EditText) findViewById(R.id.et_feedback);

        btnSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendFeedbackIntent = new Intent(Intent.ACTION_SEND);
                sendFeedbackIntent.setType("message/html");
                sendFeedbackIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"daiverstech@gmail.com"});
                sendFeedbackIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from AILE App");
                sendFeedbackIntent.putExtra(Intent.EXTRA_TEXT, "Message : " + etFeedback.getText());
                try {
                    startActivity(Intent.createChooser(sendFeedbackIntent, "Mengirim Feedback. . ."));
                } catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getApplicationContext(), "Pengguna tidak mempunyai aplikasi email.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
