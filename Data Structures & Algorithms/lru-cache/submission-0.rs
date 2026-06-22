use std::rc::{Rc, Weak};
use std::cell::RefCell;
use std::collections::HashMap;

type NodePtr = Rc<RefCell<Node>>;
type WeakPtr = Weak<RefCell<Node>>;

#[derive(Debug, Default)]
struct Node {
    key: i32,
    value: i32,
    next: Option<NodePtr>,
    prev: Option<WeakPtr>,
}

impl Node {
    fn new(key: i32, value: i32) -> Self {
        Self {
            key, value, 
            next: None, 
            prev: None,
        }
    }
}

struct LRUCache {
    capacity: usize,
    map: HashMap<i32, NodePtr>, 
    head: Option<NodePtr>, 
    tail: Option<NodePtr>,
}

impl LRUCache {
    pub fn new(capacity: i32) -> Self {
        let capacity = capacity as usize;
        let map = HashMap::new();
        let head = None;
        let tail = None;
        Self { capacity, map, head, tail, }
    }

    pub fn get(&mut self, key: i32) -> i32 {
        
        // put put this node to top in linkedList
        // return the list
        match self.map.get(&key) {
            None => -1,
            Some(node) => {
                let node = Rc::clone(&node);
                self.remove(&node);
                self.push_front(&node);
                let value = node.borrow().value;
                value
            }
        }
    }
                
    fn remove(&mut self, node: &NodePtr) {
        match (Rc::clone(&node).borrow().prev.as_ref(), 
               Rc::clone(&node).borrow().next.as_ref())  {
            (Some(prev), Some(next)) => {
                if let Some(prev) = prev.upgrade() {
                    prev.borrow_mut().next = Some(Rc::clone(&next));
                }
                next.borrow_mut().prev = Some(Weak::clone(&prev));
            },
            (None, Some(next)) => {
                self.head = Some(Rc::clone(&next));
                next.borrow_mut().prev = None;
            },
            (Some(prev), None) => {
                if let Some(prev) = prev.upgrade() {
                    self.tail = Some(Rc::clone(&prev));
                    prev.borrow_mut().next = None;
                }
            },
            (None, None) => {
                self.head = None; 
                self.tail = None;
            },
        }
    }

    fn push_front(&mut self, node: &NodePtr) {
        match self.head.take() {
            None => {
                self.head = Some(Rc::clone(node));
                self.tail = Some(Rc::clone(node));
            }, 
            Some(head) => {
                head.borrow_mut().prev = Some(Rc::downgrade(&node));
                node.borrow_mut().next = Some(Rc::clone(&head)); 
                node.borrow_mut().prev = None;
                self.head = Some(Rc::clone(&node));
            }
        };
    }
    fn pop_back(&mut self) -> Option<NodePtr> {
        match self.tail.take() {
            None => None, 
            Some(tail) => {
                self.remove(&tail);
                Some(tail)
            }
        }
    }

    pub fn put(&mut self, key: i32, value: i32) {
        // put this node to the top 
        // if size > capacity then 
        // drop the last node from linkedlist 
        match self.map.get(&key) {
            None => {
                let new_node = Rc::new(RefCell::new(Node::new(key, value)));
                self.push_front(&new_node);
                self.map.insert(key, new_node);
                if self.map.len() > self.capacity {
                    if let Some(evicted_node) = self.pop_back() {
                        self.map.remove(&evicted_node.borrow().key);
                    }
                }
            }, 
            Some(node) => {
                node.borrow_mut().value = value;
                let node = Rc::clone(node);
                self.remove(&node);
                self.push_front(&node);
            }
        }
    }
}
