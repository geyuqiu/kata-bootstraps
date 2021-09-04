package leetcode;

public class LongestCommonPrefix {
    String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        String first = strs[0];
        String res = first;

        for (int i=1; i<strs.length; i++) {
            String cP = "";

            for (int j=0; j<strs[i].length() && j<strs[0].length(); j++){
                if (strs[i].charAt(j) == first.charAt(j)) {
                    cP += first.charAt(j);
                } else {
                    break;
                }
            }
            if (cP.length() < res.length()) {
                res = cP;
            }
        }

        return res;
    }
}
