package sword2offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question41 {

    class MedianFinder {
        // 一个最大堆，一个最小堆实现

        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;
        int count = 0;

        public MedianFinder() {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }

        public void addNum(int num) {
            count++;
            // 偶数时插入最小堆
            if (count % 2 == 0) {
                // 保证最大堆中的数据要小于最小堆中的数据
                if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                    maxHeap.add(num);
                    num = maxHeap.poll();
                }
                minHeap.add(num);
            } else {
                if (!minHeap.isEmpty() && minHeap.peek() < num) {
                    minHeap.add(num);
                    num = minHeap.poll();
                }
                maxHeap.add(num);
            }

        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else if(minHeap.size() > maxHeap.size()){
                return minHeap.peek() / 1.0;
            } else {
                return maxHeap.peek() / 1.0;
            }
        }

    }

}
