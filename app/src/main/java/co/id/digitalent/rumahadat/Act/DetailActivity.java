package co.id.digitalent.rumahadat.Act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import co.id.digitalent.rumahadat.Util.Base;
import co.id.digitalent.rumahadat.R;

public class DetailActivity extends AppCompatActivity {

    private String title = "Detail";
    TextView tv1, tv2, tv3;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        tv1 = (TextView) findViewById(R.id.tvNama);
        tv2 = (TextView) findViewById(R.id.tvDaerah);
        tv3 = (TextView) findViewById(R.id.tvDeskripsi);
        img1 = (ImageView) findViewById(R.id.imgGambar);

        initView();
    }

    private void initView(){

        tv1.setText(getIntent().getStringExtra(Base.EXTRA_NAME));
        tv2.setText(getIntent().getStringExtra(Base.EXTRA_FROM));
        tv3.setText(getIntent().getStringExtra(Base.EXTRA_DESCRIPTION));

        Glide.with(this)
                .load(getIntent().getStringExtra(Base.EXTRA_IMAGE))
                .into(img1);

    }
}
