class Solution {
    public class Task{
        char ch;
        int occurence;
        int time ;
        public Task(char ch, int occurence,int time){
            this.ch = ch;
            this.occurence = occurence;
            this.time = time;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(Character ch: s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a,b) -> b.occurence-a.occurence);
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            maxHeap.add(new Task(entry.getKey(),entry.getValue(),0));
        }

        Queue<Task> cooldown = new LinkedList<>();
        StringBuilder st = new StringBuilder();
        int time = 0;
        while(!maxHeap.isEmpty() || !cooldown.isEmpty())
        {   
            time++;
            if(!maxHeap.isEmpty()){
                Task t = maxHeap.poll();
                char last = st.length() == 0 ? ' ' : st.charAt(st.length()-1);
                System.out.print(t.ch);
                if(t.ch == last){
                    return "" ;
                }else{
                    t.occurence -= 1;
                    t.time = time;
                    st.append(t.ch);
                }

                if(t.occurence > 0){
                    cooldown.add(t);
                }
            }

            if(!cooldown.isEmpty() && cooldown.peek().time == time-1 ){
                Task t = cooldown.poll();
                maxHeap.add(t);
            }
        }

        return st.toString();
    }
}