package TestHash;

public class HashT {
    public static void main(String[] args) {
        int val=0;
        Integer v=99;
        String s="ww";
        String f="ww";
        String fs=f+s;
        System.out.println(s.hashCode()+" "
                +f.hashCode()+" "
                +fs.hashCode()+" "
                +v.hashCode()
        );
    }
}
