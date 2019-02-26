package ak.com.example.miniproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    ImageView img;
    TextView idTV;
    TextView nameTV;
    TextView myTV1;
    TextView myTV2;
    Button leave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        leave = findViewById(R.id.returnButton);
        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        img = findViewById(R.id.pokemonimage);

        Glide.with(img.getContext()).load("http://img.pokemondb.net/artwork/" + name.toLowerCase() + ".jpg").centerCrop().into(img);

        idTV = findViewById(R.id.id);
        nameTV = findViewById(R.id.name);
        myTV1 = findViewById(R.id.tv1);
        myTV2 = findViewById(R.id.tv2);

        int spdef = b.getInt("spdef", 0);
        int speed = b.getInt("speed", 0);
        int attack = b.getInt("attack", 0);
        int defense = b.getInt("defense", 0);
        int hp = b.getInt("hp", 0);
        String[] types = getIntent().getExtras().getStringArray("types");
        int id = b.getInt("id", 0);

        int spatk = b.getInt("spatk", 0);

        int total = b.getInt("total", 0);
        String flavortext = b.getString("flavortext");
        String species = b.getString("species");

        nameTV.setText(name);
        idTV.setText(Integer.toString(id));
        String concat = "Attack: " + Integer.toString(attack) + ", Defense: "
                + Integer.toString(defense) + ", HP: " + Integer.toString(hp)
                + ", Special Attack: " + Integer.toString(spatk) + ", Special Defense: "
                + Integer.toString(spdef) + ", Speed: " + Integer.toString(speed) + ", Total: "
                + Integer.toString(total) + ", Species: " + species;

        myTV1.setText(concat);
        myTV2.setText(flavortext);

    }
}

/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //String name = getIntent().getStringExtra()
        Bundle getPokeData = getIntent().getExtras();
        getPokeData.getSerializable("Name");
        getPokeData.getSerializable("Attack");
        getPokeData.getSerializable("Flavor");
        getPokeData.getSerializable("HP");
        getPokeData.getSerializable("Number");
        getPokeData.getSerializable("Special Attack");
        getPokeData.getSerializable("Special Defense");
        getPokeData.getSerializable("Species");
        getPokeData.getSerializable("Total");
        getPokeData.getSerializable("URL");


        TextView Name = findViewById(R.id.nameID2);
        Name.setText((String) getPokeData.getSerializable("Name"));

        TextView Attack = findViewById(R.id.attackID2);
        Attack.setText((String) getPokeData.getSerializable("Attack"));

        TextView Flavor = findViewById(R.id.flavorID2);
        Flavor.setText((String) getPokeData.getSerializable("Flavor"));

        TextView HP = findViewById(R.id.hpID2);
        HP.setText((String) getPokeData.getSerializable("HP"));

        TextView Number = findViewById(R.id.numberID2);
        Number.setText((String) getPokeData.getSerializable("Number"));

        TextView SpecialAttack = findViewById(R.id.specialAttackID2);
        SpecialAttack.setText((String) getPokeData.getSerializable("Special Attack"));

        TextView SpecialDefense = findViewById(R.id.specialDefenseID2);
        SpecialDefense.setText((String) getPokeData.getSerializable("Special Defense"));

        TextView Species = findViewById(R.id.speciesID2);
        Species.setText((String) getPokeData.getSerializable("Species"));

        TextView Total = findViewById(R.id.totalID2);
        Total.setText((String) getPokeData.getSerializable("Total"));

        TextView URL = findViewById(R.id.urlID2);
        URL.setText((String) getPokeData.getSerializable("URL"));



    }
}
*/
