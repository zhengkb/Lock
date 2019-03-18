package zkb.basic.moshi;

public class Test {
    public static void main(String[] args) {
        Storage storage=new Storage();
        for(int i=1;i<60;i++) {
            int finali=i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    storage.produce(String.format("生产者 %d ", finali));

                }
            }).start();
        }
        for(int i=1;i<60;i++) {
            int finali=i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    storage.consume(String.format("消费者 %d ", finali));

                }
            }).start();
        }
    }
}
