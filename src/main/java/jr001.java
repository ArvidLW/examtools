import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class jr001 {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> xs = new ArrayList<>();
        ArrayList<Integer> ys = new ArrayList<>();
        jr001 tester = new jr001();


        tester.getInput(xs, ys);
        tester.process(xs, ys);

    }
    void getInput(ArrayList<Integer> xs, ArrayList<Integer> ys){
        String s="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        try {
            s = br.readLine();
            num = Integer.parseInt(s);
            for(int i=0;i < num;i ++){
                String[] point_str = br.readLine().trim().split(" ");
                xs.add(Integer.parseInt(point_str[0]));
                ys.add(Integer.parseInt(point_str[1]));
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    void process(ArrayList<Integer> xs, ArrayList<Integer> ys){
        Map<Integer, Integer> map = new TreeMap<>();
        int size = xs.size();
        ArrayList<Integer> output= new ArrayList<>();
        for(int i=0;i<size;i ++){
            boolean satisfied = true;
            for(int j=i + 1;j<size;j++){
                int p0_x = xs.get(i);int p0_y = ys.get(i);
                int p1_x = xs.get(j);int p1_y = ys.get(j);
                if(p1_x > p0_x && p1_y > p0_y){
                    satisfied = false;
                    break;
                }
            }
            if(satisfied){
                output.add(i);
                map.put(xs.get(i), ys.get(i));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            System.out.println(key + " " + value);
        }
    }


}