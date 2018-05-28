package githubuser.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jakanakiwanuka.mrmlevelup.R;
/**
 * This class represents the Activity responsible for passing data from one recycler view to the
 * detail view.
 *
 * @author Jakana Kiwanuka (Github: @jeancsanchez)
 */
public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView username;
    TextView github;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_acticity);

        //INITIALIZE VIEWS
        imageView = findViewById(R.id.imageView);
        username = findViewById(R.id.userName);
        github = findViewById(R.id.organisation);

        // GET DATA
        Intent intent = getIntent();
        String image = intent.getExtras().getString("githubImage");
        String name = intent.getExtras().getString("githubUser");
        String org = intent.getExtras().getString("userOrg");

        //BIND DATA
        Glide.with(this)
                .load(image)
                .into(imageView);
        username.setText(name);
        github.setText(org);
    }
}
