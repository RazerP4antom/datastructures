public class MinPQ {
    // MIN PRIORITY QUEUE

    private Integer[] heap;
    private int n;

    public MinPQ(int capacity){
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(int x){
        if(n == heap.length-1)
            resize(2*heap.length);
        n++;
        heap[n] = x;
        swim(n);
    }

    private void swim(int k) {
        while(k > 1 && heap[k/2] > heap[k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }

    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < heap.length; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void printMinHeap(){
        for(int i = 1; i <= n; i++){
            System.out.print(heap[i] + " ");
        }
    }


    public int deleteMin(){
        int min = heap[1];
        swap(1,n);
        n--;
        sink(1);
        heap[n + 1] = null;

        if(n > 0 && (n == (heap.length -1)/4))
            resize(heap.length/2);
        
        return min;

    }



    private void sink(int i) {
        while(2*i <= n){
            int j = 2*i;
            if(j < n && heap[j] > heap[j+1]){
                j++;
            }
            if(heap[i] <= heap[j]){
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        MinPQ pq = new MinPQ(3);
        pq.insert(4);
        pq.insert(5);
        pq.insert(6);
        pq.insert(1);
        pq.insert(3);
        pq.insert(9);
        pq.insert(0);
        // pq.printMinHeap();
         pq.deleteMin();

         pq.printMinHeap();

    }
    
}
