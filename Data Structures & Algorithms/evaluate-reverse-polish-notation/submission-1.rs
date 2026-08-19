impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        let mut apply = |stack: &mut Vec<i32>, f: fn(i32, i32) -> i32| {
            let (num2, num1) = (stack.pop().unwrap(), stack.pop().unwrap());
            stack.push(f(num1, num2));
        };
        let mut stack = Vec::new();
        for token in &tokens {
            match token.as_str() {
                "+" => {apply(&mut stack, |a,b| a + b)},
                "-" => {apply(&mut stack, |a,b| a - b)},
                "/" => {apply(&mut stack, |a,b| a / b)},
                "*" => {apply(&mut stack, |a,b| a * b)},
                num_str => {
                    let num = num_str.parse::<i32>().unwrap();
                    stack.push(num);
                },
            }
        }
        stack.pop().unwrap()
    }
}
