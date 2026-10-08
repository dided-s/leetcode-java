package easy._1021_Remove_Outermost_Parentheses;

import annotations.Easy;

@Easy
public class Solution2 {

    public String removeOuterParentheses(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int count = 0, left = 0;

        for(int i = 0; i < n; i++){
            if(chars[i] == '(')
                count++;
            else
                count--;

            if(count == 0){
                chars[left] = ' ';
                chars[i] = ' ';
                left = i+1;
            }
        }

        return new String(chars).replace(" ", "");
    }
}