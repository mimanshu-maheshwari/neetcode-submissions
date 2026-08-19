impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        let mut stack = Vec::new();
        for token in &tokens {
            match token.as_str() {
                "+" => {
                    let (num1, num2) = (stack.pop().unwrap(), stack.pop().unwrap());
                    stack.push(num1 + num2);
                },
                "-" => {
                    let (num1, num2) = (stack.pop().unwrap(), stack.pop().unwrap());
                    stack.push(num2 - num1);
                },
                "/" => {
                    let (num1, num2) = (stack.pop().unwrap(), stack.pop().unwrap());
                    stack.push(num2 / num1);
                },
                "*" => {
                    let (num1, num2) = (stack.pop().unwrap(), stack.pop().unwrap());
                    stack.push(num2 * num1);
                },
                num_str => {
                    let num = num_str.parse::<i32>().unwrap();
                    stack.push(num);
                },
            }
        }
        stack.pop().unwrap()
    }
}
