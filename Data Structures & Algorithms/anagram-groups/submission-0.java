class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<Integer>> grams = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String sString = new String(sorted);
            if(grams.containsKey(sString)){
                List<Integer> mod = grams.get(sString);
                mod.add(i);
                grams.put(sString, mod);
            }else{
                ArrayList<Integer> mod = new ArrayList<>();
                mod.add(i);
                grams.put(sString, mod);
            }
            
        }
        List<List<String>> ret = new ArrayList<>();
        for(List<Integer> v: grams.values()){
            List<String> anagramSet = new ArrayList<>();
            for(Integer index: v){
                anagramSet.add(strs[index]);
            }
            ret.add(anagramSet);
        }
        return ret;
    }
}
