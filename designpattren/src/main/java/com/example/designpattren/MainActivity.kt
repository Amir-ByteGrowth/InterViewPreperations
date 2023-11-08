package com.example.designpattren

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.designpattren.decoratorpattern.practice1.UserNameValidator
import com.example.designpattren.decoratorpattern.practice1.UserRepositoryImpl

class MainActivity : AppCompatActivity() {
    var TAG = "DesignPattern"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var builderPattern = BuilderPattern.Builder("180").setBatter("120").create()
//        var builder2 = BuilderPattern(BuilderPattern.Builder("190"))
//        Log.d(TAG, builderPattern.getProcessor())
//        Log.d(TAG, builder2.getProcessor())
//
//
//
//        AlertDialog.Builder(this)
//            .setTitle("This is a title")
//            .setMessage("This is some message")
//            .show()
//
//        SingletonClass.showToast(applicationContext)

//        mainMethod()
//    NotificationFactory.createNotification("sms").notifyUser()
//    NotificationFactory.createNotification("email").notifyUser()
//    NotificationFactory.createNotification("call").notifyUser()

        var airTicketInIndiaTimeAndPrice: AirTicketInIndiaTimeAndPrice = AirIndiaTimeAndPrice()
        var unitedAirPriceAndTimeInIndia: AirTicketInIndiaTimeAndPrice =
            UnitedAirPriceAndTimeInIndia()

//        airTicketInIndiaTimeAndPrice.showTimeInIndia()
//        airTicketInIndiaTimeAndPrice.showPriceInINR()
//        unitedAirPriceAndTimeInIndia.showTimeInIndia()
//        unitedAirPriceAndTimeInIndia.showPriceInINR()

        var userName = "superman"
        val userRepository = UserRepositoryImpl()
        val userValidator = UserNameValidator(userRepository)


        findViewById<Button>(R.id.btnSet).setOnClickListener {
          userValidator.setUserName("amir", "javeed")
            userName = "amir"
        }

        findViewById<Button>(R.id.btnShow).setOnClickListener {
            Toast.makeText(
                applicationContext,
                userValidator.getUserName(userName),
                Toast.LENGTH_SHORT
            ).show()
        }


    }


}