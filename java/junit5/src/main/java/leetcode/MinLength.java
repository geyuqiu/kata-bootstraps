package leetcode;

public class MinLength {
    int minLength(String s) {
        while(s.contains("AB") || s.contains("CD")) {
            int abIndex = s.indexOf("AB");
            if (abIndex != -1) s = s.substring(0, abIndex) + s.substring(abIndex+2);
            System.out.println(s);
            int cdIndex = s.indexOf("CD");
            if (cdIndex != -1) s = s.substring(0, cdIndex) + s.substring(cdIndex+2);
        }
        return s.length();
    }
}
