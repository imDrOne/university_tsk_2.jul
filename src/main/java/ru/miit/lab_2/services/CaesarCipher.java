package ru.miit.lab_2.services;

public class CaesarCipher implements IEncryptorable {
    @Override
    public String encrypt(String str, String key, int shift) {
        StringBuilder tempResult = new StringBuilder();

        for (int i=0; i<str.length(); i++)
        {
            if (Character.isUpperCase(str.charAt(i)))
            {
                char ch = (char)(((int)str.charAt(i) +
                        shift - 65) % 26 + 65);
                tempResult.append(ch);
            }
            else
            {
                char ch = (char)(((int)str.charAt(i) +
                        shift - 97) % 26 + 97);
                tempResult.append(ch);
            }
        }

        return new String(tempResult.toString());
    }
}
