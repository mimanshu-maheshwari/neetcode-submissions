use std::collections::BinaryHeap;

impl Solution {
    pub fn k_closest(mut points: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        let k = k as usize;
        let mut l = 0usize; 
        let mut r = points.len() - 1;
        let mut pivot = points.len();

        while pivot != k {
            pivot = Self::partition(&mut points, l, r);
            if pivot < k {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }
        points.truncate(k);
        points
    }
    fn partition(points: &mut Vec<Vec<i32>>, l: usize, r: usize ) -> usize {
        let pivot_dist = points[r][0] * points[r][0] + points[r][1] * points[r][1];
        let mut i = l;
        for j in l..r {
            let d = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if d <= pivot_dist {
                points.swap(i, j);
                i += 1;
            }
        }
        points.swap(i, r);
        i
    }
}
