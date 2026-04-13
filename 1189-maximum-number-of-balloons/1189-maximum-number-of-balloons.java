class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> have = new HashMap<>();

        for(char ch: text.toCharArray()){
            have.put(ch,have.getOrDefault(ch,0)+1);
        }

        int b = have.getOrDefault('b',0);
        int a = have.getOrDefault('a',0);
        int l = have.getOrDefault('l',0)/2;
        int o = have.getOrDefault('o',0)/2;
        int n = have.getOrDefault('n',0);

        return Math.min(
                Math.min(b, a),
                Math.min(l, Math.min(o, n))
            );
    }
}