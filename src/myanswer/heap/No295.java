package myanswer.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @FileName: No295.java
 * @Description: 数据流的中位数
 * @Author: admin
 * @Date: 2020/11/14 7:39
 */
public class No295 {

    class MedianFinder {

        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (minHeap.size() == 0) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.offer(num);
                adjustSize();
            } else {
                maxHeap.offer(num);
                adjustSize();
            }
        }

        private void adjustSize() {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            } else if (minHeap.size() < maxHeap.size()) {
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                return 0.0;
            }
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek() + 0.0) / 2;
            } else if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }

    public static void main(String[] args) {
        No295 no295 = new No295();
        MedianFinder medianFinder = no295.new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        double res = medianFinder.findMedian();
        System.out.println(res);
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());

    }

}
