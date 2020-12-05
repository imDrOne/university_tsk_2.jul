package ru.miit.lab_2.clients;

import ru.miit.lab_2.services.IEncryptorable;

import javax.inject.Inject;

public class ClientCipher {
    private IEncryptorable refEncryptorable;

    @Inject
    public ClientCipher(IEncryptorable refEncryptorable) {
        this.refEncryptorable = refEncryptorable;
    }

    public String encrypt(String str, String key) {
        return refEncryptorable.encrypt(str, key);
    }
}
