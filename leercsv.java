import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class leercsv {

    public static void loadPokemonData(String filePath, Map<String, Pokemon> pokemonMap) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            int count = 0;
            
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;  // Saltar la línea de encabezado
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length < 10) {
                    System.err.println("Línea incorrecta en el CSV: " + line);
                    continue;
                }
                try {
                    // Preservamos el nombre original con mayúsculas tal como está en el CSV
                    String originalName = fields[0].trim();
                    
                    int pokedexNumber = Integer.parseInt(fields[1].trim());
                    String type1 = fields[2].trim();
                    String type2 = fields[3].trim().isEmpty() ? null : fields[3].trim();
                    String classification = fields[4].trim();
                    double height = Double.parseDouble(fields[5].trim());
                    double weight = Double.parseDouble(fields[6].trim());
                    List<String> abilities = Arrays.asList(fields[7].replaceAll("\"", "").trim().split("\\s*,\\s*"));
                    int generation = Integer.parseInt(fields[8].trim());
                    boolean isLegendary = fields[9].trim().equalsIgnoreCase("Yes");

                    Pokemon pokemon = new Pokemon(originalName, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, isLegendary);
                    
                    // Guardamos el Pokémon tanto con su nombre original como con su nombre en minúsculas
                    pokemonMap.put(originalName, pokemon);
                    
                    // También lo guardamos con versión en minúsculas para facilitar búsquedas insensibles a mayúsculas
                    String lowerCaseName = originalName.toLowerCase();
                    if (!originalName.equals(lowerCaseName)) {
                        pokemonMap.put(lowerCaseName, pokemon);
                    }
                    
                    count++;
                    
                    // Debug para ver los primeros 5 Pokémon cargados
                    if (count <= 5) {
                        System.out.println("Cargado: '" + originalName + "'");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error en el formato numérico en línea: " + line);
                    System.err.println("Mensaje de error: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error procesando línea: " + line);
                    System.err.println("Mensaje de error: " + e.getMessage());
                }
            }
            System.out.println("Total de Pokémon cargados: " + count + " (Tamaño del mapa: " + pokemonMap.size() + ")");
            
            if (pokemonMap.isEmpty()) {
                System.err.println("¡ADVERTENCIA! No se cargó ningún Pokémon. Verifica la ruta y formato del archivo: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
            System.err.println("Ruta del archivo: " + filePath);
            e.printStackTrace();
        }
    }
}