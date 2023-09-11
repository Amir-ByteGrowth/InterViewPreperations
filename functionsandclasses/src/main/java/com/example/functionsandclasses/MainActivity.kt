package com.example.functionsandclasses

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ScopedFunctions.letScopedFunction()
//        ScopedFunctions.runScopedFunction()
//        ScopedFunctions.runWithLet()
//        ScopedFunctions.checkFunction()

//        ApplyFunctions.setPersonWithApply()

//        Checking.showOverrideMethodDefaultValue()


        GenericClasses(5)

//        var genericClasses = GenericClasses("Amir")
//
//        var intList = genericClasses.ItemsList(arrayListOf(1, 2, 3))
//        var strList = genericClasses.ItemsList(arrayListOf("Amir", "Rashid", "Nome"))
//        var item = VariableNumberOfArguments.asList(1, 2, "Amir", 5)[2]
//        Log.d("MainActivity", intList.toString())
//        Log.d("MainActivity", strList.toString())
//        Log.d("MainActivity", item.toString())


//       val setFun= VariableNumberOfArguments.writeStuff()
//        Log.d("MainActovotu","NoWCalling")
//        setFun("Rashid")

//        VariableNumberOfArguments.minByMaxBy()

        var childInherit = ChildInherit()
        childInherit.bPublic = 9
        Log.d("Inheritance", childInherit.bPublic.toString())

//        val item = HigherOrderFunction.takeFunctionAsParam { a, b -> a + b }
//        val sumAsReturnParam = HigherOrderFunction.returnFunction()
//        Log.d("ReturnFunctionSum", sumAsReturnParam(5, 6).toString())
        EqualOperator.checkClassEquality()

    }

    override fun onResume() {
//        Thread{
//            RecursiveFunction.show1000numbers(1000000)
//        }.start()

        super.onResume()
    }

}