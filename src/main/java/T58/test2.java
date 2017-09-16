package T58;

public class test2 {
    //程序的效果就是统计传入的参数的二进制表示中1的个数
    public static void main(String[] args) {
        test2 test22=new test2();
        int a=test22.methodA(5858);
        System.out.println(a);
    }
    public int methodA(int n){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            System.out.println(n);
            count++;
        }
        return count;
    }
}
