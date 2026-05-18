use std::collections::{HashMap};
struct UnionFindDSU {
    parent: Vec<usize>,
    size: Vec<usize>  
}
impl UnionFindDSU {
    pub fn new(n: usize) -> Self {
        let mut parent = Vec::with_capacity(n + 1);
        for i in 0..=n {
            parent.push(i);
        }
        let size = vec![1; n + 1];
        Self {
            parent, size
        }
    }

    pub fn find(&mut self, x: usize) -> usize {
        if self.parent[x] != x {
            self.parent[x] = self.find(self.parent[x]);
        }
        self.parent[x]
    }
    pub fn union(&mut self, u: usize, v: usize) -> bool {
        let mut parentU = self.find(u);
        let mut parentV = self.find(v);
        if parentU == parentV {
            return false;
        }
        if self.size[parentU] < self.size[parentV] {
            (parentU, parentV) = (parentV, parentU);
        }
        self.size[parentU] += parentV;
        self.parent[parentV] = parentU;
        return true;
    }
}

impl Solution {
    pub fn accounts_merge(accounts: Vec<Vec<String>>) -> Vec<Vec<String>> {
        let len = accounts.len();
        let mut uf = UnionFindDSU::new(len);
        let mut email_to_acc_id = HashMap::<String, usize>::new();
        for (i, account) in accounts.iter().enumerate() {
            for email in account.iter().skip(1) {
                if email_to_acc_id.contains_key(email) {
                    uf.union(i, email_to_acc_id[email]);
                } else {
                    email_to_acc_id.insert(email.clone(), i);
                }
            }
        }

        let mut acc_to_emails = HashMap::<usize, Vec<String>>::new();
        for (email, accIdx) in email_to_acc_id {
            let parent = uf.find(accIdx);
            acc_to_emails.entry(parent)
                         .and_modify(|l| l.push(email.clone()))
                         .or_insert(vec![email]);
        }
        let mut result = Vec::new();
        for (id, mut emails) in acc_to_emails {
            let account_name = (accounts[id][0]).clone();
            emails.sort_unstable();
            emails.insert(0, account_name);
            result.push(emails);
        }
        result
    }
}
