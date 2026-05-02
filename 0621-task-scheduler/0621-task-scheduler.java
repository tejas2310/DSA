class Solution {

    class Task {
        char ch;
        int freq;
        Task(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Task> pq = new PriorityQueue<>(
                (a, b) -> b.freq - a.freq
        );

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                pq.offer(new Task((char)('A' + i), freq[i]));
            }
        }

        int result = 0;

        while(!pq.isEmpty()) {
            int count = n + 1;
            List<Task> temp = new ArrayList<>();

            while(count > 0 && !pq.isEmpty()) {
                Task curr = pq.poll();
                curr.freq--;

                if(curr.freq > 0) temp.add(curr);
                count--;
                result++;
            }

            for(Task t : temp) pq.offer(t);

            if(pq.isEmpty()) break;

            result += count; // idle time
        }

        return result;
    }
}