package com.vandit.mvvmquizapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vandit.mvvmquizapp.R
import com.vandit.mvvmquizapp.databinding.FragmentMainBinding
import com.vandit.mvvmquizapp.models.QuestionsModel
import com.vandit.mvvmquizapp.viewmodel.QuestionViewModel
import java.util.*

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private lateinit var viewmodel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewmodel = ViewModelProvider(requireActivity()).get(QuestionViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        binding.handler = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.getFirstQuestion()
        viewmodel.nextQuestion.observe(viewLifecycleOwner) {
            binding.questionModel = it
            binding.QuestionView.invalidate()
        }
    }

    fun onButtonPress(v: View) {
        viewmodel.getNextQuestion()
        Log.d("TAG", "Hello GM")
    }
}