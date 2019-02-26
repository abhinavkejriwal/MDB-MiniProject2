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
