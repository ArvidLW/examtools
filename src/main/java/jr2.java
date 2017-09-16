import java.util.Scanner;
public class jr2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            int[][] idea=new int[p][4];
            for(int i=0;i<p;++i){
                for (int j=0;j<4;++j){
                    idea[i][j]=in.nextInt();
                }
            }
            //和优先级没有关系
            //只需要比较两条线，谁短就把任务给谁
            //涉及序号则先选最小的
            int[] flag=new int[m];
            int line1=0;
            int line2=0;
            for(int i=0;i<p;++i){
                int index=0;
                int beg=idea[0][1];
                int use=idea[0][3];
                for(int j=0;j<p;++j){
                    if(beg<idea[j][1]){
                        index=1;
                    }
                }

            }

        }
    }
}