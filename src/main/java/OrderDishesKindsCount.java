import java.util.Scanner;

public class OrderDishesKindsCount {
    /*
    * 思想：可以看成是一个二分图，然后由上至下的进行交替路
    * 实施：构造棵树，源节点s连接1,2,3,4,5,...,m;每个子节点下连接比它编号大的数作为孩子。
    * 从源节点深度遍历每一个分支，当菜品等于wantCount,且价格小于maxMoney即以可选方案，方案数加1。
    * 最坏时间复杂度：排序组合数，c(n,k)=n!/((n-k)!*k!)
    * 空间复杂度:o(1)
    * */
    static int maxMoney=0;
    static int wantCount=0;
    static int count=0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            count=0;
            maxMoney=in.nextInt();
            wantCount=in.nextInt();
            int dishesCount=in.nextInt();
            int[] dishes=new int[dishesCount];
            for (int i=0;i<dishesCount;++i){
                dishes[i]=in.nextInt();
            }
            System.out.println(getCount(dishes));
        }
    }
    static int getCount(int[] dishes){
        int n=0;
        //从根节点出发，深度遍历子树
        for(int i=0;i<dishes.length;++i){
            chooseDishes(1,i,dishes[i],dishes);
        }
        return count;
    }
    //递归
    static void chooseDishes(int num,int index,int money,int[] dishes){
        //判段是否超出预算
        if(money>maxMoney){
            return;
        }
        //判断是超过数量
        if(num>=wantCount){
            ++count;
            return;
        }
        for(int i=index+1;i<dishes.length;++i){
            chooseDishes(num+1,i,money+dishes[i],dishes);
        }
    }
}
