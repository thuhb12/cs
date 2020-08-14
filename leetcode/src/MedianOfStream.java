import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
295. Find Median from Data Stream
 */
public class MedianOfStream {
    class MedianFinder {

        Queue<Integer> minHeap;
        Queue<Integer> maxHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1 - integer;
                }
            });
        }

        public void addNum(int num) {
            if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if (maxHeap.size() - minHeap.size() >= 2) {
                minHeap.add(maxHeap.peek());
                maxHeap.poll();
            } else if (minHeap.size() - maxHeap.size() >= 2) {
                maxHeap.add(minHeap.peek());
                minHeap.poll();
            }
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else if (maxHeap.size() < minHeap.size()) {
                return minHeap.peek();
            }
            return (maxHeap.peek() + minHeap.peek() + 0.0)/2;
        }
    }
}
