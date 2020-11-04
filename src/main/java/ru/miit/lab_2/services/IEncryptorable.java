package ru.miit.lab_2.services;

public interface IEncryptorable {
    String encrypt(String str, String key, int shift);
}
