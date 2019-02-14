package ak.com.example.miniproject2;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {
    @Test
    /** Test URL generation in Pokemon constructor*/
    public void testPokemonConstructorURL() {
        Pokemon p1 = new Pokemon("TestPokemon");
        assertEquals("TestPokemon", p1.getName());
        assertEquals("http://img.pokemondb.net/artwork/testpokemon.jpg", p1.getURL());
    }

    @Test
    /** Test JSON data parsed correctly in Pokemon constructor*/
    public void testPokemonConstructorJSON() throws JSONException {
        //instantiate JSON object with pokemon data
        String data = "{\"#\":\"460\",\"Attack\":\"92\",\"Defense\":\"75\",\"FlavorText\":\"\",\"HP\":\"90\",\"Sp. Atk\":\"92\",\"Sp. Def\":\"85\",\"Species\":\"Frost Tree Pok\\u00e9mon\",\"Speed\":\"60\",\"Total\":\"494\",\"Type\":[\"Grass\",\"Ice\"]}";
        JSONObject attr = new JSONObject(data);

        Pokemon p2 = new Pokemon("Abomasnow", attr);

        //test name instantiated correctly
        assertEquals("Abomasnow", p2.getName());

        //test URL instantiated correctly
        assertEquals("http://img.pokemondb.net/artwork/Abomasnov.jpg", p2.getURL());

        //test number instantiated correctly
        assertEquals(460, p2.getNumber());

        //test attack instantiated correctly
        assertEquals(92, p2.getAttack());

//        private int number;
//        private int attack;
//        private int defense;
//        private String flavorText;
//        private int hp;
//        private int sp_Atk;
//        private int sp_Def;
//        private String species;
//        private int speed;
//        private int total;
//        private List<String> types;
//
//        private String URL;
//        private String name;
    }
}