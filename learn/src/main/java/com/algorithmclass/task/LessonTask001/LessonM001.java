package com.algorithmclass.task.LessonTask001;

import java.util.ArrayList;
import java.util.List;

/**
 * 驼峰式匹配
 * camelcase-matching
 */
public class LessonM001{
    /**
     * 我的方法
     * 执行用时：13 ms, 在所有 Java 提交中击败了5.31%的用户
     * 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 5.01% 的用户
     * @param args
     */
    private static List<Boolean> camelcaseMatching(String[] queries, String pattern){
        /**
         * pattern to regex
         */
        List<Boolean> returnList= new ArrayList<>();
        String regex = "[a-z]*?";
       
        for(int i = 0 ; i < pattern.length() ; i ++){
            regex = regex + pattern.charAt(i) +"{1}[a-z]*?";
        }
        System.out.println(regex);
        for(String quers : queries){
            if(quers.matches(regex)){
                returnList.add(true);
            }else{
                returnList.add(false);
            }
        }
        return returnList;
    }
    /**
     * 双指针法
     * ？？？啥是双指针呢
     * [双指针：一头一尾同时处理，向中央逼近]
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 30.68% 的用户 
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 85.84% 的用户
     * @param queries
     * @param pattern
     * @return
     */
    private static List<Boolean> camelcaseMatching_Official(String[] queries, String pattern){
        int n = queries.length;
        List<Boolean> res = new ArrayList<Boolean>();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            int p = 0;
            for (int j = 0; j < queries[i].length(); j++) {
                char c = queries[i].charAt(j);
                if (p < pattern.length() && pattern.charAt(p) == c) {
                    p++;
                } else if (Character.isUpperCase(c)) {
                    flag = false;
                    break;
                }
            }
            if (p < pattern.length()) {
                flag = false;
            }
            res.add(flag);
        }
        return res;
    }
    public static void main(String[] args) {
        
        String[] queries = new String[]{"FrameBuffer","ForceFeedBack"};
        //{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        // String[] queries = new String[]{"FooBarTest"};
        // LessonM001.camelcaseMatching(queries, "FB").forEach(System.out::println);

        LessonM001.camelcaseMatching_Official(queries, "FB").forEach(System.out::println);
    }
}