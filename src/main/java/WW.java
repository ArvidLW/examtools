//
//import java.util.Scanner;
//public class WW {
///** 请完成下面这个process函数，实现题目要求的功能 **/
//    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
//    private static int process(int itemNum , Model[] items , Model box_Template )
//    {
//        int Min_num = 0 ;//用来记录所需要使用的箱子数量
//        int curcost = 0; //用来记录当前累加的商品的价格
//        if(itemNum > 10)
//        {
//            return -1;
//        }
//        for(int j = 0 ; j < itemNum ; j++)
//        {
//            if(items[j].length > box_Template.length || items[j].width > box_Template.width || items[j].height > box_Template.height)
//            {
//                return -1;
//            }
//            if(curcost == 0)
//            {
//                Min_num++;
//                curcost += items[j].price;
//            }
//            if(curcost < 2000)
//            {
//                curcost += items[j].price;
//            }
//            if(curcost > 2000)
//            {
//                Min_num++;
//                curcost -= 2000;
//            }
//        }
//        return Min_num;
//    }
//    public static void main(String args[]){
//        Scanner scanner = new Scanner(System.in);
//        Model box_Template = new Model(2000 , 0 , 0 , 0);
//
//
//        while (scanner.hasNext()){
//            box_Template.length = scanner.nextInt();
//            box_Template.width = scanner.nextInt();
//            box_Template.height = scanner.nextInt();
//
//            int itemNum = scanner.nextInt();//输入购买的商品个数
//            Model[] items = new Model[itemNum];
//            for(int i=0; i<itemNum; i++){
//                Model item = new Model(0,0,0,0);
//                item.price = scanner.nextInt();
//                item.length = scanner.nextInt();
//                item.width = scanner.nextInt();
//                item.height = scanner.nextInt();
//                items[i] = item;
//            }
//
//
//            System.out.println (process(itemNum , items , box_Template ));
//
//        }
//    }
//}//class
//
//class Model
//{
//    int price;
//    int length;
//    int width;
//    int height;
//    Model(int price , int length , int width , int height)
//    {
//        this.price = price;
//        this.length = length;
//        this.width = width;
//        this.height = height;
//    }
//}
