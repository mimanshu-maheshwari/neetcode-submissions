class Solution {
    public boolean hasDuplicate(int[] nums) {
        var freqMap = new HashSet<Integer>();
        for (int num : nums){
            if (freqMap.contains(num)){
                return true;
            } 
            freqMap.add(num);
        }
        return false;
    }
}