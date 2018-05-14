package adapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jakanakiwanuka.mrmlevelup.MainActivity;
import com.example.jakanakiwanuka.mrmlevelup.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acticity);

        // Get the intent that started this activity
        Intent intent = getIntent();
        String message = intent.getStringExtra("githubUser");
        String message2 = intent.getStringExtra("UserOrg");
        TextView textView = findViewById(R.id.userName);
        TextView textView1 = findViewById(R.id.Organisation);
        textView.setText(message);
        textView1.setText(message2);
    }
}
