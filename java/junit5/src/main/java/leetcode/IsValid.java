package leetcode;

import java.util.Stack;

public class IsValid {
    boolean isValid(String s) {
        Stack<Character> st = new Stack();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.empty()) return false;
                char top = st.peek();
                if (top == '(' && c ==')'
                        || top == '[' && c ==']'
                        || top == '{' && c =='}'
                ) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        if (st.empty()) return true;
        return false;
    }
}
