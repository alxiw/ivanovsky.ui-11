package ru.mail.track.ui11.hw02.task01;

import java.util.Base64;

import javax.crypto.Cipher;

/**
 * Класс, предназначенный для принятия данных из буфера,
 * являющихся экземплярами класса User,
 * обработки определённых полей с помощью шифрования/дешифрования
 * и отправления обработанных данных в другой буфер
 */
public class Coder implements Runnable {

    private boolean isToEncode;

    private Buffer firstBuffer;
    private Buffer secondBuffer;

    private KeyKeeper keyKeeper;

    public Coder (Buffer firstBuffer, Buffer secondBuffer, boolean isToEncode) {
        this.firstBuffer = firstBuffer;
        this.secondBuffer = secondBuffer;
        this.isToEncode = isToEncode;
    }

    @Override
    public void run() {
        keyKeeper = KeyKeeper.getInstance();
        try {
            keyKeeper.prepareKeys();
            System.out.println("KEYS ARE PREPARED");
        } catch (Exception e) {
            System.out.println("ERROR DURING KEY PREPARATION\n" + e.getMessage());
        }

        System.out.println("PROCESSING IS STARTED");
        User user;
        while (true) {
            user = firstBuffer.getQueue();
            if (user != null) {
                if (isToEncode) {
                    try {
                        String line = encodeEmail(user.getEmail());
                        user.setEmail(line);
                    } catch (Exception e) {
                        System.out.println("ERROR DURING EMAIL ENCODING\n" + e.getMessage());
                    }
                    user.setPassword(encodePassword(user.getPassword()));
                } else {
                    try {
                        String line = decodeEmail(user.getEmail());
                        user.setEmail(line);
                    } catch (Exception e) {
                        System.out.println("ERROR DURING EMAIL DECODING\n" + e.getMessage());
                    }
                    user.setPassword(decodePassword(user.getPassword()));
                }
                secondBuffer.addQueue(user);
            } else {
                break;
            }
        }
        System.out.println("PROCESSING IS ENDED");
    }

    // encrypt using RSA private key
    private String encodeEmail(String string) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.keyKeeper.getPublicKey());
        return Base64.getEncoder().encodeToString(cipher.doFinal(string.getBytes()));
    }

    // decrypt using RSA public key
    private String decodeEmail(String string) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.keyKeeper.getPrivateKey());
        return new String(cipher.doFinal(Base64.getDecoder().decode(string)));
    }

    // encode using Base64 scheme
    private String encodePassword(String string) {
        byte[] encodedBytes = Base64.getEncoder().encode(string.getBytes());
        return new String(encodedBytes);
    }

    // decode using Base64 scheme
    private String decodePassword(String string) {
        byte[] decodedBytes = Base64.getDecoder().decode(string);
        return new String(decodedBytes);
    }
}
