import java.util.*;
import java.math.*;

public class BestDecomposition {
    
    // After a little consideration, all cases seem to have a max by breaking down to 3s and 2s.
    // If we fit as many 3s in as possible so that any remainder can be fitted with 2s we'll get the max
    public int maxProduct(int n) {
        if (n <= 1) {
            return n;
        }
        
        int threes;
        for (threes = n / 3; threes >= 0; threes--) {
            if ((n - threes * 3) % 2 == 0) {
                break;
            }
        }

        double max = Math.pow(2, (n - threes * 3) / 2);
        for (int i = 0; i < threes; i++) {
            max = (max * 3) % 10007;
        }
                
        return (int)max;
    }
    
}