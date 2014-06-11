import java.util.*;

public class TroytownKeeper {
    Set<Integer> done = new HashSet<Integer>();
    String[] maze;
    int painted = 0;
    int rows, cols;
    
    public int limeLiters(String[] maze) {
        this.maze = maze;
        rows = maze.length;
        cols = maze[0].length();
                
        /* horizontal perimeter */
        System.out.println("horizontal");
        for (int col = 0; col < cols; col++) {
            processNearbyCell(0, col);
            processNearbyCell(rows - 1, col);
        }

        /* vertical perimeter */        
        System.out.println("vertical");
        for (int row = 0; row < rows; row++) {
            processNearbyCell(row, 0);
            processNearbyCell(row, cols - 1);
        }
        
        return painted;
    }
    
    private void processCell(int row, int col) {
        System.out.println("processCell " + col + "," + row);
        done.add(row * cols + col);
        processNearbyCell(row - 1, col);
        processNearbyCell(row + 1, col);
        processNearbyCell(row, col - 1);
        processNearbyCell(row, col + 1);
    }
    
    private void processNearbyCell(int row, int col) {
        System.out.println("processNearbyCell " + col + "," + row);
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Discarding " + col + "," + row);
            return;
        }
        
        if (done.contains(row * cols + col)) {
            System.out.println("Ignoring space " + col + "," + row);
            return;
        }
        
        if (maze[row].charAt(col) == '#') {
            System.out.println("Painting " + col + "," + row);
            painted++;
        } else {
            processCell(row, col);
        }
    }

}