package com.example.solidprinciples

//this is not following dependency inversion principle

class AndroidAppDeveloper {
    fun developApp() {
        println("Developing Android Application by using Kotlin")
    }
}

class IosAppDeveloper {
    fun developApp() {
        println("Developing IOS Application by using swift")
    }
}

class DevelopApp {

    fun developApp() {
        var androidAppDeveloper = AndroidAppDeveloper()
        var iosAppDeveloper = IosAppDeveloper()
        androidAppDeveloper.developApp()
        iosAppDeveloper.developApp()
    }

}
// /// higher classes should depend upon abstraction of classes rather detail

// here is solution
interface AppDeveloper {
    fun developApp()
}

class AndroidDeveloper:AppDeveloper{
    override fun developApp() {
        println("Developing Android Application by using Kotlin")
    }
}

class IosDeveloper : AppDeveloper{
    override fun developApp() {
        println("Developing IOS Application by using Swift")
    }

}

fun main(){
    var androidDeveloper:AppDeveloper=AndroidDeveloper()
    var iosDeveloper:AppDeveloper=IosDeveloper()
    androidDeveloper.developApp()
    iosDeveloper.developApp()
}


/////////////////////////////////
class DependencyInversionPrinciple {
}

class Emailer {
    fun generateJobAlert(job: String): String {
        return "You are alerted for $job"
    }
}

/*
 * Class called Phone to send phone alerts
 */
class Phone {
    fun generateJobAlert(job: String): String {
        return "You are alerted for $job"
    }
}

/*
 * Class called JobTracker.
 * This class initializes both the Phone & Email class
 * This is a violation of the DIP principle
 */
class JobTracker {
    private val phone: Phone
    private val emailer: Emailer

    init {
        phone = Phone()
        emailer = Emailer()
    }

    /*
 * Based on the jobDescription, the alert is sent
 * This logic should not be implemented here!
 */
    fun setCurrentConditions(jobDescription: String) {
        if (jobDescription === "urgent") {
            val alert = phone.generateJobAlert(jobDescription)
            print(alert)
        }
        if (jobDescription === "brief") {
            val alert = emailer.generateJobAlert(jobDescription)
            print(alert)
        }
    }
}