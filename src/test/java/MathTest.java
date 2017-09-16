import org.junit.Test;
public class MathTest {
//    MathLearn ml=new MathLearn();
//    @Test
//    public void testTest(){
//        double test = ml.test();
//        System.out.println(test);
//    }
//    @Test
//    public void getRootTest(){
//        double root = ml.getRoot(100);
//        System.out.println(root);
//    }
    @Test
    public void ss(){
        String s1="bigdata";
        String s2="big"+"data";
        String s3="big"+new String("data");
        System.out.println((s1==s2)+","+(s1==s3)+(s2==s3));
    }


}
