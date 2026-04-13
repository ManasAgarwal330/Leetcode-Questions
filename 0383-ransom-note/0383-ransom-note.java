class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> have = new HashMap<>();
        HashMap<Character,Integer> required = new HashMap<>();

        for(char ch: ransomNote.toCharArray()){
            required.put(ch,required.getOrDefault(ch,0)+1);
        }

        for(char ch: magazine.toCharArray()){
            have.put(ch,have.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry: required.entrySet()){
            if(have.getOrDefault(entry.getKey(),0) < entry.getValue())return false;
        }

        return true;
    }
}