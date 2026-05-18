class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String a, b;
        if (str1.length() >= str2.length()) {
            a = str1;
            b = str2;
        } else {
            a = str2;
            b = str1;
        }
        String result = b;
        while (result.length() > 0){
            if (canDivide(a, result) && canDivide(b, result)) {
                return result;
            } else {
                result = result.substring(1);
            }
        }
        return result;
    }

    private boolean canDivide(String parent, String child) {
        if (parent.length() % child.length() != 0){
            return false;
        }
        while (parent.length() != 0) {
            if (parent.startsWith(child)) {
                parent = parent.substring(child.length());
            } else {
                return false;
            }
        }
        return true;
    }
}