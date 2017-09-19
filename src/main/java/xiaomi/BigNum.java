package xiaomi;

import java.util.Scanner;
public class BigNum {

    public static void main(String[] args){
        Scanner reader=new Scanner(System.in);
        while (reader.hasNext()){
            String numStr1=reader.next();
            String numStr2=reader.next();

            int[] intNum1=changetoArray(numStr1);
            int[] intNum2=changetoArray(numStr2);

            multiply(intNum1,intNum2);
        }

    }

    public static int[] changetoArray(String numStr){
        int length=numStr.length();
        int[] intNum=new int[length];
        for(int i=0;i<length;i++)
            intNum[length-i-1]=Integer.parseInt(String.valueOf((numStr.charAt(i))));
        return intNum;
    }

    public static int[] multiply(int[] num1,int[] num2){
        int length1=num1.length;
        int length2=num2.length;
        int[] result=new int[length1+length2];
        for(int i=0;i<length1;i++)
            for(int j=0;j<length2;j++){
                int temp = result[i + j] + num1[i] * num2[j];
                result[i + j] = temp % 10;
                result[i + j + 1] += temp / 10;
//                进位，应该可以不要，因为下一次循环会处理。
//                int pos=i+j+1;
//                while (result[pos]>=10){
//                    result[pos]%=10;
//                    ++result[pos+1];
//                    ++pos;
//                }
//                if (result[i + j + 1] > 10) {
//                    result[i + j + 1] %= 10;
//                    result[i + j + 2]++;
//                }
            }
        StringBuffer sb=new StringBuffer();
        if(result[result.length-1]!=0){
            sb.append(result[result.length-1]);
        }
        for(int i=result.length-2;i>=0;--i)
            sb.append(result[i]);
        System.out.println(sb.toString());
        return result;
    }
}