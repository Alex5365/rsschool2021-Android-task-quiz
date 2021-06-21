package com.rsschool.quiz

import androidx.fragment.app.Fragment

interface Transfer {
    fun getData(numQuiz: Int): String
    fun setData(check: String, numQuiz: Int)
    fun newFragment(fargment: Fragment)
    fun getList(): ArrayList<String>
}