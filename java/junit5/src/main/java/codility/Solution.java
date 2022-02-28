package codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
  // saved contacts: return contact with given substring
  // if more than 1 available, return alphabetically (contact) smallest one of all
  // return "NO CONTACT" if no match found
  public String solution(String[] A, String[] B, String P) {
    List<String> contactsFiltered = new ArrayList<>();

    // check if substring
    for (int i = 0; i < A.length; i++) {
      if (B[i].indexOf(P) != -1) {
        contactsFiltered.add(A[i]);
      }
    }

    if (contactsFiltered.isEmpty()) return "NO CONTACT";

    // return alphabetically (contact) smallest one of all
    // sort string array alphabetically java
    Collections.sort(contactsFiltered);

    return contactsFiltered.get(0);
  }
}
