import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;

public class OutPutTest {
    public static void main(String[] args) {
        double x=3.3333;
        float y=2.2222F;
        System.out.println(String.format("%.2f",x));
        System.out.println(new Formatter().format("%.3f",y));
        System.out.println(new DecimalFormat(".00").format(x));
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(x));
        System.out.println(new BigDecimal(x).setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println(x);
        System.out.println(y);
        System.out.printf("%.1f\n",x);
    }
}
