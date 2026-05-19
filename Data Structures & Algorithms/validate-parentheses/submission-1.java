class Solution {
    public boolean isValid(String s) {
        Deque<Character> par = new ArrayDeque();
        Map<Character, Character> parMap = new HashMap();

        parMap.put('(',')');
        parMap.put('{','}');
        parMap.put('[',']');
        
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(parMap.containsKey(current)){
                par.push(current);
            }else{
                if(!par.isEmpty()){
                    char matcher = par.pop();
                    if(parMap.get(matcher) != current) return false;
                }else return false;
            }
        }
        if(par.isEmpty()) return true;
        return false;
    }
}
