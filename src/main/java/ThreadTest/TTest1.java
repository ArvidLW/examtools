package ThreadTest;

import java.util.concurrent.Callable;

public class TTest1 {
    public static void main(String[] args) {

    }
    public synchronized void sMethod(){
//        rea
    }
    public void sMethod1() throws InterruptedException {
        wait();
        notifyAll();
//        read
    }
}
class AsynTest implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}
class ThreadTest implements Runnable{

    @Override
    public void run() {

    }
}
