package ru.miit.lab_2.services;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.Scanner;

@Decorator
public class CaesarCipher implements IEncryptorable {
    @Inject
    @Delegate
    IEncryptorable ref;

    @Override
    public String encrypt(String str, String key) {
        System.out.println("Before Affine starts Caesar cipher");
        System.out.println("Enter shift level: ");
        Scanner scanner = new Scanner(System.in);

        int shift = scanner.nextInt();

        StringBuilder tempResult = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                char ch = (char) (((int) str.charAt(i) +
                        shift - 65) % 26 + 65);
                tempResult.append(ch);
            } else {
                char ch = (char) (((int) str.charAt(i) +
                        shift - 97) % 26 + 97);
                tempResult.append(ch);
            }
        }
        System.out.println("Caesar cipher result: " + tempResult);

        return ref.encrypt(tempResult.toString(), key);
    }
}
