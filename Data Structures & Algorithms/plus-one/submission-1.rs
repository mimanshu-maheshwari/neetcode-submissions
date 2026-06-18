impl Solution {
    pub fn plus_one(mut digits: Vec<i32>) -> Vec<i32> {
        let mut carry = 1;
        for i in (0..digits.len()).rev() {
            if carry == 0 {
                break;
            }
            let val = digits[i] + carry;
            digits[i] = val % 10;
            carry = val / 10;
        }
        if carry > 0 {
            digits.insert(0, carry);
        }
        digits
    }
}
