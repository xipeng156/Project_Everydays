package day0504;

public class VolatileTest {
    boolean a = false;
    //boolean flag = false;
    public void write(){
        this.a = true;

    }
    public boolean read(){
//        System.out.println(a);
        return a;
    }
    public static void main(String[] args) {
        VolatileTest vt = new VolatileTest();
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(10);
                vt.write();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vt.write();
        },"t1");
        Thread t2 = new Thread(()->{
            while(true){
//                System.out.println("=====");//为什么这里有这个数据，下面的if就会执行，没这个输出，下面的if就不会执行
                if(vt.read()){
                    System.out.println("read----");
                }
            }
        },"t2");

        t1.start();
        t2.start();
//        t1.run();
//        t2.run();
    }
}
