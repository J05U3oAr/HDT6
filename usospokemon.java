import java.util.*;

public class usospokemon {
    private Map<String, Pokemon> allPokemons;
    private Map<String, Pokemon> userCollection;

    public usospokemon(Map<String, Pokemon> allPokemons, Map<String, Pokemon> userCollection) {
        this.allPokemons = allPokemons;
        this.userCollection = userCollection;
    }

    public void addUserPokemon(String name) {
        if (!allPokemons.containsKey(name)) {
            System.out.println("Error: Pokémon no encontrado.");
            return;
        }
        if (userCollection.containsKey(name)) {
            System.out.println("Error: Pokémon ya en la colección del usuario.");
            return;
        }
        userCollection.put(name, allPokemons.get(name));
    }

    public void showPokemonData(String name) {
        if (allPokemons.containsKey(name)) {
            System.out.println(allPokemons.get(name));
        } else {
            System.out.println("Error: Pokémon no encontrado.");
        }
    }

    public void showUserCollectionByType1() {
        userCollection.values().stream()
            .sorted(Comparator.comparing(Pokemon::getType1))
            .forEach(pokemon -> System.out.println(pokemon.getName() + " - " + pokemon.getType1()));
    }

    public void showAllByType1() {
        allPokemons.values().stream()
            .sorted(Comparator.comparing(Pokemon::getType1))
            .forEach(pokemon -> System.out.println(pokemon.getName() + " - " + pokemon.getType1()));
    }

    public void showPokemonsByAbility(String ability) {
        allPokemons.values().stream()
            .filter(pokemon -> pokemon.getAbilities().contains(ability))
            .forEach(pokemon -> System.out.println(pokemon.getName()));
    }
}
