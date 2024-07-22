//Given an integer, convert it to a Roman numeral.
class Solution {
    private final List<Integer> val = new ArrayList<>(List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1));
    private final List<String> sym = new ArrayList<>(List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"));
    
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            while (num >= val.get(i)) {
                num -= val.get(i);
                result.append(sym.get(i));
            }
            i++;
        }
        return result.toString();
    }
}
