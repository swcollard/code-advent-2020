package code.advent;

import java.util.Map;

public class RomanNumerals {
    static Map<Character, Integer> romanValue = Map.of('I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);
    public int romanToInt(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = romanValue.getOrDefault(s.charAt(i), 0);
            if (((i + 1) < s.length())
                    && (romanValue.getOrDefault(s.charAt(i +1), 0) > n)) {
                result += romanValue.getOrDefault(s.charAt(i +1), 0) - n;
                i++;
            } else {
                result += n;
            }
        }
        return result;
    }
}
