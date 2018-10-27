package DynamicProgramming;
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
*/

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String [] args){
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s  = "ADOBECODEABANC"; String t = "AABC";
        System.out.print(m.findMinimumWindow(s, t));
    }

    private String findMinimumWindow(String s, String t) {
        String result ="";
        if(t == null || s == null || s.length() <t.length()){
            return result;
        }

        HashMap<Character, Integer> target = new HashMap<>();
        for(int i =0; i < t.length(); i++){
            if(target.containsKey(t.charAt(i))){
                target.put(t.charAt(i), target.get(t.charAt(i))+1);
            }else{
                target.put(t.charAt(i), 1);
            }
        }

        int globalMax = s.length();
        int left = 0;
        int count =0;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(target.containsKey(c)){
                if(map.containsKey(c)){
                    if(map.get(c) < target.get(c)){
                        count++;
                    }
                    map.put(c, map.get(c)+1);
                }else{
                    map.put(c,1);
                    count++;
                }
            }


            if(count == t.length()){
                char lc = s.charAt(left);
                while(!map.containsKey(lc) || map.get(lc) > target.get(lc)){
                    if(map.containsKey(lc) && map.get(lc) > target.get(lc)){
                        map.put(lc, map.get(lc)-1);
                    }
                    left++;
                    lc = s.charAt(left);
                }
                if(i-left +1< globalMax ){
                    globalMax  = i-left+1;
                    result = s.substring(left, i+1);
                }
            }
        }
        return result;
    }
}
