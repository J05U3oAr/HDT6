import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Pokemon> allPokemons = MapFactory.getMap(MapFactory.MapType.HASHMAP);
        Map<String, Pokemon> userCollection = MapFactory.getMap(MapFactory.MapType.HASHMAP);

        // Ruta al archivo CSV
String filePath = "pokemon_data_pokeapi.csv";
        leercsv.loadPokemonData(filePath, allPokemons);
        System.out.println("Pokémon cargados en el sistema:");
for (String key : allPokemons.keySet()) {
    System.out.println("- '" + key + "'");
}


        usospokemon usospokemon = new usospokemon(allPokemons, userCollection);

        while (true) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Agregar Pokémon a la colección del usuario");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar la colección de Pokémon del usuario ordenada por tipo1");
            System.out.println("4. Mostrar todos los Pokémon existentes ordenados por tipo1");
            System.out.println("5. Mostrar Pokémon por habilidad");
            System.out.println("6. Salir");
            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (option) {
                case 1:
                    System.out.println("Ingresa el nombre del Pokémon a agregar:");
                    String nameToAdd = scanner.nextLine();
                    usospokemon.addUserPokemon(nameToAdd);
                    break;
                case 2:
                    System.out.println("Ingresa el nombre del Pokémon para mostrar sus datos:");
                    String nameToShow = scanner.nextLine();
                    usospokemon.showPokemonData(nameToShow);
                    break;
                case 3:
                    System.out.println("Colección de Pokémon del usuario ordenada por tipo1:");
                    usospokemon.showUserCollectionByType1();
                    break;
                case 4:
                    System.out.println("Todos los Pokémon existentes ordenados por tipo1:");
                    usospokemon.showAllByType1();
                    break;
                case 5:
                    System.out.println("Ingresa la habilidad para mostrar los Pokémon que la poseen:");
                    String abilityToShow = scanner.nextLine();
                    usospokemon.showPokemonsByAbility(abilityToShow);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
