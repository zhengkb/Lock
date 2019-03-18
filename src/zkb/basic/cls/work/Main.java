package zkb.basic.cls.work;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int num=scan.nextInt();
        long[][] narr=new long[num][3];
        for(int i=0;i<num;i++){
            for(int j=0;j<3;j++){
                narr[i][j]=scan.nextLong();
            }
        }
        for(int i=0;i<num;i++){
            System.out.println("Case #"+(i+1)+":"+(narr[i][0]+narr[i][1]>narr[i][2]));
        }
    }
}
