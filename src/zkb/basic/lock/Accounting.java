package zkb.basic.lock;

public class Accounting implements Runnable{
    boolean quit=false;
    int i=0;
    public void run(){
        while(!quit){
            i++;
            System.out.println(i);
        }
        System.out.println("线程退出！");
    }

    public static void main(String[] args) throws InterruptedException{
        Accounting accounting=new Accounting();
        Thread t1=new Thread(accounting,"a1");
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    System.out.println("开始通知线程结束");
                    accounting.setQuit(true);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public boolean isQuit(){
        return quit;
    }
}
