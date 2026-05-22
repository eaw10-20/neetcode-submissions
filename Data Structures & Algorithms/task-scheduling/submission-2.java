class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();

        //add count of values to map
        for(char task: tasks){
            if(map.containsKey(task)){
                int count = map.get(task);
                map.put(task,count+1);
            }
            else map.put(task,1);
        }

        //add values to max heap
        Set<Character> set = map.keySet();
        Queue<CountOfVal> valueCount = new PriorityQueue<>((a,b) -> b.count - a.count);
        for(Character s: set){
            valueCount.add(new CountOfVal(map.get(s),s));
        }

        //loop while queue > 0
        int cycles = 0;
        while(valueCount.size()>0){
            //loop for length of n
            List<CountOfVal> storage = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                if(valueCount.size() > 0){
                    CountOfVal v = valueCount.poll();
                    v.dec();
                    if(v.count > 0) storage.add(v);
                    cycles++;
                }
                else if(storage.size() != 0) cycles++;
            }
            for(CountOfVal s: storage){
                valueCount.add(s);
            }
        }
        return cycles;
    }
}

class CountOfVal{
    public int count;
    public char val;

    public CountOfVal(){

    }

    public CountOfVal(int c, char v){
        count = c;
        val = v;
    }

    public void dec(){
        count -=1;
    }
}
