class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> billCount = new HashMap<>();
        
        for (int bill: bills) { 
            if (bill > 5 && !canPayBill(bill - 5, billCount)) {
                return false;
            }
            billCount.merge(bill, 1, Integer::sum);
        }
        return true;
    }

    boolean canPayBill(int bill, Map<Integer, Integer> billCount) {
        if (bill == 15) {
            if (billCount.getOrDefault(10, 0) > 0 && billCount.getOrDefault(5, 0) > 0) {
                billCount.merge(10, -1, Integer::sum);
                billCount.merge(5, -1, Integer::sum);
                return true;
            }else if (billCount.getOrDefault(5, 0) > 2) {
                billCount.merge(5, -3, Integer::sum);
                return true;
            } else {
                return false;
            }
        } else if (bill == 5){ 
            if (billCount.getOrDefault(5, 0) > 0) {
                billCount.merge(5, -1, Integer::sum);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}