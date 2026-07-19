#[derive(Debug, Clone)]
struct Node {
    word: Option<String>, 
    children: HashMap<char, Box<Node>>
}

impl Node {
    fn new() -> Self {
        Self {
            word: None,
            children: Default::default(),
        }
    }
}

#[derive(Debug, Clone)]
struct PrefixTree {
    root: Node
}

impl PrefixTree {
    pub fn new() -> Self {
        Self {
            root: Node::new(),
        }
    }

    pub fn insert(&mut self, word: String) {
        let mut curr = &mut self.root;
        let chars  = word.chars().collect::<Vec<char>>();
        for &c in chars.iter() {
            curr = curr.children.entry(c).or_insert_with(|| Box::new(Node::new()));
        }
        curr.word = Some(word);
    }

    pub fn search(&self, word: String) -> bool {
        let chars  = word.chars().collect::<Vec<char>>();
        let mut curr = &self.root;
        for c in chars.iter() {
            match curr.children.get(c) {
                Some(val) => curr = val,
                None => return false,
            }
        }
        curr.word.is_some()
    }

    pub fn starts_with(&self, prefix: String) -> bool {
        let chars  = prefix.chars().collect::<Vec<char>>();
        let mut curr = &self.root;
        for c in chars.iter() {
            match curr.children.get(c) {
                Some(val) => curr = val,
                None => return false,
            }
        }
        true
    }
}
