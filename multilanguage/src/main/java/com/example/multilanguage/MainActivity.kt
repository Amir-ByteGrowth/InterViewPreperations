package com.example.multilanguage

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.ConfigurationCompat
import java.util.Locale

class MainActivity : BaseActivity() {

    private lateinit var firstLocaleCode: String
    private lateinit var secondLocaleCode: String
    private lateinit var currentSystemLocaleCode: String
    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var btnMoveNew:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView=findViewById(R.id.textView)
        textView2= findViewById(R.id.textView2)
        btnMoveNew=findViewById(R.id.btnMoveNew)

        currentSystemLocaleCode = ConfigurationCompat.getLocales(Resources.getSystem().configuration).get(0)!!.language
        if(storage.getPreferredLocale() == LocaleUtil.OPTION_PHONE_LANGUAGE){
            if(currentSystemLocaleCode in LocaleUtil.supportedLocales){
                textView.text = getString(R.string.phone_language, Locale(currentSystemLocaleCode).displayLanguage)
            } else {

                //current system language is neither English nor my second language (for me Bangla)
                textView.text = "English"
            }
        } else {
            if(currentSystemLocaleCode == storage.getPreferredLocale()){
                textView.text = getString(R.string.phone_language, Locale(currentSystemLocaleCode).displayLanguage)
            } else {
                textView.text = Locale(storage.getPreferredLocale()).displayLanguage
            }
        }
        firstLocaleCode = if(currentSystemLocaleCode in LocaleUtil.supportedLocales){
            currentSystemLocaleCode
        } else {
            if(storage.getPreferredLocale() == LocaleUtil.OPTION_PHONE_LANGUAGE){
                //current system language is neither English nor my second language (for me Bangla)
                "en"
            } else {
                storage.getPreferredLocale()
            }
        }
        secondLocaleCode = getSecondLanguageCode()
        initRadioButtonUI()
//        radioGroup.setOnCheckedChangeListener { _, checkedId ->
//            when (checkedId) {
//                R.id.op1 -> {
//                    updateAppLocale(LocaleUtil.OPTION_PHONE_LANGUAGE)
//                    recreate()
//                }
//                R.id.op2 -> {
//                    updateAppLocale(secondLocaleCode)
//                    recreate()
//                }
//            }
//        }


//        LocaleHelper.setLocale(applicationContext, "ur");
        findViewById<Button>(R.id.btnEnglish).setOnClickListener {
//            var context = LocaleHelper.setLocale(applicationContext, "en");
//            var resources = context?.getResources();
//            findViewById<TextView>(R.id.textView).setText(resources?.getString(R.string.my_name));
//            findViewById<TextView>(R.id.textView2).setText(resources?.getString(R.string.my_age));

            updateAppLocale("en")
            recreate()
        }

        findViewById<Button>(R.id.btnGujarati).setOnClickListener {
//            var context = LocaleHelper.setLocale(applicationContext, "ur");
//            var resources = context?.getResources();
//            startActivity(Intent(applicationContext,MainActivity::class.java))
//finish()

        //            findViewById<TextView>(R.id.textView).setText(resources?.getString(R.string.my_name));
//            findViewById<TextView>(R.id.textView2).setText(resources?.getString(R.string.my_age));
            updateAppLocale("ur")
            recreate()
        }

        findViewById<Button>(R.id.btnArbi).setOnClickListener {
//            var context = LocaleHelper.setLocale(applicationContext, "ar");
//            var resources = context?.getResources();
//            startActivity(Intent(applicationContext,MainActivity::class.java))
//            finish()
//            findViewById<TextView>(R.id.textView).setText(resources?.getString(R.string.my_name));
//            findViewById<TextView>(R.id.textView2).setText(resources?.getString(R.string.my_age));
            updateAppLocale("ar")
            recreate()
        }
        btnMoveNew.setOnClickListener {
            startActivity(Intent(applicationContext,NewActivity::class.java))
        }


    }

    private fun getSecondLanguageCode(): String {
        return if(firstLocaleCode == "en") "bn" else "en"
    }
    private fun initRadioButtonUI() {
        if(currentSystemLocaleCode in LocaleUtil.supportedLocales){
            textView2.text = getString(R.string.phone_language, getLanguageNameByCode(firstLocaleCode))
        } else {
            textView2.text = getLanguageNameByCode(firstLocaleCode)
        }
//        op2.text = getLanguageNameByCode(secondLocaleCode)
//        if(storage.getPreferredLocale() == secondLocaleCode) op2.isChecked = true
//        else op1.isChecked = true
    }

    private fun getLanguageNameByCode(code: String) : String{
        val tempLocale = Locale(code)
        return tempLocale.getDisplayLanguage(tempLocale)
    }

    private fun updateAppLocale(locale: String) {
        storage.setPreferredLocale(locale)
        LocaleUtil.applyLocalizedContext(applicationContext, locale)

    }
}