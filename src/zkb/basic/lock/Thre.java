package zkb.basic.lock;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Thre{
    private AtomicLong count=new AtomicLong(0);
    private void add10k(){
        int idx=0;
        while(idx++<10000) {
            System.out.println(count.getAndAdd(1));
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thre t=new Thre();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                t.add10k();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                t.add10k();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(t.count);
    }

}
