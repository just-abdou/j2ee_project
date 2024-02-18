package lesServlets;

import java.util.HashMap;
import java.util.Map;

public class Memoire {
    private static Map<String, Object> memoire = new HashMap<>();

    public static Object getValue(String key) {
        return memoire.get(key);
    }

    public static void setValue(String key, Object value) {
        memoire.put(key, value);
    }
    
    @SuppressWarnings("unchecked")
    public static void setNestedValue(String[] path, Object value) {
        if(path.length == 0) return; // Avoid empty paths
        
        Map<String, Object> current = memoire;
        for(int i = 0; i < path.length - 1; i++) {
            current = (Map<String, Object>) current.computeIfAbsent(path[i], k -> new HashMap<>());
        }
        current.put(path[path.length - 1], value);
    }
    
    @SuppressWarnings("unchecked")
    public static Object getNestedValue(String[] path) {
        Map<String, Object> current = memoire;
        for(int i = 0; i < path.length - 1; i++) {
            Object next = current.get(path[i]);
            if(!(next instanceof Map)) {
                return null; 
            }
            current = (Map<String, Object>) next;
        }
        return current.get(path[path.length - 1]);
    }
}