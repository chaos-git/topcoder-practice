public class WinningTrick {

    // formula: w = 0 if myspeed > theirspeed, else w = (theirspeed - myspeed) / 2
    public double minimumSpeed(int[] speed, int yourSpeed) {

        int max_wind_needed = 0;
        for (int i = 0; i < speed.length; i++) {
            if (speed[i] > yourSpeed) {
                int wind_needed = (speed[i] - yourSpeed) / 2;

                if (wind_needed > max_wind_needed) {
                    max_wind_needed = wind_needed;
                }
            }
        }

        return max_wind_needed;
    }

}