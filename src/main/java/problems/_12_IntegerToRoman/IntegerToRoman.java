package problems._12_IntegerToRoman;

public class IntegerToRoman {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                sb.append(symbol);
            }
            if (num == 0) break;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman s = new IntegerToRoman();
        System.out.println(s.intToRoman(3749));
        System.out.println(s.intToRoman(58));
        System.out.println(s.intToRoman(1994));
    }
}
