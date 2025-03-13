import java.util.HashMap;
import java.util.Map;

public class MapFactory {
    // Simplificado para usar solo HashMap, eliminando las otras opciones
    public static <K, V> Map<K, V> getMap() {
        return new HashMap<>();
    }
}

