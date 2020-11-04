package ru.miit.lab_2.services;

public class VigenereCipher implements IEncryptorable {
    private static String generateKey(String str, String key) {
        int sourceStrLen = str.length();

        StringBuilder keyCopy = new StringBuilder(key);
        for (int i = 0; ; i++) {
            if (sourceStrLen == i)
                i = 0;
            if (keyCopy.length() == str.length())
                break;
            keyCopy.append(keyCopy.charAt(i));
        }
        key = keyCopy.toString();
        return key;
    }

    @Override
    public String encrypt(String str, String key, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        String sourceStrCopy = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            int encryptionPart = (sourceStrCopy.charAt(i) + key.charAt(i)) % 26 + 'A';
            encryptedText.append((char) (encryptionPart));
        }
        return encryptedText.toString();
    }

    public static String originalText(String encryptedText, String key) {
        StringBuilder originText = new StringBuilder();

        for (int i = 0; i < encryptedText.length() && i < key.length(); i++) {
            int decryptionPart = (encryptedText.charAt(i) - key.charAt(i) + 26) % 26 + 'A';
            originText.append((char) (decryptionPart));
        }
        return originText.toString();
    }
}