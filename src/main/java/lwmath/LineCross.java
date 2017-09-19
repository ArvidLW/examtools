package lwmath;

public class LineCross {
    /*
    * AB本身就是两条直线，知道两端点就可以知道其直线方程，B也是一样，两个方程联立，
    得到一个坐标，再看该坐标是否在B的定义域内就可以啊
    y=ax+b
    y=cx+d
    x=-(b-d)/(a-c) 交点
    y=(b/a-d/c)/(1/a-1/c)
    * */
    public static void main(String[] args) {
        //第一条直线
        double x1 = 10, y1 = 20, x2 = 100, y2 = 200;
        double a = (y1 - y2) / (x1 - x2);
        double b = (x1 * y2 - x2 * y1) / (x1 - x2);
        System.out.println("求出该直线方程为: y=" + a + "x + " + b);

//第二条
        double x3 = 50, y3 = 20, x4 = 20, y4 = 100;
        double c = (y3 - y4) / (x3 - x4);
        double d = (x3 * y4 - x4 * y3) / (x3 - x4);
        System.out.println("求出该直线方程为: y=" + c + "x + " + d);

        double x = ((x1 - x2) * (x3 * y4 - x4 * y3) - (x3 - x4) * (x1 * y2 - x2 * y1))
                / ((x3 - x4) * (y1 - y2) - (x1 - x2) * (y3 - y4));

        double y = ((y1 - y2) * (x3 * y4 - x4 * y3) - (x1 * y2 - x2 * y1) * (y3 - y4))
                / ((y1 - y2) * (x3 - x4) - (x1 - x2) * (y3 - y4));

        System.out.println("他们的交点为: (" + x + "," + y + ")");
    }
}
