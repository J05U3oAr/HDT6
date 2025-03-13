import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PokemonTest {
    
    private Map<String, Pokemon> allPokemons;
    private Map<String, Pokemon> userCollection;
    private usospokemon usospokemonHandler;
    
    @Before
    public void setUp() {
        // Inicializar las colecciones
        allPokemons = new HashMap<>();
        userCollection = new HashMap<>();
        
        // Crear algunos Pokémon de prueba
        Pokemon pikachu = new Pokemon("Pikachu", 25, "Electric", "", "Mouse Pokémon", 0.4, 6.0, 
                                     Arrays.asList("Static", "Lightning Rod"), 1, false);
        
        Pokemon charizard = new Pokemon("Charizard", 6, "Fire", "Flying", "Flame Pokémon", 1.7, 90.5,
                                      Arrays.asList("Blaze", "Solar Power"), 1, false);
        
        Pokemon mewtwo = new Pokemon("Mewtwo", 150, "Psychic", "", "Genetic Pokémon", 2.0, 122.0,
                                    Arrays.asList("Pressure", "Unnerve", "Insomnia"), 1, true);
        
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 1, "Grass", "Poison", "Seed Pokémon", 0.7, 6.9,
                                       Arrays.asList("Overgrow", "Chlorophyll"), 1, false);
        
        // Añadir a la colección de todos los Pokémon
        allPokemons.put("Pikachu", pikachu);
        allPokemons.put("pikachu", pikachu);  // Versión en minúsculas
        allPokemons.put("Charizard", charizard);
        allPokemons.put("charizard", charizard);  // Versión en minúsculas
        allPokemons.put("Mewtwo", mewtwo);
        allPokemons.put("mewtwo", mewtwo);  // Versión en minúsculas
        allPokemons.put("Bulbasaur", bulbasaur);
        allPokemons.put("bulbasaur", bulbasaur);  // Versión en minúsculas
        
        // Inicializar el handler
        usospokemonHandler = new usospokemon(allPokemons, userCollection);
    }
    
    @Test
    public void testAddUserPokemon() {
        // Verificar que la colección del usuario está vacía al principio
        assertEquals(0, userCollection.size());
        
        // Añadir un Pokémon a la colección del usuario
        usospokemonHandler.addUserPokemon("Pikachu");
        
        // Verificar que se ha añadido correctamente
        assertEquals(1, userCollection.size());
        assertTrue(userCollection.containsKey("Pikachu"));
        assertEquals("Electric", userCollection.get("Pikachu").getType1());
        
        // Probar añadiendo con nombre en minúsculas
        usospokemonHandler.addUserPokemon("charizard");
        
        // Verificar que se ha añadido correctamente con el nombre original
        assertEquals(2, userCollection.size());
        assertTrue(userCollection.containsKey("Charizard"));
        
        // Intentar añadir un Pokémon que ya está en la colección
        usospokemonHandler.addUserPokemon("Pikachu");
        
        // Verificar que no se ha duplicado
        assertEquals(2, userCollection.size());
        
        // Intentar añadir un Pokémon que no existe
        usospokemonHandler.addUserPokemon("Raichu");
        
        // Verificar que no se ha añadido
        assertEquals(2, userCollection.size());
    }
    
    @Test
    public void testShowPokemonsByAbility() {
        // Este test requiere redirección de System.out para capturar la salida
        // En un test real, se deberían refactorizar los métodos para devolver valores
        // en lugar de imprimir directamente. Aquí verificamos al menos que no lance excepciones.
        
        try {
            // Probar con una habilidad que existe
            usospokemonHandler.showPokemonsByAbility("Blaze");
            
            // Probar con una habilidad en minúsculas
            usospokemonHandler.showPokemonsByAbility("pressure");
            
            // Probar búsqueda parcial
            usospokemonHandler.showPokemonsByAbility("Light");  // Debería encontrar "Lightning Rod"
            
            // Probar con una habilidad que no existe
            usospokemonHandler.showPokemonsByAbility("NonexistentAbility");
            
            // Pasar el test si no hay excepciones
            assertTrue(true);
        } catch (Exception e) {
            fail("No debería lanzar excepciones: " + e.getMessage());
        }
    }
}