public class SpeedRadar {

    public double averageSpeed(int minLimit, int maxLimit, int[] readings) {
    
        int totalInLimit = 0;
        int totalSpeeds = 0;
        
        for (int i = 0; i < readings.length; i++) {
        
            int speed = readings[i];
            if (speed >= minLimit && speed <= maxLimit) {
                totalInLimit++;
                totalSpeeds += speed;
            }
        
        }
        
        if ((double)totalInLimit / readings.length < 0.9) {
            return 0;
        }
        
        return (double)totalSpeeds / totalInLimit;    
    }
    
}