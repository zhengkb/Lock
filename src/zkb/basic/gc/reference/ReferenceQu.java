package zkb.basic.gc.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class ReferenceQu {
    public static void main(String[] args){
        ReferenceQueue<ReferenceQu> rq=new ReferenceQueue<>();
        ReferenceQu re=new ReferenceQu();
        SoftReference sr=new SoftReference(re,rq);
        SoftReference ref=null;
        System.gc();
        while((ref=(SoftReference) rq.poll())!=null){
            ref.clear();
            System.out.println("ok");
        }
    }
}
