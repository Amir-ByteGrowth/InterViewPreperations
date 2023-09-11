package com.example.sslpinning

import com.uae.myvaultspay.MainApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.security.KeyStore
import java.security.cert.CertificateFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        // SSL certificate
        val cf = CertificateFactory.getInstance("X.509")
        val cert = MainApplication.applicationContext.resources?.openRawResource(R.raw.vp_updated)
        cert.use { cert ->
            val ca = cf.generateCertificate(cert)
            val keyStoreType = KeyStore.getDefaultType()
            val keyStore = KeyStore.getInstance(keyStoreType)
            keyStore.load(null, null)
            keyStore.setCertificateEntry("ca", ca)
            val tmfAlgo = TrustManagerFactory.getDefaultAlgorithm()
            val tmf = TrustManagerFactory.getInstance(tmfAlgo)
            tmf.init(keyStore)
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, tmf.trustManagers, null)

            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)


                .sslSocketFactory(
                    sslContext.socketFactory,
                    tmf.trustManagers[0] as X509TrustManager
                )
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        }
    } else {

        // SSL certificate
        val cf = CertificateFactory.getInstance("X.509")
        val cert = MainApplication.applicationContext.resources?.openRawResource(R.raw.vp_updated)
        cert.use { cert ->
            val ca = cf.generateCertificate(cert)
            val keyStoreType = KeyStore.getDefaultType()
            val keyStore = KeyStore.getInstance(keyStoreType)
            keyStore.load(null, null)
            keyStore.setCertificateEntry("ca", ca)
            val tmfAlgo = TrustManagerFactory.getDefaultAlgorithm()
            val tmf = TrustManagerFactory.getInstance(tmfAlgo)
            tmf.init(keyStore)
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, tmf.trustManagers, null)

            OkHttpClient
                .Builder()
                .sslSocketFactory(
                    sslContext.socketFactory,
                    tmf.trustManagers[0] as X509TrustManager
                )
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build()
        }
    }


    /**------------------------------------------------------------------------------Emall App Module----------------------------------------------------------------------------------------------------------------**/


}