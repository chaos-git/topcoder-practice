public class ApocalypseSomeday {

    public int getNth(int n) {
        int counter = 664;
        
        while (n > 0) {
            if (has666(++counter)) {
                n--;
            }
        }
        
        return counter;
    }
    
    public boolean has666(int number) {
        int sixCount = 0;
        
        while (sixCount != 3 && number != 0) {
            sixCount = 
                number % 10 == 6 
                    ? sixCount + 1 
                    : 0;

            number /= 10;
        }
        
        return sixCount == 3;
    }

}