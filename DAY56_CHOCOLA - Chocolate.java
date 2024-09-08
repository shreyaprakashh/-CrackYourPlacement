// We are given a bar of chocolate composed of m*n square pieces. One should break the chocolate into single squares. 
// Parts of the chocolate may be broken along the vertical and horizontal lines as indicated by the broken lines in the picture.
// A single break of a part of the chocolate along a chosen vertical or horizontal line divides that part into two smaller ones. 
// Each break of a part of the chocolate is charged a cost expressed by a positive integer. This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along.
// Let us denote the costs of breaking along consecutive vertical lines with x1, x2, ..., xm-1 and along horizontal lines with y1, y2, ..., yn-1.
// The cost of breaking the whole bar into single squares is the sum of the successive breaks. One should compute the minimal cost of breaking the whole chocolate into single squares.

import java.util.*;
import java.lang.*;

class Main
{
	public static void main (String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine().trim());
        
        while (testCases-- > 0) {
            scanner.nextLine();
            String[] dimensions = scanner.nextLine().split(" ");
            int m = Integer.parseInt(dimensions[0]);
            int n = Integer.parseInt(dimensions[1]);
            
            Integer[] verticalCuts = new Integer[m - 1];
            Integer[] horizontalCuts = new Integer[n - 1];
            
            for (int i = 0; i < m - 1; i++) {
                verticalCuts[i] = Integer.parseInt(scanner.nextLine().trim());
            }
            
            for (int i = 0; i < n - 1; i++) {
                horizontalCuts[i] = Integer.parseInt(scanner.nextLine().trim());
            }
            
            
            Arrays.sort(verticalCuts, Collections.reverseOrder());
            Arrays.sort(horizontalCuts, Collections.reverseOrder());
            
            int hSegments = 1;
            int vSegments = 1; 
            int minCost = 0;
            int i = 0, j = 0;
            
            while (i < verticalCuts.length && j < horizontalCuts.length) {
                if (verticalCuts[i] >= horizontalCuts[j]) {
                    minCost += verticalCuts[i] * hSegments;
                    vSegments++;
                    i++;
                } else {
                    minCost += horizontalCuts[j] * vSegments;
                    hSegments++;
                    j++;
                }
            }
            
            while (i < verticalCuts.length) {
                minCost += verticalCuts[i] * hSegments;
                i++;
            }
            
            while (j < horizontalCuts.length) {
                minCost += horizontalCuts[j] * vSegments;
                j++;
            }
            
            System.out.println(minCost);
            
        }
        
  
	}
}
