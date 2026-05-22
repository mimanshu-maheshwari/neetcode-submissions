class FreqStack {
    HashMap<Integer,Integer> map;
    HashMap<Integer,Stack<Integer>> group;
    int max;
    public FreqStack() {
        map = new HashMap<>();
        group = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        int k = map.getOrDefault(val,0) + 1;
        map.put(val,k);

        if(k > max){
            max = k;
        }

        if(!group.containsKey(k)){
            group.put(k,new Stack<>());
        }
        group.get(k).push(val);
    }
    
    public int pop() {
        int val = group.get(max).pop();

        map.put(val,map.getOrDefault(val,0)-1);

        if(group.get(max).isEmpty()){
            max--;
        }

        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */