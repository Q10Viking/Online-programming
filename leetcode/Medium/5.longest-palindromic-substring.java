/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.93%)
 * Total Accepted:    515.7K
 * Total Submissions: 1.9M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */

 //TODO 不会做
class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aacdefcaa"));
    }

    public static String longestPalindrome(String s) {
        String s2="";
        //reverse s
        for(int i=0;i<s.length();i++){
            s2 =  s.charAt(i)+s2;
        }
        return findLongestSubString(s,s2);
    }

    //转化成最长子串来做，但是需要注意aacdefcaa,找到的最长子串是aac
    public static String findLongestSubString(String s1,String s2){
        int l1 = s1.length(),l2 = s2.length();
        String result = "";
        int[][] match = new int[l1][l2];
        int max=Integer.MIN_VALUE;

        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i==0 || j == 0){
                        match[i][j] = 1;
                    }else{
                        match[i][j] = match[i-1][j-1]+1;
                    }
                   // If you find a longer common substring re-initialize the max count and update the result list.
                   
                   if(match[i][j]>max){
                        
                        String tmp = s1.substring(i-match[i][j]+1,i+1);
                        if(check(tmp)){
                            result = tmp;
                            max = match[i][j];
                        }
                    }

                }else{
                    match[i][j] = 0;
                }
            }
        }

        return result;
    }


    public static boolean check(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}

