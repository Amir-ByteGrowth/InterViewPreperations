package com.example.securelystoringcredentials

import java.io.IOException
import java.nio.charset.Charset
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException
import java.security.UnrecoverableEntryException
import java.security.cert.CertificateException
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec


class Decryptor {
    private val TRANSFORMATION = "AES/GCM/NoPadding"
    private val ANDROID_KEY_STORE = "AndroidKeyStore"

    private var keyStore: KeyStore? = null


    init {
        initKeyStore()
    }



    @Throws(
        KeyStoreException::class,
        CertificateException::class,
        NoSuchAlgorithmException::class,
        IOException::class
    )
    private fun initKeyStore() {
        keyStore = KeyStore.getInstance(ANDROID_KEY_STORE)
        keyStore?.load(null)
    }

    @Throws(
        UnrecoverableEntryException::class,
        NoSuchAlgorithmException::class,
        KeyStoreException::class,
        NoSuchProviderException::class,
        NoSuchPaddingException::class,
        InvalidKeyException::class,
        IOException::class,
        BadPaddingException::class,
        IllegalBlockSizeException::class,
        InvalidAlgorithmParameterException::class
    )
    // TODO:  var encoded = Base64.encodeToString(encryptedData, Base64.DEFAULT)
    //        var decoded = Base64.decode(encoded, Base64.DEFAULT)
    //we can convert encoded string to byte array simple decoding this

    fun decryptData(alias: String, encryptedData: ByteArray?, encryptionIv: ByteArray?): String {

        val cipher = Cipher.getInstance(TRANSFORMATION)
        val spec = GCMParameterSpec(128, encryptionIv)
        cipher.init(Cipher.DECRYPT_MODE, getSecretKey(alias), spec)
        return String(cipher.doFinal(encryptedData), Charsets.UTF_8 )
    }

    @Throws(
        NoSuchAlgorithmException::class,
        UnrecoverableEntryException::class,
        KeyStoreException::class
    )
    private fun getSecretKey(alias: String): SecretKey? {
        return (keyStore?.getEntry(alias, null) as KeyStore.SecretKeyEntry).secretKey
    }

}