struct DisjointUnionSet {
    parent: Vec<usize>, 
    size  : Vec<usize>,
    comp : i32,
}

impl DisjointUnionSet {
    pub fn new(n: usize) -> Self {
        let mut parent = vec![0; n];
        let mut size   = vec![0; n];
        for i in 0..n {
            parent[i] = i;
            size[i] = 1;
        }
        Self { parent, size, comp: n as i32 }
    }
    pub fn find(&mut self, x: usize) -> usize {
        if self.parent[x] != x {
            self.parent[x] = self.find(self.parent[x]);
        }
        self.parent[x]
    }

    pub fn union(&mut self, u: usize, v: usize) -> bool{
        let mut pu = self.find(u);
        let mut pv = self.find(v);
        if pu == pv {
            return false;
        }
        if self.size[pu] < self.size[pv] {
            (pu, pv) = (pv, pu);
        }
        self.size[pu] += self.size[pv];
        self.parent[pv] = pu;
        self.comp -= 1;
        true
    }
    pub fn components(&self) -> i32 {
        self.comp
    }
}

impl Solution {
    pub fn find_redundant_connection(edges: Vec<Vec<i32>>) -> Vec<i32> {
        let mut dsu = DisjointUnionSet::new(edges.len() + 1);
        for edge in edges.iter() {
            let ai = edge[0] as usize;
            let bi = edge[1] as usize;
            if !dsu.union(ai, bi) {
                return edge.clone();
            }
        }
        vec![]
    }
}
