package ak.com.example.miniproject2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

class PokeAdapter extends RecyclerView.Adapter {

    public Context context;
    public ArrayList<Pokemon> _listOfPokemons;

    //Individual viewHolder object will contain info that I want to be on the cardView.
    //Picture of Pokemon and Name. Will be creating new Viewholder objects.
    //Need to have a subclass.

    public PokeAdapter(Context c, ArrayList<Pokemon> listOfPokemons) {
        this.context = c;
        this._listOfPokemons = listOfPokemons;

        //Creating a VH for each Pokemon, and putting that into RV.
        //Need some public fields for the context. We need it to keep track of whatever context we're in, so that
        // it knows where to pull objetcs and data from.
        // Need to keep track of the context.
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    //ViewHolder Class will contain fields... onClick. Each individual cardView will have its own onClick listener.
    //Attaches individual viewHolder objects to
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class myView extends RecyclerView.ViewHolder {

        public myView(@NonNull View itemView) {
            super(itemView);
        }

        public void onClick() {
            //To fill in functionality.
        }

    }


}
