package ak.com.example.miniproject2;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.ViewHolder> {

    public Context myContext;
    public ArrayList<Pokemon> _listOfPokemons;
    public Pokemon _pokemon;


    //Individual viewHolder object will contain info that I want to be on the cardView.
    //Picture of Pokemon and Name. Will be creating new Viewholder objects.
    //Need to have a subclass.

    public PokeAdapter(Context c, ArrayList<Pokemon> listOfPokemons) {
        this.myContext = c;
        this._listOfPokemons = listOfPokemons;

        //Creating a VH for each Pokemon, and putting that into RV.
        //Need some public fields for the context. We need it to keep track of whatever context we're in, so that
        // it knows where to pull objetcs and data from.
        // Need to keep track of the context.
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ImageView imageView;
        public TextView pokeName;
        public TextView idView;

        public ViewHolder (View v) {
            super(v);
            this.imageView = v.findViewById(R.id.pokeImageID);
            this.pokeName = v.findViewById(R.id.pokeNameID);
            this.idView = v.findViewById(R.id.text2);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listdisplay, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    //ViewHolder Class will contain fields... onClick.
    // Each individual cardView will have its own onClick listener.
    //Attaches individual viewHolder objects to
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Pokemon myPokemon = _listOfPokemons.get(position);
        viewHolder.pokeName.setText(myPokemon.getName());
        viewHolder.idView.setText(Integer.toString(myPokemon.getId()));

        //viewHolder.view.setTe(myPokemon.getName());
        // ADD ID VIEW... viewHolder.id
        //viewHolder.view.setText(_listOfPokemons.indexOf(position));
    }

    @Override
    public int getItemCount() {
        return _listOfPokemons.size();
    }

    public void onClick(View view) {
        Intent i = new Intent(view.getContext(), ProfileActivity.class);
        i.putExtra("Attack", _pokemon.getAttack());
        i.putExtra("Defense", _pokemon.getDefense());
        i.putExtra("Flavor", _pokemon.getFlavorText());
        i.putExtra("HP", _pokemon.getHP());
        i.putExtra("Name", _pokemon.getName());
        i.putExtra("Species", _pokemon.getSpecies());
        i.putExtra("Total", _pokemon.getTotal());
        myContext.startActivity(new Intent(myContext, ProfileActivity.class));
        view.getContext().startActivity(i);
    }

}



// ROUGH WORK
/** public class MyViewHolder extends RecyclerView.ViewHolder {
 private final ItemBinding binding;

 public MyViewHolder(ItemBinding binding) {
 super(binding.getRoot());
 this.binding = binding;
 }

 public void bind(Item item) {
 binding.setItem(item);
 binding.executePendingBindings();
 }
 }

 public MyViewHolder onCreateViewHolder(ViewGroup parent,
 int viewType) {
 LayoutInflater layoutInflater =
 LayoutInflater.from(parent.getContext());
 ItemBinding itemBinding =
 ItemBinding.inflate(layoutInflater, parent, false);
 return new MyViewHolder(itemBinding);
 }

 public void onBindViewHolder(MyViewHolder holder, int position) {
 Item item = getItemForPosition(position);
 holder.bind(item);
 }

 public class MyViewHolder extends RecyclerView.ViewHolder {
 private final ViewDataBinding binding;

 public MyViewHolder(ViewDataBinding binding) {
 super(binding.getRoot());
 this.binding = binding;
 }

 public void bind(Object obj) {
 binding.setVariable(BR.obj, obj);
 binding.executePendingBindings();
 }
 }

 *
 *
 *
 *
 *
 * */