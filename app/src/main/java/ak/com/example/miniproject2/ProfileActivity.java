package ak.com.example.miniproject2;

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


        TextView Name = findViewById(R.id.nameID);
        Name.setText((String) getPokeData.getSerializable("Name"));

        TextView Attack = findViewById(R.id.attackID);
        Attack.setText((String) getPokeData.getSerializable("Attack"));

        TextView Flavor = findViewById(R.id.flavorID);
        Flavor.setText((String) getPokeData.getSerializable("Flavor"));

        TextView HP = findViewById(R.id.hpID);
        HP.setText((String) getPokeData.getSerializable("HP"));

        TextView Number = findViewById(R.id.numberID);
        Number.setText((String) getPokeData.getSerializable("Number"));

        TextView SpecialAttack = findViewById(R.id.specialAttackID);
        SpecialAttack.setText((String) getPokeData.getSerializable("Special Attack"));

        TextView SpecialDefense = findViewById(R.id.specialDefenseID);
        SpecialDefense.setText((String) getPokeData.getSerializable("Special Defense"));

        TextView Species = findViewById(R.id.speciesID);
        Species.setText((String) getPokeData.getSerializable("Species"));

        TextView Total = findViewById(R.id.totalID);
        Total.setText((String) getPokeData.getSerializable("Total"));

        TextView URL = findViewById(R.id.urlID);
        URL.setText((String) getPokeData.getSerializable("URL"));



    }
}
