package ak.com.example.miniproject2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Function that creates a list of Pokemon.
        //Fill adapter Class.
        //Make Layout for CardView. Each individual CardView layout will be created with ViewHolders.
        //My adapter class will handle creating all viewholder for all the data it is assigned.
        // VH OBJECT FOR EACH ITEM IN THAT LIST, and INFLATE THAT INTO THE RV.

        //RECYCLER VIEW.
        RecyclerView PokeList = findViewById(R.id.pokeList);
        RecyclerView.LayoutManager pokeListLinear = new LinearLayoutManager(this);

        //Also need to set layout manager to my own recyclerView.
        PokeList.setLayoutManager(pokeListLinear);

        //Create Adapter Class.
        RecyclerView.Adapter PokeListAdapter = new PokeAdapter();

        //Set Adapter Class.
        PokeList.setAdapter(PokeListAdapter);

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
