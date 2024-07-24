//Convert a non-negative integer num to its English words representation.
class Solution {
    private final String[] belowTen = new String[]
    {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    
    private final String[] belowTwenty = new String[]
    {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private final String[] belowHundred = new String[]
    { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    private int BILLION = 1000000000;
    private int MILLION = 1000000;
    private int THOUSAND = 1000;
    private int HUNDRED = 100;
    
    public String numberToWords(int num) {
        return num == 0 ? "Zero" : helper(num);
    }
    
    private String helper(int num){
        StringBuilder sb = new StringBuilder();
        if(num < 10){
            sb.append(belowTen[num]);
        }
        else if(num < 20){
            sb.append(belowTwenty[num - 10]);
        }
        else if(num < HUNDRED){
            sb.append(belowHundred[num / 10])
                .append(" ")
                .append(helper(num % 10));
        }
        else if(num < THOUSAND){
            sb.append(helper(num / HUNDRED))
                .append(" Hundred ")
                .append(helper(num % HUNDRED));
        }
        else if(num < MILLION){
            sb.append(helper(num / THOUSAND))
                .append(" Thousand ")
                .append(helper(num % THOUSAND));
        }
        else if(num < BILLION){
            sb.append(helper(num / MILLION))
                .append(" Million ")
                .append(helper(num % MILLION));
        }
        else{
            sb.append(helper(num / BILLION))
                .append(" Billion ")
                .append(helper(num % BILLION));
        }
        
        return sb.toString().trim();
        
            
       
    }
}
