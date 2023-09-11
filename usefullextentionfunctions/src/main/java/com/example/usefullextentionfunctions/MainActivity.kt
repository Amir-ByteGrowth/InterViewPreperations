package com.example.usefullextentionfunctions

import android.Manifest
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout.LayoutParams
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.usefullextentionfunctions.utils.gone
import com.example.usefullextentionfunctions.utils.goneIf
import com.example.usefullextentionfunctions.utils.hideKeyboard
import com.example.usefullextentionfunctions.utils.ifNull
import com.example.usefullextentionfunctions.utils.invisible
import com.example.usefullextentionfunctions.utils.isNull
import com.example.usefullextentionfunctions.utils.isPermissionGranted
import com.example.usefullextentionfunctions.utils.printToLog
import com.example.usefullextentionfunctions.utils.px
import com.example.usefullextentionfunctions.utils.removeAllWhitespaces
import com.example.usefullextentionfunctions.utils.removeDuplicateWhitespaces
import com.example.usefullextentionfunctions.utils.screenSize
import com.example.usefullextentionfunctions.utils.snackbar
import com.example.usefullextentionfunctions.utils.toDate
import com.example.usefullextentionfunctions.utils.toEditable
import com.example.usefullextentionfunctions.utils.toStringFormat
import com.example.usefullextentionfunctions.utils.toast
import com.example.usefullextentionfunctions.utils.value
import com.example.usefullextentionfunctions.utils.visible
import com.example.usefullextentionfunctions.utils.visibleIf
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //logs extension methods
        "Amir is Here".printToLog()
        "String with tag here, check name".printToLog("CHECK_NAME")
        var textView = findViewById<TextView>(R.id.tv)
        var editText = findViewById<EditText>(R.id.et)
        // visibility extension methods
        textView.gone()
        textView.invisible()
        textView.visible()

        textView.visibleIf(false)
        textView.goneIf(false)

        // toast messages
//        toast(R.string.app_name)
//snakbar messages
        textView.snackbar("ShowSnak bar")
        //hide keyboard

        editText.addTextChangedListener {
            hideKeyboard()
        }

        // px to dp

        var layoutParams = LayoutParams(16.px, 15.px)

//        toast("123".isDigitOnly.toString() + " yes there are digits")
//        toast("abc".isAlphabeticOnly.toString() + " yes there are alphabets")
//        toast("abc123".isAlphanumericOnly.toString() + " yes there are alphanumeric")
//        toast("abc123".isDigitOnly.toString() + " these are digits onlly")

//is null
        var str: String? = null
        if (str.isNull) {
            // Run if object is null
        } else {
            // Run if object is not null
        }

        str.ifNull {
            // Write code
        }

        // date formatter
        val currentDate = Date().toStringFormat()
        val currentDate2 = Date().toStringFormat(format = "dd-MM-yyyy")
        val date = "2023-01-01".toDate(format = "yyyy-MM-dd")


        // get text as string from edit text
        editText.value.printToLog("EdittextText")

        //move to other activity
//        startActivity(MainActivity::class.java) // Without Intent modification
//        startActivity(MainActivity::class.java) {
//            // You can access the intent object in this block
//            putExtra("key", "value")
//        }

//        if (isNetworkAvailable())toast("Network available")

        toast(screenSize.height.toString() + "   " + screenSize.width)

        // convert string to editable
        editText.text = "First name".toEditable()
        //

        "Hello,     world!!!".removeAllWhitespaces() // Output: Hello,world!!!
        "Hello,     world!!!".removeDuplicateWhitespaces() // Output: Hello, world!!!

        // check if permission is granted
        if (isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Block runs if permission is granted
        } else {
            // Ask for permission
        }

    }
}