//Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            int curr = columnNumber%26;
            columnNumber /= 26;
            sb.append((char)(curr+'A'));
        }
        return sb.reverse().toString();
    }
}
