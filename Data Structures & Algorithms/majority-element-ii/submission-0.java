class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;
        int len = nums.length;
        for (int num: nums) {
            if (num1 == num) {
                ++count1;
            } else if (num2 == num) {
                ++count2;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                --count1;
                --count2;
            }
        }
        count1 = count2 = 0;
        for (int num: nums) {
            if (num == num1) {
                ++count1;
            } else if (num == num2) {
                ++count2; 
            }
        }
        var result = new ArrayList<Integer>();
        if (count1 > len / 3) {
            result.add(num1);
        } 
        if (count2 > len / 3) {
            result.add(num2);
        }
        return result;
    }
}