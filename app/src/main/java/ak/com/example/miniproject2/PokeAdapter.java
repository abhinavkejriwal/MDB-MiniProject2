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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.MyViewHolder> {

    //public Context myContext;
    // public Pokemon _pokemon;


    //Individual viewHolder object will contain info that I want to be on the cardView.
    //Picture of Pokemon and Name. Will be creating new Viewholder objects.
    //Need to have a subclass.
    public ArrayList<Pokemon> pokemonArrayList;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        //public View view;
        public ImageView pokeView;
        public TextView pokeName;
        //public TextView idView;

        public MyViewHolder (View v) {
            super(v);
            this.pokeView = v.findViewById(R.id.pokeImageID);
            this.pokeName = v.findViewById(R.id.pokeNameID);
            //this.idView = v.findViewById(R.id.text2);
        }
    }

    public PokeAdapter(ArrayList<Pokemon> pokemonArrayList) {
        this.pokemonArrayList = pokemonArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listdisplay, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        final Pokemon pokemon = pokemonArrayList.get(position);
        viewHolder.pokeName.setText(pokemon.getName());
        Glide.with(viewHolder.pokeView.getContext())
                .load("http://img.pokemondb.net/artwork/" + (pokemon.name).toLowerCase().replace(" ", "").replace("'","").replace("é","e") + ".jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.pokeView);
        viewHolder.pokeName.setText(pokemon.getName());
        // Pokemon myPokemon = pokemonArrayList.get(position);
        //final Pokemon myPokemon = _listOfPokemons.get(position);
        //viewHolder = new ViewHolder(TextView a);
        //TextView myPokeName = (TextView) viewHolder.pokeName;
        // myPokeName.setText(pokemon.name);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                intent.putExtra("name" , pokemon.getName());
                intent.putExtra("id", pokemon.getId());
                intent.putExtra("attack", pokemon.getAttack());
                intent.putExtra("defense", pokemon.getDefense());
                intent.putExtra("hp", pokemon.getHP());
                intent.putExtra("types", pokemon.getTypes());
                intent.putExtra("spatk", pokemon.getSpatk());
                intent.putExtra("spdef", pokemon.getSpdef());
                intent.putExtra("speed", pokemon.getSpeed());
                intent.putExtra("total", pokemon.getTotal());
                intent.putExtra("flavortext", pokemon.getFlavorText());
                intent.putExtra("species", pokemon.getSpecies());
                v.getContext().startActivity(intent);
            }
        });
        // viewHolder.idView.setText(Integer.toString(myPokemon.getId()));

        //viewHolder.view.setTe(myPokemon.getName());
        // ADD ID VIEW... viewHolder.id
        //viewHolder.view.setText(_listOfPokemons.indexOf(position));
    }

    @Override
    public int getItemCount() {
        return pokemonArrayList.size();
    }

/*    public void onClick(View view) {
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
    }*/



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