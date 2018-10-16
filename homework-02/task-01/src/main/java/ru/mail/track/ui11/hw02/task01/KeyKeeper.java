package ru.mail.track.ui11.hw02.task01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Класс, предназначенный для управления ключами, применяемыми
 * в шифровании и расшифровании с помощью алгоритма RSA
 */
public class KeyKeeper {

    private static volatile KeyKeeper instance;

    public static KeyKeeper getInstance() {
        KeyKeeper localInstance = instance;
        if (localInstance == null) {
            synchronized (KeyKeeper.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new KeyKeeper();
                }
            }
        }
        return localInstance;
    }

    private static final String BEGIN_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----";
    private static final String END_PRIVATE = "-----END RSA PRIVATE KEY-----";
    private static final String BEGIN_PUBLIC = "-----BEGIN RSA PUBLIC KEY-----";
    private static final String END_PUBLIC = "-----END RSA PUBLIC KEY-----";

    private static final String SLASH = "/";

    private static final String KEYS_DIR = "keys";

    private static final String PRIVATE_KEY_FILE = "private.key";
    private static final String PUBLIC_KEY_FILE = "public.key";

    private static final int KEYSIZE = 2048;

    private PrivateKey privateKey;
    private PublicKey publicKey;

    private KeyKeeper() {
        // private constructor
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void prepareKeys() throws Exception {
        File privateKeyFile = new File(KEYS_DIR + SLASH + PRIVATE_KEY_FILE);
        File publicKeyFile = new File(KEYS_DIR + SLASH + PUBLIC_KEY_FILE);

        if (!privateKeyFile.exists() || !publicKeyFile.exists()) {
            new File(KEYS_DIR).mkdir();
            generateNewKeys();
            saveKeysToFiles(privateKeyFile, publicKeyFile);
        } else {
            restoreKeysFromFiles(privateKeyFile, publicKeyFile);
        }
    }

    private void generateNewKeys() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(KEYSIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        this.privateKey = keyPair.getPrivate();
        this.publicKey = keyPair.getPublic();
    }

    private void saveKeysToFiles(File privateKeyFile, File publicKeyFile) throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();

        try (FileWriter outPrivate = new FileWriter(privateKeyFile)) {
            outPrivate.write(BEGIN_PRIVATE + "\n");
            outPrivate.write(encoder.encodeToString(this.privateKey.getEncoded()));
            outPrivate.write("\n" + END_PRIVATE + "\n");
        }

        try (FileWriter outPublic = new FileWriter(publicKeyFile)) {
            outPublic.write(BEGIN_PUBLIC + "\n");
            outPublic.write(encoder.encodeToString(this.publicKey.getEncoded()));
            outPublic.write("\n" + END_PUBLIC + "\n");
        }
    }

    private void restoreKeysFromFiles(File privateKeyFile, File publicKeyFile) throws Exception {
        StringBuilder builderPrivate = new StringBuilder();
        Files.lines(Paths.get(privateKeyFile.toString()), StandardCharsets.UTF_8).forEach(a -> builderPrivate.append(a));
        String stringPrivate = builderPrivate.toString().replaceAll(BEGIN_PRIVATE, "").replaceAll(END_PRIVATE, "");

        StringBuilder builderPublic = new StringBuilder();
        Files.lines(Paths.get(publicKeyFile.toString()), StandardCharsets.UTF_8).forEach(a -> builderPublic.append(a));
        String stringPublic = builderPublic.toString().replaceAll(BEGIN_PUBLIC, "").replaceAll(END_PUBLIC, "");

        KeyFactory kf = KeyFactory.getInstance("RSA");
        Base64.Decoder decoder = Base64.getDecoder();

        PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(decoder.decode(stringPrivate.getBytes()));
        this.privateKey = kf.generatePrivate(keySpecPKCS8);

        X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(decoder.decode(stringPublic.getBytes()));
        this.publicKey = kf.generatePublic(keySpecX509);
    }
}
