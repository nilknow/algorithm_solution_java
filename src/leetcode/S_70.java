package leetcode;

import java.util.HashMap;
import java.util.Map;

public class S_70 {
    static class Solution {
        private Map<Integer,Integer> cache=new HashMap<>();
        public int climbStairs(int n) {
            if(n==-1){
                return 0;
            }else if(n==0){
                return 0;
            }else if(n==1){
                return 1;
            }else if(n==2){
                return 2;
            }
            int ans;
            if(cache.containsKey(n)){
                ans=cache.get(n);
            }else{
                ans= climbStairs(n-1)+climbStairs(n-2);
                cache.put(n,ans);
            }
            return ans;
        }
    }
}
