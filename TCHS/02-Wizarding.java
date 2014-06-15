public class Wizarding {
    int maxCounterValue = -1;
    String maxCounterspell = "";
    
    public String counterspell (String spell, String rules) {
        dive(spell, rules, 0, 1, "");
        
        return maxCounterspell;
    }
    
    private void dive(String spell, String rules, int index, int score, String counterspell) {

        if (score % 77077 > maxCounterValue) { //large max
            maxCounterValue = score % 77077;
            maxCounterspell = counterspell;
        } else if (score % 77077 == maxCounterValue && counterspell.length() <= maxCounterspell.length() && counterspell.compareTo(maxCounterspell) < 0) { // shorter or lexicographically earlier
            maxCounterspell = counterspell;
        }
        
        if (index == spell.length()) { //we're at the end
            return;
        }

        // handle 3 scenarios, skip, no swap, and swap
        dive(spell, rules, index + 1, score, counterspell); //skip
        dive(spell, rules, index + 1, score * (spell.charAt(index) - 'A' + 1), counterspell + spell.charAt(index)); //no swap
        dive(spell, rules, index + 1, score * (rules.charAt(spell.charAt(index) - 'A') - 'A' + 1), counterspell + rules.charAt(spell.charAt(index) - 'A')); //swap
    }
}