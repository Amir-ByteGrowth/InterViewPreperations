package com.example.lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentLifeCycle", "OnAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        Log.d("FragmentLifeCycle", "OnCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("FragmentLifeCycle", "OnCreateView")

        var view = inflater.inflate(R.layout.fragment_a, container, false)

        return view
    }

    fun replaceFragment() {
        val transaction: FragmentTransaction =
            requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, FragmentB.newInstance("Parameter 1", "Parameter 2"))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentA.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentA().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentLifeCycle", "OnViewCreated")
        view.findViewById<Button>(R.id.click).setOnClickListener {
            replaceFragment()
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
        }
        var list = arrayListOf(
            DataClass("Title1", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title2", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title3", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title4", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title5", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title6", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title7", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title8", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title9", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title10", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title11", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title12", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title13", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title14", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title15", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title16", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title17", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title18", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
            DataClass("Title19", "Description kjdfnjkdf kdjfnsdjkfs ksdjfnskd\n kjfnsdjkf"),
        )

        var adapter = WalletRecyclerAdapter(requireContext(), list)
        val recyclerView= view.findViewById<RecyclerView>(R.id.rectangles)
        val snapHelper: SnapHelper = LinearSnapHelper()

        snapHelper.attachToRecyclerView(recyclerView)
        recyclerView.adapter=adapter
    }


    override fun onStart() {
        super.onStart()
        Log.d("FragmentLifeCycle", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentLifeCycle", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentLifeCycle", "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragmentLifeCycle", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentLifeCycle", "OnDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentLifeCycle", "OnDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentLifeCycle", "OnDetach")
    }

}