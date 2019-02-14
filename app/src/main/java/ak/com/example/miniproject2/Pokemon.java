package ak.com.example.miniproject2;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private int number;
    private int attack;
    private int defense;
    private String flavorText;
    private int hp;
    private int sp_Atk;
    private int sp_Def;
    private String species;
    private int speed;
    private int total;
    private List<String> types;

    private String URL;
    private String name;

    public Pokemon(String n) {
        name = n;
        URL = String.format("http://img.pokemondb.net/artwork/%s.jpg", n.toLowerCase());
    }

    public Pokemon(String n, JSONObject pokeAttributes) {
        //bind name and generate image url
        name = n;
        URL = String.format("http://img.pokemondb.net/artwork/%s.jpg", n.toLowerCase());

        try {
            //bind various attributes
            number = Integer.parseInt(pokeAttributes.getString("#"));
            attack = Integer.parseInt(pokeAttributes.getString("Attack"));
            defense = Integer.parseInt(pokeAttributes.getString("Defense"));
            flavorText = pokeAttributes.getString("FlavorText");
            hp = Integer.parseInt(pokeAttributes.getString("HP"));
            sp_Atk = Integer.parseInt(pokeAttributes.getString("Sp. Atk"));
            sp_Def = Integer.parseInt(pokeAttributes.getString("Sp. Def"));
            species = pokeAttributes.getString("Species");
            speed = Integer.parseInt(pokeAttributes.getString("Speed"));
            total = Integer.parseInt(pokeAttributes.getString("Total"));

            //Parse types from JSON data
            types = new ArrayList<>();
            JSONArray arr = new JSONArray(pokeAttributes.getString("Type"));
            for (int i = 0; i < arr.length(); i++) {
                types.add(arr.getString(i));
            }
        } catch (JSONException e) {
            Log.i("Error","JSON data cannot be parsed.");
        }
    }

    public int getNumber() {
        return number;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public int getHP() {
        return hp;
    }

    public int getSpAtk() {
        return sp_Atk;
    }

    public int getSpDef() {
        return sp_Def;
    }

    public String getSpecies() {
        return species;
    }

    public int getTotal() {
        return total;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getURL() {
        return URL;
    }

    public String getName() {
        return name;
    }

    /*public static void main(String[] args) throws JSONException {
        String data = "{\"#\":\"460\",\"Attack\":\"92\",\"Defense\":\"75\",\"FlavorText\":\"\",\"HP\":\"90\",\"Sp. Atk\":\"92\",\"Sp. Def\":\"85\",\"Species\":\"Frost Tree Pok\\u00e9mon\",\"Speed\":\"60\",\"Total\":\"494\",\"Type\":[\"Grass\",\"Ice\"]}";
        data = data.replaceAll("\n", "\\n");
        JSONObject attr = new JSONObject(data);

        Pokemon p = new Pokemon("Abomasnow", attr);

        System.out.println(p.getName());
        System.out.println(p.getURL());
        System.out.println(p.getDefense());
        System.out.println(p.getAttack());
        System.out.println(p.getTypes());
    }*/
}
