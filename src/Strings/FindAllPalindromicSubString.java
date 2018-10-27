package Strings;

import java.util.ArrayList;
import java.util.List;
//aa
//bb
//bbb
//abbba
//aabbbaa
//bb
//aa

public class FindAllPalindromicSubString {
    public static void main(String [] args){
        FindAllPalindromicSubString f = new FindAllPalindromicSubString();
        List<String> result = f.getAllPalindromes("aabbbaa");
        for(String s : result){
            System.out.println(s);
        }
    }

    private List<String> getAllPalindromes(String input) {
        List<String> result = new ArrayList<String>();
        if(input == null || input.length() == 0){
            return result;
        }

        for(int i = 0; i <input.length();i++){
            palindrome(input, i, i+1, result);
            palindrome(input, i-1, i+1, result);
        }
        return result;
    }

    private void palindrome(String input, int j, int k, List<String> result) {
        for(; j>=0 && k<input.length(); j--,k++){

            if(isPalindrome(input, j, k)){
                result.add(input.substring(j, k+1));
            }
        }
    }

    private boolean isPalindrome(String input , int start , int end){
        if(start <0 || end>=input.length()){
            return false;
        }
        while(start <= end && start >=0 && end <= input.length()){
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
            start++; end--;
        }
        return true;
    }

}
