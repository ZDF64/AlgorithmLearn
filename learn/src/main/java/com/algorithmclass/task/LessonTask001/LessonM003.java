package com.algorithmclass.task.LessonTask001;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LessonM003 {

    /**
     * 运行超时
     * @param inputStr
     * @return
     */
    private static String getLongestStr(String inputStr) {
        HashMap<String, String> keyMap = new HashMap<String, String>();
        Set<Character> buffSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputStr.length(); i++) {
            buffSet = new HashSet<>();
            sb = new StringBuilder();
            for (int j = i; j < inputStr.length(); j++) {
                char current = inputStr.charAt(j);
                // System.out.println(","+current+",");
                if (buffSet.contains(current)) {
                    if (keyMap.containsKey(sb.toString())) {

                    } else {
                        keyMap.put(sb.toString(), "");
                    }
                    sb = new StringBuilder();
                    buffSet = new HashSet<>();
                } else {
                    keyMap.put(sb.toString(), "");
                    keyMap.put(Character.toString(current), "");
                }
                sb.append(Character.toString(current));
                buffSet.add(current);
                if (j + 1 == inputStr.length()) {
                    // System.out.println("end show: "+sb+",");
                    if (keyMap.containsKey(sb.toString())) {
                    } else {
                        keyMap.put(sb.toString(), "");
                    }
                }
            }
        }

        // System.out.println(keyMap);
        return keyMap.keySet().stream().max(Comparator.comparingInt(x -> x.length())).orElse("");
    }

    /**
     * 思路：
     * 逐一获取字符串的字符char
     * 将这些char逐一放入map中，key为char value为下标
     * 每次获取时，检查这个字符是否被放入锅
     * 如果发现被放入过，说明该字符之前已经存在过
     * 此时只要计算出现在的位置-1与该字符第一次出现时的下标（map中的value）取差值
     * 即可知道字符长度
     * 
     * 用一个变量来存储最大值，每次循环都更新一次
     * 
     * @param inputStr
     * @return
     */
    public static int singleWhile(String inputStr) {
        int maxSize = 0, start = 0;
        ;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < inputStr.length(); end++) {
            char current = inputStr.charAt(end);
            if (map.containsKey(current)) {
                start = Math.max(map.get(current) + 1, start);
            }
            maxSize = Math.max(maxSize, end - start + 1);
            map.put(current, end);
            System.out.println(map);
        }
        return maxSize;
    }
    public static void main(String[] args) {
        // System.out.println("zxc vbnmzx".indexOf(" ",0));
        // "abcabcbb" , "vbnmzx cfggs","pwwkew","asjrgapa"
        // System.out.println("====>"+LessonM003.getLongestStr("abcabcbb")+"|bca");
        // System.out.println("====>"+LessonM003.getLongestStr("vbnmzx cfggs")+"|vbnmzx
        // cfg");
        // System.out.println("====>"+LessonM003.getLongestStr("pwwkew")+"|wke");
        // System.out.println("====>"+LessonM003.getLongestStr("asjrgapa")+"|sjrgap");
        // System.out.println("====>"+LessonM003.getLongestStr("au")+"|au");

        // System.out.println("====>"+LessonM003.singleWhile("abcabcbb")+"|bca");
        // System.out.println("====>"+LessonM003.singleWhile("vbnmzx cfggs")+"|vbnmzx
        // cfg");
        // System.out.println("====>"+LessonM003.singleWhile("pwwkew")+"|wke");
        System.out.println("====>" + LessonM003.singleWhile("asjrgapa") + "|sjrgap");
        // System.out.println("====>"+LessonM003.singleWhile("au")+"|au");
    }
}
