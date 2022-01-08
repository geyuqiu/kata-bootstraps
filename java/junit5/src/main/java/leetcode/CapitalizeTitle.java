package leetcode;

public class CapitalizeTitle {
  String capitalizeTitle(String title) {
    String[] splits = title.split(" ");
    String result = "";
    for (String split: splits) {
      if (split.length() < 3) {
        split = toLowerCase(split) + " ";
      } else {
        split = toUpperCase(split.substring(0,1)) + toLowerCase(split.substring(1)) + " ";
      }
      result += split;
    }
    return result.substring(0, result.length()-1);
  }

  private String toUpperCase(String substring) {
    return substring.toUpperCase();
  }

  private String toLowerCase(String split) {
    return split.toLowerCase();
  }
}
