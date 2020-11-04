package ru.miit.lab_2.services;

public class AffineCipher implements IEncryptorable {
    static int a = 17;
    static int b = 20;

    @Override
    public String encrypt(String str, String key, int shift) {
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                cipher.append((char) ((((a * (str.charAt(i) - 'A')) + b) % 26) + 'A'));
            } else {
                cipher.append(str.charAt(i));
            }
        }
        return cipher.toString();
    }
}
