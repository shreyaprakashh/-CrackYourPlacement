// Two water Jug problem
// You are at the side of a river. You are given a m litre jug and a n litre jug . Both the jugs are initially empty. 
// The jugs dont have markings to allow measuring smaller quantities. You have to use the jugs to measure d litres of water . 
// Determine the minimum no of operations to be performed to obtain d litres of water in one of the jugs.

class Solution
{
    int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b, a%b);
    }
    int pour(int fromCap, int toCap, int d){
        int from = fromCap;
        int to = 0;
        int step = 1;
        while (from != d && to != d){
            int temp =Math.min(from, toCap - to);
            to += temp;
            from -= temp;
            step++;
            if (from == d || to == d)
            break;
            if (from == 0){
                from = fromCap;
                step++;
                
            }
            if (to == toCap){
                to = 0;
                step++;
                
            }
        
        }
        return step;
        
    }
    
    public int minSteps(int m, int n, int d){
        if (m > n){
            int t=m;
            m=n;
            n=t;
            
        }
        if (d > n) return -1;
        if ((d % gcd(n,m)) != 0) return -1;
        return Math.min(pour(n,m,d),pour(m,n,d));
        
    }
}
