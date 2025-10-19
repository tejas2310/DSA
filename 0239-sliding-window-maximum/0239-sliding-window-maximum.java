class RequestHolder {
        final int value;
        final int index;

        public RequestHolder(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }


    class MonotonicQueue {
        private Deque<RequestHolder> queue;

        public MonotonicQueue() {
            queue = new ArrayDeque<>();
        }

        public void addElement(int value, int index) {
            while (!queue.isEmpty() && queue.peekLast().getValue() <= value) {
                queue.pollLast();
            }
            queue.offerLast(new RequestHolder(value, index));
        }

        public int getMaxOfWindow(int windowStart) {
            // Remove elements out of current window
            while (!queue.isEmpty() && queue.peekFirst().getIndex() < windowStart) {
                queue.pollFirst();
            }
            return queue.peekFirst().getValue();
        }
    }

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums == null || nums.length == 0 || k == 0)
                return new int[0];

            int[] result = new int[nums.length - k + 1];
            MonotonicQueue mq = new MonotonicQueue();

            for (int i = 0; i < nums.length; i++) {
                mq.addElement(nums[i], i);
                int windowStart = i - k + 1;
                if (windowStart >= 0) {
                    result[windowStart] = mq.getMaxOfWindow(windowStart);
                }
            }
            return result;
        }
    }