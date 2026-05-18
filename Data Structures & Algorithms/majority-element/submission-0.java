class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityElement = -1;
        for (int num: nums){
            if (num == majorityElement){
                count++;
            } else {
                count--;
            }
            if (count <= 0) {
                majorityElement = num;
                count = 1;
            } 
        }
        return majorityElement;
    }
}