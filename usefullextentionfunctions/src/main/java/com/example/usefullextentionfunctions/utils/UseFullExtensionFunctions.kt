package com.example.usefullextentionfunctions.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Insets
import android.graphics.Rect
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.text.Editable
import android.util.DisplayMetrics
import android.util.Log
import android.util.Size
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

//logs
fun Any?.printToLog(tag: String = "DEBUG_LOG") {
    Log.d(tag, toString())
}

//visibility modifier extension methods
fun View.gone() = run { visibility = View.GONE }

fun View.visible() = run { visibility = View.VISIBLE }

fun View.invisible() = run { visibility = View.INVISIBLE }

fun View.visibleIf(condition: Boolean) =
    run { visibility = if (condition) View.VISIBLE else View.GONE }

fun View.invisibleIf(condition: Boolean) =
    run { visibility = if (condition) View.INVISIBLE else View.VISIBLE }

fun View.goneIf(condition: Boolean) =
    run { visibility = if (condition) View.INVISIBLE else View.VISIBLE }

//toast messages for activity and fragments
fun Fragment.toast(message: String) = run {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}
fun Fragment.toast(@StringRes message: Int) = run {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}

fun Activity.toast(message: String) =
    run { Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show() }

fun Activity.toast(@StringRes message: Int) =
    run { Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show() }

// snakbar messages
fun View.snackbar(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}

fun View.snackbar(@StringRes message: Int, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}

// hide keyboard
fun Activity.hideKeyboard() {
    val imm: InputMethodManager =
        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    val view = currentFocus ?: View(this)
    imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun Fragment.hideKeyboard() {
    activity?.apply {
        val imm: InputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus ?: View(this)
        imm.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}

// Convert px to dp and dp  to dp
val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

//Convert dp to px
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

//Digit, Alphabetic, and Alphanumeric Check

val String.isDigitOnly: Boolean
    get() = matches(Regex("^\\d*\$"))

val String.isAlphabeticOnly: Boolean
    get() = matches(Regex("^[a-zA-Z]*\$"))

val String.isAlphanumericOnly: Boolean
    get() = matches(Regex("^[a-zA-Z\\d]*\$"))

//isNull
//isNull will be applied to any property.
// This property will be used whenever you want to check the null equality on any object.
// This property will increase the code’s readability. You can use obj.isNull rather than obj == null .
val Any?.isNull get() = this == null

fun Any?.ifNull(block: () -> Unit) = run {
    if (this == null) {
        block()
    }
}

// date formatter function
fun String.toDate(format: String = "yyyy-MM-dd HH:mm:ss"): Date? {
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())
    return dateFormatter.parse(this)
}

fun Date.toStringFormat(format: String = "yyyy-MM-dd HH:mm:ss"): String {
    val dateFormatter = SimpleDateFormat(format, Locale.getDefault())
    return dateFormatter.format(this)
}

// get text as string from edit text
val EditText.value
    get() = text?.toString() ?: ""


// call activity
fun Activity.startActivity(
    cls: Class<*>,
    finishCallingActivity: Boolean = true,
    block: (Intent.() -> Unit)? = null
) {
    val intent = Intent(this, cls)
    block?.invoke(intent)
    startActivity(intent)
    if (finishCallingActivity) finish()
}

fun Context.isNetworkAvailable(): Boolean {
    val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val capabilities = manager.getNetworkCapabilities(manager.activeNetwork)
    return if (capabilities != null) {
        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    } else false
}

fun Fragment.isNetworkAvailable() = requireContext().isNetworkAvailable()

// get screen size
val Context.screenSize: Size
    get() {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager

        val size = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val metrics = windowManager.currentWindowMetrics
            val windowInsets = metrics.windowInsets
            val insets: Insets = windowInsets.getInsetsIgnoringVisibility(
                WindowInsets.Type.navigationBars()
                        or WindowInsets.Type.displayCutout()
            )

            val insetsWidth: Int = insets.right + insets.left
            val insetsHeight: Int = insets.top + insets.bottom
            val bounds: Rect = metrics.bounds
            Size(
                bounds.width() - insetsWidth,
                bounds.height() - insetsHeight
            )
        } else {
            val displayMetrics = DisplayMetrics()
            windowManager.defaultDisplay?.getMetrics(displayMetrics)
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels
            Size(width, height)
        }
        return size
    }

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

/// remove white space and duplicate white spaces
fun String.removeAllWhitespaces(): String {
    return this.replace("\\s+".toRegex(), "")
}

fun String.removeDuplicateWhitespaces(): String {
    return this.replace("\\s+".toRegex(), " ")
}

fun Context.isPermissionGranted(permission: String) = run {
    ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}