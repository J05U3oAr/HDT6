import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory {
    public enum MapType {
        HASHMAP, TREEMAP, LINKEDHASHMAP //implementaciones del Map
    }

    //Implementación de MapFactory para el guardado de datos de los pokemones
    public static <K, V> Map<K, V> getMap(MapType type) {
        if (type == MapType.HASHMAP) {
            return new HashMap<>();
        } else if (type == MapType.TREEMAP) {
            return new TreeMap<>();
        } else if (type == MapType.LINKEDHASHMAP) {
            return new LinkedHashMap<>();
        } else {
            throw new IllegalArgumentException("Invalid Map Type");
        }
    }
}

