class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        StringBuilder astr = new StringBuilder(a);
        StringBuilder bstr = new StringBuilder(b);
        astr.reverse();
        bstr.reverse();
        if (astr.length() > bstr.length()) {
            StringBuilder temp = astr;
            astr = bstr;
            bstr = temp;
        }
        char carry = '0';
        int i = 0;
        while (i < astr.length() || i < bstr.length()) {
            char c = '0';
            if (i < astr.length()) {
                if (astr.charAt(i) == '0' && '0' == bstr.charAt(i)) {
                    c = '0';
                    if (carry == '1') {
                        c = '1';
                        carry = '0';
                    }
                } else if (astr.charAt(i) == '1' && bstr.charAt(i) == '1') {
                    c = '0';
                    if (carry == '1') {
                        c = '1';
                    }
                    carry = '1';
                } else {
                    c = '1';
                    if (carry == '1') {
                        c = '0';
                        carry = '1';
                    }
                }
            } else if (i < bstr.length()) {
                c = bstr.charAt(i);
                if (carry == '1') {
                    if (c == '1') {
                        c = '0';
                    } else {
                        c = '1';
                        carry = '0';
                    }
                }
            }
            result.append(c);
            ++i;
        }
        if (carry == '1') {
            result.append(carry);
        }
        result.reverse();
        return result.toString();
    }
}