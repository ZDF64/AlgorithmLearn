package com.algorithmclass.task.LessonTask001;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文子串
 */
public class LessonM004 {
    
    public static String longestPalindrome(String s) {
        String returnStr = "";
        Map<Character,Integer> maps = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i ++){
            char current = s.charAt(i);
            if(maps.containsKey(current)){
                returnStr = s.substring(maps.get(current), i).length() >returnStr.length() 
                            ? s.substring(maps.get(current), i): returnStr;
            }else{
                maps.put(current,i);
            }
        }
        return returnStr;
    }

    public static void main(String[] args) {
        System.out.println(LessonM004.longestPalindrome("babab"));
        ;
    }
}
