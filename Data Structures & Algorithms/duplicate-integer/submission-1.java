class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> freqMap = new HashSet<>();
        for (int num : nums){
            if (freqMap.contains(num)){
                return true;
            } 
            freqMap.add(num);
        }
        return false;
    }
}