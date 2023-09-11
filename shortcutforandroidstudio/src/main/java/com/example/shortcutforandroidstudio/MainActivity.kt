package com.example.shortcutforandroidstudio

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


//    1. Surround with: Ctrl + Alt + T (W) / Cmd + Option + T (M)
//    If you want to surround a block of code with an if statement, for loop, or try-catch block,
//    you can use the surround with feature. Simply select the code block and make a combination of these keys.
//    It’s just amazing. You can wrap your composables with Box, Row or Column in 1 combination!


    fun showToast() {
        if (true) {
            Toast.makeText(applicationContext, "Show", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "Dont Show", Toast.LENGTH_SHORT).show()
        }
    }

//    2. Split editor
//    If you want to view two different parts of your code at the same time, you can split the editor.
//    Simply right-click on the tab of the file you want to operate with.
//    Real helper when you are in a large file, infinitely scrolling between methods and applying find operations instead of this gem function.



//    3. Extract Method: Ctrl + Alt + M (W) / Cmd + Option + M (M)
//    If you have a block of code that you want to reuse in multiple places, you can extract it into a separate method.
//    Simply select the code block and press the combination mentioned above. A quick example below.

//    Before:

//    fun openLink(context: Context, url: String) {
//        val customTabsIntent = CustomTabsIntent.Builder().build()
//        customTabsIntent.launchUrl(context, Uri.parse(url))
//    }
//    After:

    fun openLink(context: Context, url: String) {
        createCustomTabsIntent(context, url)
    }

    private fun createCustomTabsIntent(context: Context, url: String) {
        val customTabsIntent = customTabsIntent()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }

    private fun customTabsIntent(): CustomTabsIntent {
        val customTabsIntent = CustomTabsIntent.Builder().build()
        return customTabsIntent
    }


}