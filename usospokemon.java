import java.util.*;

public class usospokemon {
    private Map<String, Pokemon> allPokemons;
    private Map<String, Pokemon> userCollection;

    public usospokemon(Map<String, Pokemon> allPokemons, Map<String, Pokemon> userCollection) {
        this.allPokemons = allPokemons;
        this.userCollection = userCollection;
    }

    public void addUserPokemon(String name) {
        name = name.trim().toLowerCase();
        if (!allPokemons.containsKey(name)) {
            System.out.println("Error: Pokémon no encontrado.");
            return;
        }
        if (userCollection.containsKey(name)) {
            System.out.println("Error: Pokémon ya en la colección del usuario.");
            return;
        }
        userCollection.put(name, allPokemons.get(name));
        System.out.println(name + " agregado a la colección.");
    }
    

    public void showPokemonData(String name) {
        name = name.trim().toLowerCase(); // Convertimos a minúsculas antes de buscar
        if (allPokemons.containsKey(name)) {
            System.out.println(allPokemons.get(name).datospokemon());
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
        final String trimmedAbility = ability.trim();
        allPokemons.values().stream()
            .filter(pokemon -> pokemon.getAbilities() != null && pokemon.getAbilities().stream().anyMatch(a -> a.trim().equalsIgnoreCase(trimmedAbility)))
            .forEach(pokemon -> System.out.println(pokemon.getName()));
    }
}
