package ThreadTest;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
    private List queue=new LinkedList<>();
    private int limit=10;

    public BlockingQueue(int limit){
        this.limit=limit;
    }
    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size()==this.limit){
            wait();
        }
        if(this.queue.size()==0){
            notifyAll();
        }
        this.queue.add(item);
    }
    public synchronized void dequeue() throws InterruptedException {
        while (this.queue.size()==0){
            wait();
        }
        if(this.queue.size()==this.limit){
            notifyAll();
        }
        this.queue.remove(0);
    }
    public void test(){
        BlockingQueue queue=new BlockingQueue(10);
    }
}
