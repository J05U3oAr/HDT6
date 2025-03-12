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
                String name = fields[0].trim();
                int pokedexNumber = Integer.parseInt(fields[1].trim());
                String type1 = fields[2].trim();
                String type2 = fields[3].trim().isEmpty() ? null : fields[3].trim();
                String classification = fields[4].trim();
                double height = Double.parseDouble(fields[5].trim());
                double weight = Double.parseDouble(fields[6].trim());
                List<String> abilities = Arrays.asList(fields[7].replaceAll("\"", "").trim().split("\\s*,\\s*"));
                int generation = Integer.parseInt(fields[8].trim());
                boolean isLegendary = fields[9].trim().equalsIgnoreCase("Yes");

                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, isLegendary);
                pokemonMap.put(name, pokemon);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en el formato numérico: " + e.getMessage());
        }
    }
}


