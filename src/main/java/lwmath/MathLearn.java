package lwmath;

import java.util.Date;
import java.util.Random;

public class MathLearn {
    public double test(){
        double random = Math.random();//返回0到1的小数
        System.out.println(random);
        System.out.println(new Date().getTime());
        Random rand = new Random(new Date().getTime());
        random=rand.nextInt(100);
        return random;
    }
    /**
     * 利用牛顿法求函数的根
     * *函数在整个定义域内最好是二阶可导的
     * *起始点对求根计算影响重大，可以增加一些别的判断手段进行试错
     * 例：求x^2=100
     * 原理：y=x^2-100的平方与x坐标轴的交点。
     * 公式：f(x)=f(x0)+f'(x0)(x-x0)
     * 即当f(x)=0时有，x=x0-f(x0)/f'(x0)
     * 对于y=x^2-100即为x=x0-(x0^2-100)/(2*x0)
     * 对于y=x^2-n即为x=x0-(x0^2-n)/(2*x0)=x0/2 + n/(2*x0)=(x0+n/x0)/2
     * 求一元n次函数也是一样的
     */
    /**
     * 补充说明：
     * 对于给定数求开方，转化为函数求根。
     * 例 x^2=n;
     * 表达式：f(x)=x^2-n;    ....1
     * 画出函数图像
     * 找一点(x0,y0)得到其切线函数：f(x)-f(x0)=f'(x0)(x-x0)
     * 切线与x轴交点x=x0-f(x0)/f'(x0)
     * 求得的x1带入原方程 1中，重复上面两步，直到其x1^2-n=0在一个误差范围为止。
     * @param n
     * @return
     */
    public double getRoot(double n){
        double k=n/2;
        while (Math.abs(k*k-n)>1e-9){
            k=(k+n/k)/2;
        }
        return k;
    }
}