
import java.text.SimpleDateFormat;

public class NewClass1 {
    public static void main(String[] args) {
        String test = "(`Id`, `Invoice_No`, `Bill_amt`, `Recieved_Amt`, `balance`, `Invoice_date`, `Invoice_By`, `isUsed`)";
        

 test = test.replace("`", "");
        test = test.replace(", ", ",");
       
        System.out.println(test);
        
    
    }
}
