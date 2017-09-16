public class FunCode {
    public void test(){
        Runnable runnable = () -> {
            System.out.println("Hello World!");
        };
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }
}
