package ak.com.example.miniproject2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    public RecyclerView PokeListRV;
    public Button searchPoke;
    public RecyclerView.Adapter myPokeAdapter;
    public RecyclerView.LayoutManager myLayoutManager;
    public JSONifier myJSONifier = new JSONifier();
    public ArrayList<Pokemon> changingPokeArrayList = new ArrayList<>(); // = myJSONifier.getMYPokemon(); //often change
    public ArrayList<Pokemon> fixedPokeArrayList = new ArrayList<>();
    private android.widget.SearchView searchView;

/*    public ImageView pokeView;
    public TextView pokeName;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myJSONifier.getMYPokemon(changingPokeArrayList, fixedPokeArrayList);

        PokeListRV = findViewById(R.id.pokeList);

        // RECYCLER VIEW.
        myLayoutManager = new LinearLayoutManager(this);

        //Also need to set layout manager to my own recyclerView.
        PokeListRV.setLayoutManager(myLayoutManager);

        myPokeAdapter = new PokeAdapter(changingPokeArrayList);
        PokeListRV.setAdapter(myPokeAdapter);

        searchPoke = findViewById(R.id.searchButton);
        searchPoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
/*
        this.pokeView = findViewById(R.id.pokeImageID2);
        this.pokeName = findViewById(R.id.pokeNameID2);*/
        //Create Adapter Class.
       //  RecyclerView.Adapter PokeListAdapter = new PokeAdapter(changingPokeArrayList);

        //Set Adapter Class.
        // PokeListRV.setAdapter(PokeListAdapter);

/*        searchPoke = findViewById(R.id.searchButton);
        searchPoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PokeAdapter.class);
                startActivity(intent);
            }
        });*/

    }


    public void filter(String input) {
        ArrayList<Pokemon> temp = new ArrayList<>();
        changingPokeArrayList.clear();
        for (Pokemon p: fixedPokeArrayList) {
            if (p.getName().contains(input) || Integer.toString(p.getId()).contains(input)) {
                changingPokeArrayList.add(p);
            }
        }
    }




    //No need to have a function for RV..

    //Want to have a function that will update recyclerView, after I enter in my search criteria.

    //New Layout Manager for the Recycler View, and then going to attach that to Recycler View...
    //Get your RecyclerView in code, by find view by ID. Set that to a new recycler view.
    // Create a new layout manager. View.setLayout manager = my layout manager. will tell the recycler view how to view.
    //Linear Layout -- linear. Grid. Columns.
    //I create an adapter. RV will have a Layout Manager and an adapter, and set both to RV. For the adapter, make a new class.
    //extends RecyclerView.adapter...
    // The adapter will take in an argument, a list of my data. I'll make a list of all my pokemon. Feed into that adapter.
    // Adapter will create individual cardViews, and inflating them to RecyclerView.
}