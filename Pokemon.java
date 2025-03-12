import java.util.List;
import java.util.Objects;
import java.util.Collections;

public class Pokemon {
    private String name;
    private int numeroPokedex;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private List<String> abilities;
    private int generation;
    private boolean legendario;

    public Pokemon(String name, int numeroPokedex, String type1, String type2, String classification, double height, double weight, List<String> abilities, int generation, boolean legendario) {
        this.name = name;
        this.numeroPokedex = numeroPokedex;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = Objects.requireNonNullElse(abilities, Collections.emptyList());
        this.generation = generation;
        this.legendario = legendario;
    }

    public String getName() {
        return name;
    }

    public int getPokedexNumber() {
        return numeroPokedex;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getClassification() {
        return classification;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public int getGeneration() {
        return generation;
    }

    public boolean isLegendary() {
        return legendario;
    }

    public String datospokemon() {
        return "Nombre: " + name + "\nNúmero en Pokédex: " + numeroPokedex +
                "\nTipo 1: " + type1 + (type2 != null ? "\nTipo 2: " + type2 : "") +
                "\nClasificación: " + classification + "\nAltura: " + height +
                "\nPeso: " + weight + "\nHabilidades: " + String.join(", ", abilities) +
                "\nGeneración: " + generation + "\nLegendario: " + (legendario ? "Sí" : "No");
    }
}
