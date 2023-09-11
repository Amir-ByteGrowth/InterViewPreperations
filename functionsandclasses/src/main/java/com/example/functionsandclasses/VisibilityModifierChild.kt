package com.example.functionsandclasses

class VisibilityModifierChild {

    fun Test(
    ) {
//        VisibilityModifierParent.bar=6
//        you will get an error to set value becuase set is only availble in the class

//        PrivateConstructor(a=5)
//        private constructor can not be created out side the class

        PrivateConstructor(4, "fdd")
    }

}