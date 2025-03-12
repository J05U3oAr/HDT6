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
                    isFirstLine = false;  // Skip the header line
                    continue;
                }
                String[] fields = line.split(",");
                String name = fields[0];
                int pokedexNumber = Integer.parseInt(fields[1]);
                String type1 = fields[2];
                String type2 = fields[3].isEmpty() ? null : fields[3];
                String classification = fields[4];
                double height = Double.parseDouble(fields[5]);
                double weight = Double.parseDouble(fields[6]);
                List<String> abilities = Arrays.asList(fields[7].split(","));
                int generation = Integer.parseInt(fields[8]);
                boolean isLegendary = fields[9].equalsIgnoreCase("Yes");

                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, isLegendary);
                pokemonMap.put(name, pokemon);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
    }
}

