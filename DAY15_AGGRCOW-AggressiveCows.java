import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean canPlaceCows(int[] stalls, int N, int C, int distance) {
        int count = 1;
        int lastPosition = stalls[0];
        
        for (int i = 1; i < N; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++;
                lastPosition = stalls[i];
                if (count == C) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int largestMinDistance(int[] stalls, int N, int C) {
        Arrays.sort(stalls);
        
        int low = 1;
        int high = stalls[N - 1] - stalls[0];
        int best = 0;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlaceCows(stalls, N, C, mid)) {
                best = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return best;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        int[] results = new int[t];
        
        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            int C = sc.nextInt();
            int[] stalls = new int[N];
            
            for (int j = 0; j < N; j++) {
                stalls[j] = sc.nextInt();
            }
            
            results[i] = largestMinDistance(stalls, N, C);
        }
        
        for (int result : results) {
            System.out.println(result);
        }
        
        sc.close();
    }
}
