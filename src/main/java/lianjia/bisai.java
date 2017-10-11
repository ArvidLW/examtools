package lianjia;

import java.util.*;
public class bisai
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        StringBuffer stringbuffer = new StringBuffer();
        while(in.hasNext())
        {
            String line = in.nextLine();
            if(line.equals("end")){
                break;
            }
            list.add(line);
        }
        Object[] array = list.toArray();
        Arrays.sort(array);
        for(int k =0;k<array.length;k++){
            stringbuffer.append(array[k]+",");
        }
        String s = stringbuffer.toString();
        System.out.print(s.substring(0,s.length()-1));
    }
}