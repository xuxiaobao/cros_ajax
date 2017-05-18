/**
 * Created by Administrator on 2017/5/18.
 */
public class Test {
    public static void main(String[] args) {
        try {
            int a = 1/0;
        } catch (Exception e) {
            System.out.println("exception");
            return;
        } finally {
            System.out.println("end");
        }

        System.out.println("other");
    }
}
