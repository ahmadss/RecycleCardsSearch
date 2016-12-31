package com.androidlokomedia.recyclecardssearch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView sv;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sv = (SearchView) findViewById(R.id.mSearch);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);


        //SET ITS PROPETIES
        gridLayoutManager = new GridLayoutManager(this, 1);
        rv.setLayoutManager(gridLayoutManager);
//        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());

        //Adapter
        final MyAdapter adapter = new MyAdapter(getApplicationContext(), getTokoh());
        rv.setAdapter(adapter);

        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private ArrayList<Tokoh> getTokoh(){
        ArrayList<Tokoh> tokoh = new ArrayList<>();
        Tokoh t = new Tokoh();
        t.setNama("Bel Gets");
        t.setPer("Microsoft");
        t.setImg(R.drawable.person_1);
        tokoh.add(t);

        t = new Tokoh();
        t.setNama("Steve Jobs");
        t.setPer("Apple");
        t.setImg(R.drawable.person_2);
        tokoh.add(t);

        t = new Tokoh();
        t.setNama("Stony");
        t.setPer("Linuk");
        t.setImg(R.drawable.person_3);
        tokoh.add(t);

        t = new Tokoh();
        t.setNama("Resfuld Tom");
        t.setPer("Java");
        t.setImg(R.drawable.person_4);
        tokoh.add(t);

        return tokoh;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
