class Solution {

    class Task {
        char ch;
        int count;

        Task(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap (based on count)
        PriorityQueue<Task> maxHeap = new PriorityQueue<>(
            (a, b) -> b.count - a.count
        );

        for (char ch : map.keySet()) {
            maxHeap.add(new Task(ch, map.get(ch)));
        }

        // Step 3: Cooldown queue -> (task, availableTime)
        Queue<int[]> cooldown = new LinkedList<>();
        // int[] = {remainingCount, availableTime}

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // Step 4: If heap has task → execute
            if (!maxHeap.isEmpty()) {
                Task current = maxHeap.poll();

                current.count--;

                // Put into cooldown if still remaining
                if (current.count > 0) {
                    cooldown.add(new int[]{current.count, time + n});
                }
            }

            // Step 5: Check if any task is ready from cooldown
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                int[] ready = cooldown.poll();
                maxHeap.add(new Task('X', ready[0])); // char doesn't matter
            }
        }

        return time;
    }
}