class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String s: strs){
            encoded.append(s);
            encoded.append("~");
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        //List<String> decoded = new ArrayList<String>(Arrays.asList(str.split("~")));
        List<String> decoded = new ArrayList<>();
        char[] charDecoder = str.toCharArray();
        int s = 0;
        for(int i = 0; i < charDecoder.length; i++){
            if(charDecoder[i] == '~'){
                decoded.add(str.substring(s,i));
                s = i+1;
            }
        }
        return decoded;
    }
}
