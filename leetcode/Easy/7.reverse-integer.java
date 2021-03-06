/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (25.23%)
 * Total Accepted:    650.6K
 * Total Submissions: 2.6M
 * Testcase Example:  '123'
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: 321
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: -123
 * Output: -321
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 120
 * Output: 21
 * 
 * 
 * Note:
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose
 * of this problem, assume that your function returns 0 when the reversed
 * integer overflows.
 * 
 */


 /*  旧代码
class Solution {
    public int reverse(int x) {
        int flag = x<0 ? -1:1;
        long result=0;
        x = Math.abs(x);

        while(x != 0){
            result = result * 10 + x%10;
            x = x / 10;
        }
        
        return result*flag;
    }
} */


class Solution {
    public int reverse(int x) {
        long result = 0;
        while(x != 0){
            result = result*10 + x%10;
            x = x / 10;
        }
        if(result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE){
            return (int)result;
        }else{
            return 0;
        }
    }
}


