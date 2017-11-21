import com.system.connection.EncryptionDecryption;

public class NewClass {
    public static void main(String[] args) {
        String encrypt = EncryptionDecryption.encrypt("tes.1.");
        System.out.println(encrypt);
        System.out.println(EncryptionDecryption.decrypt(encrypt));
    }
}
