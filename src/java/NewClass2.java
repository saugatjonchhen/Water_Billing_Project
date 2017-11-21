
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewClass2 {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yyyy");
        java.util.Date date = new java.util.Date();
        String frmtdDate = dateFormat.format(date);
        System.out.println(frmtdDate);
        System.out.println("");
        
        
        String BillName = "Feb-2017";
        try {
            Date parse = dateFormat.parse(BillName);
            parse.setMonth(parse.getMonth()+1);
            System.out.println(dateFormat.format(parse));
        } catch (Exception e) {
        }
    }
}
