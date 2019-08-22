package co.id.digitalent.rumahadat.Act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.id.digitalent.rumahadat.R;

public class ProfileActivity extends AppCompatActivity {

    private String title = "Profil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
