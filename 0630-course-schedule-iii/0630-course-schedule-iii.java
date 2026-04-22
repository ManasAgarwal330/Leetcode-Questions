class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) -> a[1] == b[1] ? a[0]-b[0] : a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        int courseTaken = 0;
        for(int[] course:courses){
            if(course[0]+ time <= course[1]){
                maxHeap.add(course[0]);
                time += course[0];
                courseTaken++;
            }else{
                if(!maxHeap.isEmpty()){
                    var duration = maxHeap.poll();
                    if(duration > course[0] && ((time - duration) + course[0]) <= course[1])
                    {
                        time = (time - duration) + course[0];
                        maxHeap.add(course[0]);
                    }else{
                        maxHeap.add(duration);
                    }
                }
            }
        }

        return courseTaken;
    }
}