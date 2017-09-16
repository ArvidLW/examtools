package T58;


public class test {
    public static void main(String[] args) {
        //1、
        // 为58的阶乘个数
        // 单位为1的为58^2
        // 为2的为(58-1)^2，每次可以从横纵中各选连续两个，以此类推。
        // 一共为66729个
        int n=58;
        int total=0;
        for(int i=1;i<=n;++i){
            total+=i*i;
        }
        System.out.println(total);
    }
}
