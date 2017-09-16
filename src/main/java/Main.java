import java.lang.management.MonitorInfo;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
class BoxTemplate{
    int price;
    int length;
    int width;
    int height;
    BoxTemplate(){

    }
}
//class Model implements Comparable{
class Model{
    int price;
    int length;
    int width;
    int height;
    Model(){

    }
//    @Override
//    public int compareTo(Object o) {
//        if(price< ((Model)o).price)
//            return -1;
//        return 1;
//    }
}
class PriceComparator implements Comparator{
    public int compare(Object o1, Object o2) {
        if(((Model)o1).price < ((Model)o2).price ){
            return -1;
        }
        return 1;
    }
}
class LenComparator implements Comparator{
    public int compare(Object o1, Object o2) {
        if(((Model)o1).length < ((Model)o2).length ){
            return -1;
        }
        return 1;
    }
}
class WidComparator implements Comparator{
    public int compare(Object o1, Object o2) {
        if(((Model)o1).width < ((Model)o2).width ){
            return -1;
        }
        return 1;
    }
}
class HeiComparator implements Comparator{
    public int compare(Object o1, Object o2) {
        if(((Model)o1).height < ((Model)o2).height ){
            return -1;
        }
        return 1;
    }
}
public class Main {
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    private static int process(BoxTemplate b,Model[] m)
    {
        //选择能装下的最大价值
        int total=0;
        List<Model> inBox=new ArrayList<Model>();
        for(int i=0;i<m.length;++i){
            if(total<b.price){
                total+=m[i].price;
                inBox.add(m[i]);
            }
        }
        //检查尺寸是否能装下
        Object[] inBoxM= inBox.toArray();
        Arrays.sort(inBoxM,new PriceComparator());
        Arrays.sort(inBoxM,new LenComparator());
        Arrays.sort(inBoxM,new WidComparator());
        Arrays.sort(inBoxM,new HeiComparator());

        int alLen=0;
        int alWid=0;
        int alHei=0;
        int flag=0;//表示能装下
        for(int i=0;i<inBoxM.length;++i){
            if(alLen<b.length&&alWid<b.width&&alHei<b.height){
                alLen+=((Model)inBoxM[i]).length;
                alWid+=((Model)inBoxM[i]).width;
                alLen+=((Model)inBoxM[i]).height;
            }else {
                flag=1;//表示没装下
                break;
            }
        }
        if(flag==1){
            //进行下一步的动态规划
            return 0;
        }
        return total;

    }

    public static void main(String args[]){
        BoxTemplate boxTemplate=new BoxTemplate();
        Scanner scanner = new Scanner(System.in);
        boxTemplate.price = 2000;

        while (scanner.hasNext()){
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            Model[] items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            Arrays.sort(items,new PriceComparator());
            /*for(int i=0;i<items.length;++i){
                System.out.println(items[i].price);
            }*/
            long startTime = System.currentTimeMillis();
            int boxMinNum = Integer.MAX_VALUE;
            System.out.println (process(boxTemplate,items));
        }
    }

}