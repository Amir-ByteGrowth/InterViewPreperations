package com.example.designpattren

import android.util.Log

interface AirTicketInIndiaTimeAndPrice{
    fun showTimeInIndia()
    fun showPriceInINR()
}

class AirIndiaTimeAndPrice : AirTicketInIndiaTimeAndPrice{
    override fun showTimeInIndia() {
       Log.d("AirIndia","Time")
    }

    override fun showPriceInINR() {
        Log.d("AirIndia","Price")
    }

}

class UnitedAirPriceAndTimeInIndia:AirTicketInIndiaTimeAndPrice{
    override fun showTimeInIndia() {
       Log.d("UnitedAirInIndia",convertTimeIndia("Time"))
    }

    override fun showPriceInINR() {
        Log.d("UnitedAirInIndia",convertPriceToIndia("Price"))
    }

    private fun convertTimeIndia(str:String)=str

    private fun convertPriceToIndia(str: String)=str

}