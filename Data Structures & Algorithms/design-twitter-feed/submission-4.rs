use std::{collections::{HashMap, HashSet}, cmp::Reverse};

#[derive(Debug, Default)]
struct Twitter {
    /// user -> tweet
    user_tweet_map: HashMap<i32, Vec<(u32, i32)>>,
    /// follower -> followees 
    follower_map: HashMap<i32, HashSet<i32>>,
    /// timestep
    time_step: u32,
}

impl Twitter {
    pub fn new() -> Self {
        Default::default()
    }

    pub fn post_tweet(&mut self, user_id: i32, tweet_id: i32) {
        self.user_tweet_map
            .entry(user_id)
            .or_default()
            .push((self.time_step, tweet_id));
        self.time_step += 1;
    }

    pub fn get_news_feed(&mut self, user_id: i32) -> Vec<i32> {
        // (timestep, tweet_id, user_id, index)
        let mut max_heap: BinaryHeap<(u32, i32, i32, usize)> = BinaryHeap::new();
        let users = {
            let mut u = vec![user_id];
            if let Some(set) = self.follower_map.get(&user_id) {
                u.extend(set.iter().copied());
            }
            u
        };

        for uid in users {
            if let Some(tweets) = self.user_tweet_map.get(&uid) {
                if !tweets.is_empty() {
                    let last = tweets.len() - 1;
                    let (step, tid) = tweets[last];
                    max_heap.push((step, tid, uid, last));
                }
            }
        }
        let mut result = Vec::with_capacity(10);
        while result.len() < 10 {
            let Some((_, tid, uid, idx)) = max_heap.pop() else {break;};
            result.push(tid);
            if idx > 0 {
                if let Some(tweets) = self.user_tweet_map.get(&uid) {
                    let (step, new_tid) = tweets[idx - 1];
                    max_heap.push((step, new_tid, uid, idx - 1));
                }
            }
        }
        result
    }


    pub fn follow(&mut self, follower_id: i32, followee_id: i32) {
        if follower_id == followee_id {
            return;
        }
        let mut set= HashSet::new();
        set.insert(followee_id);
        self.follower_map
            .entry(follower_id)
            .and_modify(|s| {s.insert(followee_id);})
            .or_insert(set);
    }

    pub fn unfollow(&mut self, follower_id: i32, followee_id: i32) {
        if follower_id == followee_id {
            return;
        }
        if let Some(s) = self.follower_map.get_mut(&follower_id) {
            s.remove(&followee_id);
        }
    }

}

/*
[
    "Twitter", 
    "postTweet", [3, 9], 
        3 -> {9}
    "postTweet", [3, 10], 
        3 -> {10, 9}
    "postTweet", [3, 11], 
        3 -> {11, 10, 9}
    "postTweet", [3, 12], 
        3 -> {12, 11, 10, 9}
    "postTweet", [4, 13], 
        3 -> {13, 12, 11, 10, 9}
    "postTweet", [4, 14],
        3 -> {14, 13, 12, 11, 10, 9}
    "follow", [3, 4], 
        3 -> {14, 13, 12, 11, 10, 9}
        3 -> {4}
    "getNewsFeed", [3], 
        3 -> {(14, 6), (13, 5), (12, 4), (11, 3), (10, 2), (9, 1)}
        3 -> {4}
    "follow", [4, 3], 
        3 -> {(14, 6), (13, 5), (12, 4), (11, 3), (10, 2), (9, 1)}
        3 -> {4}
        4 -> {3}
    "getNewsFeed", [4], 
        3 -> {(14, 6), (13, 5), (12, 4), (11, 3), (10, 2), (9, 1)}
        3 -> {4}
        4 -> {3}
    "unfollow", [3, 4], 
        3 -> {(14, 6), (13, 5), (12, 4), (11, 3), (10, 2), (9, 1)}
        3 -> {}
        4 -> {3}
    "postTweet", [4, 15], 
        3 -> {(14, 6), (13, 5), (12, 4), (11, 3), (10, 2), (9, 1)}
        4 -> {(15, 7)}
        3 -> {}
        4 -> {3}
    "postTweet", [3, 16], 
        3 -> {(14, 6), (13, 5), (12, 4), (11, 3), (10, 2), (9, 1)}
        4 -> {(16, 8), (15, 7)}
        3 -> {}
        4 -> {3}
    "getNewsFeed", [3], 
        3 -> {(14, 6), (13, 5), (12, 4), (11, 3), (10, 2), (9, 1)}
        4 -> {(16, 8), (15, 7)}
        3 -> {}
        4 -> {3}
    "getNewsFeed", [4], 
    "unfollow", [4, 3]
]
*/