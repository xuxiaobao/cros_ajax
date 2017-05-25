/**
 * Created by Administrator on 2017/5/25.
 */
public class MyRunnable implements Runnable {
    final private String a;
    public MyRunnable(String a) {
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println(this.a);
    }
}
