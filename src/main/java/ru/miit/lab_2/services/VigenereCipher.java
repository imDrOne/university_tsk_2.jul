package ru.miit.lab_2.services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Decorator
public class VigenereCipher implements IEncryptorable {
    @Inject
    @Delegate
    IEncryptorable ref;

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
    public String encrypt(String str, String key) {
        System.out.println("Before Affine starts Vigenere cipher");

        StringBuilder tempResult = new StringBuilder();
        String sourceStrCopy = str.toUpperCase();
        String generatedKey = generateKey(str, key);

        System.out.println("New key: " + generatedKey);

        for (int i = 0; i < str.length(); i++) {
            int encryptionPart = (sourceStrCopy.charAt(i) + generatedKey.charAt(i)) % 26 + 'A';
            tempResult.append((char) (encryptionPart));
        }


        return ref.encrypt(tempResult.toString(), generatedKey);
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
