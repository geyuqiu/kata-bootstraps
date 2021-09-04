package leetcode;

public class IntToRoman {
    String intToRoman(int arabic) {
        String roman = "";

        for (ArabicToRoman arabicToRoman: ArabicToRoman.values()) {
            if (arabic == 0) return roman;
            while(arabic >= arabicToRoman.arabic) {
                roman += arabicToRoman.roman;
                arabic -= arabicToRoman.arabic;
            }
        }

        return roman;
    }

    enum ArabicToRoman {
        THOUSAND(1000, "M"),
        NINE_HUNDRED(900, "CM"),
        FIVE_HUNDRED(500, "D"),
        FOUR_HUNDRED(400, "CD"),
        HUNDRED(100, "C"),
        NINETY(90, "XC"),
        FIFTY(50, "L"),
        FORTY(40, "XL"),
        TEN(10, "X"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");

        private final int arabic;
        private final String roman;

        ArabicToRoman(int arabic, String roman) {
            this.arabic = arabic;
            this.roman = roman;
        }
    }
}
