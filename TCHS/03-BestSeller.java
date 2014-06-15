import java.util.*;

public class BestSeller {

    public String findBestSeller(String[] items) {
    
        Map<String, Integer> counter = new HashMap<String, Integer>();
        String most = null;
        
        for (int i = 0; i < items.length; i++) {
            counter.put(items[i], (counter.containsKey(items[i]) ? counter.get(items[i]) : 0) + 1);
            
            if (most.equals(items[i])) {
                continue;
            } 
            
            if (most == null || counter.get(most) < counter.get(items[i]) || (counter.get(most) == counter.get(items[i]) && most.compareTo(items[i]) > 0)) {
                most = items[i];
            }
        }
        
        return most;
    }
    
} 