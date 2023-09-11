package com.example.designpattren

class BuilderPattern(builder: Builder) {

    private var ram = builder.ram
    private var processor = builder.processor
    private var screenSize = builder.screenSize
    private var battery = builder.battery

    fun getProcessor(): String {
        return processor
    }


    class Builder(processor: String) {
        var processor: String = processor
        var ram: String = "2GB"
        var battery = "125"
        var screenSize = "1250"

        fun setRam(ram: String): Builder {
            this.ram = ram
            return this
        }

        fun setBatter(battery: String): Builder {
            this.battery = battery
            return this
        }

        fun setScreenSize(screenSize: String): Builder {
            this.screenSize = screenSize
            return this
        }

        fun create(): BuilderPattern {
            return BuilderPattern(this)
        }

    }


}