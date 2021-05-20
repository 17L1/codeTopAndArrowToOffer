package com.guang.top74电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 17L1
 * @date: 2021年05月15日 5:29 下午
 * @method：
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() < 1){
            return res;
        }
        String[] digitsMap = {"abc","edf","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(res,digits,digitsMap,0,"");
        return res;
    }

    private void dfs(List<String> res, String digits, String[] digitsMap, int i, String path) {
        if (path.length() == digits.length()){
            res.add(path);
            return;
        }
        String nextStr = digitsMap[digits.charAt(i) - '2'];
        for (char c : nextStr.toCharArray()){
            dfs(res,digits,digitsMap,i+1,path+c);
        }
    }
}
