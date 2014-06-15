import java.util.*;

public class SymbolFrequency {

    public double language(String[] frequencies, String[] text) {
    
        double lowestDeviation = -1;
        
        // iterate through language frequencies
        for (int freqIndex = 0; freqIndex < frequencies.length; freqIndex++) {
            double deviation = calcDeviation(frequencies[freqIndex], text);
            
            if (lowestDeviation < 0 || lowestDeviation > deviation) {
                lowestDeviation = deviation;
            }
        }
        
        return lowestDeviation;
    }
    
    public double calcDeviation(String languageFrequency, String[] text) {
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        HashMap<Character, Integer> chances = new HashMap<Character, Integer>();
        
        // parse languageFrequency
        for (int langIndex = 0; langIndex < languageFrequency.length(); langIndex = langIndex + 3) {
            char c = languageFrequency.charAt(langIndex);
            int chance = Integer.parseInt(languageFrequency.substring(langIndex + 1, langIndex + 3));
            
            System.out.println("putting " + c + ":" + chance);
            chances.put(c, chance);
            counter.put(c, 0);
        }
        
        // count characters in text
        int total = 0;
        for (String line : text) {
            for (char c : line.toCharArray()) {
                if (c == ' ') {
                    continue;
                }
                
                int count = 1;
                if (counter.containsKey(c)) {
                    count += (int)counter.get(c);
                }
                
                counter.put(c, count);
                total++;
            }
        }
        
        // analyze deviation
        double totalDeviation = 0;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) { 
            double chance = chances.containsKey(entry.getKey()) ? (int)chances.get(entry.getKey()) : 0;
            double expected = (double)(total * chance) / 100;
            
            double deviation = Math.abs(expected - entry.getValue());
            
            totalDeviation += deviation * deviation;
            
            System.out.println("Character: " + entry.getKey() + ", chance: " + chance + ", expected: " + expected + ", actual: " + entry.getValue() + ", deviation: " + deviation + ", totalDeviation: " + totalDeviation);
        }
        
        return totalDeviation;
    }

}