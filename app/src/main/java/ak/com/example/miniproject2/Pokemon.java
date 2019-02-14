package ak.com.example.miniproject2;

import java.util.List;

public class Pokemon {

    int hashtag;
    int Attack;
    int Defense;
    String FlavorText;
    int HP;
    int Sp_Atk;
    int Sp_Def;
    String Species;
    int Speed;
    int Total;
    List<String> Type;

    String URL;
    String name;

    public Pokemon(String name) {
        this.name = name;
        this.URL = String.format("http://img.pokemondb.net/artwork/%s.jpg", name.toLowerCase());
    }
}
