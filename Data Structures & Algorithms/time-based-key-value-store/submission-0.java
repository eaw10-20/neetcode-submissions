class TimeMap {

    private HashMap<String,TreeMap> time;

    public TimeMap() {
        time = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer,String> valMap;
        if(time.containsKey(key)){
            valMap = time.get(key);
            valMap.put(timestamp,value);
        }else{
            valMap = new TreeMap<>();
            valMap.put(timestamp,value);
            time.put(key,valMap);
        }
        
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer,String> valMap = time.get(key);
        if(valMap == null || valMap.floorEntry(timestamp) == null) return "";
        return valMap.floorEntry(timestamp).getValue();
    }
}

// HashMap (key,TreeMap)
// TreeMap (timestamp,value)