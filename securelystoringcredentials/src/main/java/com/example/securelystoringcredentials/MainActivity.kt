package com.example.securelystoringcredentials


import android.os.Bundle
import android.security.KeyStoreException
import android.util.Base64
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException
import java.security.SignatureException
import java.security.UnrecoverableEntryException
import javax.crypto.BadPaddingException
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.security.cert.CertificateException


class MainActivity : AppCompatActivity() {

    private var encryptor: EnCryptor? = null
    private var decryptor: Decryptor? = null


    var edTextToEncrypt: EditText? = null


    var tvEncryptedText: TextView? = null


    var tvDecryptedText: TextView? = null
    
    var btnClick:Button?=null

    var btnDecrypt:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edTextToEncrypt=findViewById(R.id.edTextToEncrypt)
        tvEncryptedText=findViewById(R.id.tvEncryptedText)
        tvDecryptedText=findViewById(R.id.tvDecryptedText)
        btnClick=findViewById(R.id.btnClick)
        btnDecrypt=findViewById(R.id.btnDecrypt)

        encryptor = EnCryptor()

        try {
            decryptor = Decryptor()
        } catch (e: CertificateException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }  catch (e: IOException) {
            e.printStackTrace()
        }

        btnClick?.setOnClickListener {
            encryptText();
        }

        btnDecrypt?.setOnClickListener {
            decryptText();
        }

    }

    private fun decryptText() {
        try {
            tvDecryptedText?.setText(
                decryptor?.decryptData(SAMPLE_ALIAS, encryptor?.getEncryption(), encryptor?.getIv())
            )
        } catch (e: UnrecoverableEntryException) {
            Log.e(TAG, "decryptData() called with: ", e)
        } catch (e: NoSuchAlgorithmException) {
            Log.e(TAG, "decryptData() called with: ", e)
        } catch (e: NoSuchPaddingException) {
            Log.e(TAG, "decryptData() called with: ", e)
        } catch (e: NoSuchProviderException) {
            Log.e(TAG, "decryptData() called with: ", e)
        } catch (e: IOException) {
            Log.e(TAG, "decryptData() called with: ", e)
        } catch (e: InvalidKeyException) {
            Log.e(TAG, "decryptData() called with: ", e)
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        } catch (e: InvalidAlgorithmParameterException) {
            e.printStackTrace()
        }
    }

    val TAG="MainActivityTag"
    private val SAMPLE_ALIAS = "key0"
    private fun encryptText() {
        try {
            val encryptedText: ByteArray? = encryptor?.encryptText(SAMPLE_ALIAS, edTextToEncrypt?.getText().toString())
            tvEncryptedText?.setText(Base64.encodeToString(encryptedText, Base64.DEFAULT))
        } catch (e: UnrecoverableEntryException) {
            Log.e(TAG, "onClick() called with: ", e)
        } catch (e: NoSuchAlgorithmException) {
            Log.e(TAG, "onClick() called with: ", e)
        } catch (e: NoSuchProviderException) {
            Log.e(TAG, "onClick() called with: ", e)
        }  catch (e: IOException) {
            Log.e(TAG, "onClick() called with: ", e)
        } catch (e: NoSuchPaddingException) {
            Log.e(TAG, "onClick() called with: ", e)
        } catch (e: InvalidKeyException) {
            Log.e(TAG, "onClick() called with: ", e)
        } catch (e: InvalidAlgorithmParameterException) {
            e.printStackTrace()
        } catch (e: SignatureException) {
            e.printStackTrace()
        } catch (e: IllegalBlockSizeException) {
            e.printStackTrace()
        } catch (e: BadPaddingException) {
            e.printStackTrace()
        }
    }

}