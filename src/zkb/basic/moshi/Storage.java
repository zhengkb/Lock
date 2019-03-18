package zkb.basic.moshi;

import java.util.LinkedList;

public class Storage {
    private final int MAX_SIZE=10;
    private LinkedList<Object> list=new LinkedList<>();

    public void produce(String produce) {
        synchronized (list) {
            while(list.size()==MAX_SIZE) {
                System.out.println("已无法再生产新产品，内部已满");
                try {
                    list.wait();
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println(produce+"，开始生产，现有产品 "+list.size());
            list.notifyAll();
        }
    }

    public void consume(String consumer) {
        synchronized (list) {
            while(list.size()==0) {
                System.out.println("内部已无产品，无法进行消费");
                try {
                    list.wait();
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove();
            System.out.println(consumer+"，开始消费，现有产品"+list.size());
            list.notifyAll();
        }
    }

//	public void setList(LinkedList<Object> list) {
//		this.list=list;
//	}
//
//	public int getMAX_SIZE() {
//		return MAX_SIZE;
//	}
//
//	public LinkedList<Object> getList(){
//		return list;
//	}

}
