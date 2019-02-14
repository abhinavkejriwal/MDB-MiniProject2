package ak.com.example.miniproject2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTests {
    @Test
    public void testPokemonConstructor() {
        Pokemon p = new Pokemon("TestPokemon");
        assertEquals("TestPokemon", p.name);
        assertEquals("http://img.pokemondb.net/artwork/testpokemon.jpg", p.URL);
    }
}