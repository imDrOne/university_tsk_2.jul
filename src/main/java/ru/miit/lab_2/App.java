package ru.miit.lab_2;import org.jboss.weld.environment.se.Weld;import org.jboss.weld.environment.se.WeldContainer;import ru.miit.lab_2.clients.ClientCipher;import ru.miit.lab_2.services.AffineCipher;import ru.miit.lab_2.services.CaesarCipher;import ru.miit.lab_2.services.VigenereCipher;public class App {    public static void main(String[] args) {        Weld weld = new Weld();        WeldContainer container = weld.initialize();        String str = "GEEKSFORGttKS";        String keyword = "AYUSH";        ClientCipher clientCipher = container.select(ClientCipher.class).get();        String result = clientCipher.encrypt(str, keyword, 4);        System.out.println("Affine result: " + result);//        VigenereCipher vigenereCipher = new VigenereCipher();//        String key = VigenereCipher.generateKey(str, keyword);//        String cipherText  = vigenereCipher.encrypt(str, key, 0);////        System.out.println("Ciphertext : " + cipherText + "\n");//        System.out.println("Original/Decrypted Text : " + VigenereCipher.originalText(cipherText, key));//        AffineCipher affineCipher = new AffineCipher();//        String cipherText = affineCipher.encrypt(str, "", 0);//        System.out.println("Encrypted Message is : " + cipherText);//        CaesarCipher caesarCipher = new CaesarCipher();//        System.out.println("Cipher: " + caesarCipher.encrypt(str, "", 4));        container.shutdown();    }}