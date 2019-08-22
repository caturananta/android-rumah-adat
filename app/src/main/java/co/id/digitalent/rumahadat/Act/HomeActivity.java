package co.id.digitalent.rumahadat.Act;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import co.id.digitalent.rumahadat.Adapter.ListRumahAdapter;
import co.id.digitalent.rumahadat.Model.RumahAdat;
import co.id.digitalent.rumahadat.Model.RumahAdatData;
import co.id.digitalent.rumahadat.R;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<RumahAdat> list = new ArrayList<>();
    private String title = "Rumah Adat Indonesia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        recyclerView = findViewById(R.id.rmhadat);
        recyclerView.setHasFixedSize(true);

        list.addAll(RumahAdatData.getListData());
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        profileMenu();
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void initView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListRumahAdapter rumahAdapter = new ListRumahAdapter(list);
        recyclerView.setAdapter(rumahAdapter);
    }

    private void profileMenu(){
        Intent profileIntent = new Intent(HomeActivity.this, ProfileActivity.class);
        startActivity(profileIntent);
    }
}
