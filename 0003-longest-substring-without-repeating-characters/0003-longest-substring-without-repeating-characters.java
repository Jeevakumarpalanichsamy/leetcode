class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() < 2) return s.length();

        String[] splitVal = s.split("");
        Set<String> exists = new HashSet<>();
        int left = 0, right = 0, result = 0;
        for(String small : splitVal){
          if(exists.contains(small)){
            while(s.substring(left,right).contains(small)){
                exists.remove(splitVal[left]);
                left++;
            }
          }
          exists.add(small);
          result = result > right - left + 1 ? result : right - left + 1;  
          right++;
        }
        // result = result > right - left ? result : right - left;
        return result;
    }
}