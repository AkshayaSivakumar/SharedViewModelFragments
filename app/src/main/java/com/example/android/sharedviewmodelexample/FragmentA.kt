package com.example.android.sharedviewmodelexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class FragmentA : Fragment() {
    private lateinit var editText: EditText
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_one, container, false)

        editText = view.findViewById(R.id.edit_text1)
        val button = view.findViewById(R.id.button1) as Button
        button.setOnClickListener {
            sharedViewModel.setUserText(editText.text)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        sharedViewModel.userText.observe(viewLifecycleOwner, Observer {
            editText.setText(it)
        })
    }
}