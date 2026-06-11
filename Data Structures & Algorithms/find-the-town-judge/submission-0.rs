impl Solution {
    pub fn find_judge(n: i32, trust: Vec<Vec<i32>>) -> i32 {
        // n - > (trust count, trusted count)
        let mut map = HashMap::new();
        for t in &trust {
            let ai = t[0];
            let bi = t[1];
            // increment how many trust it
            map.entry(ai).and_modify(|(a,_)| *a += 1).or_insert((1, 0));
            // increment how many it trusts
            map.entry(bi).and_modify(|(_, b)| *b += 1).or_insert((0, 1));
        }
        for (&i, &(tc, tdc)) in map.iter() {
            if tc == 0 && tdc == n - 1 {
                return i;
            }
        }
        return -1;
    }
}

// it is a directed graph 
// find the node on which every other node is dependent
// it is not dependent on any one else 

// brute force solution will be to check for all the n values if it satisfies the condition 
// better way is to create a graph 
// or we can check for a node n_i what is the trust count for it (meaning how many trust it)
// also find whom they trust.
