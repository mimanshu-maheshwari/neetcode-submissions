// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//     pub val: i32,
//     pub next: Option<Box<ListNode>>,
// }
//
// impl ListNode {
//     #[inline]
//     pub fn new(val: i32) -> Self {
//         ListNode { next: None, val }
//     }
// }
type Node = Box<ListNode>;

impl Solution {
    pub fn reorder_list(head: &mut Option<Node>) {
        if head.is_none() || head.as_ref().unwrap().next.is_none() {
            return;
        }

        let second = Self::split_at_middle(head);
        let mut second = Self::reverse(second);
        Self::interleave(head, &mut second);
    }

    fn split_at_middle(head: &mut Option<Node>) -> Option<Node> {
        // Compute length
        let mut len = 0;
        let mut cur = head.as_ref();

        while let Some(node) = cur {
            len += 1;
            cur = node.next.as_ref();
        }

        // First half gets the extra node when len is odd.
        let split_idx = (len + 1) / 2;

        let mut cur = head;

        for _ in 0..split_idx - 1 {
            cur = &mut cur.as_mut().unwrap().next;
        }

        cur.as_mut().unwrap().next.take()
    }

    fn reverse(mut head: Option<Node>) -> Option<Node> {
        let mut prev = None;

        while let Some(mut node) = head {
            head = node.next.take();
            node.next = prev;
            prev = Some(node);
        }

        prev
    }

    fn interleave(l1: &mut Option<Node>, l2: &mut Option<Node>) {
        let mut p1 = l1;

        while let Some(mut node2) = l2.take() {
            *l2 = node2.next.take();

            let node1 = p1.as_mut().unwrap();

            let next1 = node1.next.take();

            node2.next = next1;
            node1.next = Some(node2);

            p1 = &mut node1.next.as_mut().unwrap().next;
        }
    }
}