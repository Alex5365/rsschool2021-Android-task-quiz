package com.rsschool.quiz

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(R.layout.activity_main), Transfer
{
    private var List: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 0..4) List.add("")
        if (savedInstanceState == null) {
            val fragment: Fragment = Fragment_Quiz1.newInstance()
            OpenFragment(fragment)
        }
    }

    fun OpenFragment(fragment: Fragment)
    {
            val transaction: FragmentTransaction = getSupportFragmentManager().beginTransaction()
            transaction.replace(R.id.container, fragment).commit()
    }

    override fun getData(numQuiz: Int): String
    {
        when(numQuiz)
        {
            1 -> return List.get(0)
            2 -> return List.get(1)
            3 -> return List.get(2)
            4 -> return List.get(3)
            5 -> return List.get(4)
            else -> return ""
        }
    }

    override fun setData(check: String, numQuiz: Int)
    {
        when(numQuiz)
        {
            1 -> List.set(0, check)
            2 -> List.set(1, check)
            3 -> List.set(2, check)
            4 -> List.set(3, check)
            5 -> List.set(4, check)
        }
    }

    override fun newFragment(fragment: Fragment, id: Int) {
        onOptionsItemSelected(id)
        OpenFragment(fragment)
    }

    override fun getList(): ArrayList<String> = List


    fun onOptionsItemSelected(id: Int) {
        setTheme(id);
    val typedValue = TypedValue()
    val theme = getTheme();
    theme.resolveAttribute(android.R.attr.windowBackground, typedValue, true)
    getWindow().getDecorView().setBackgroundColor(typedValue.data)
    theme.resolveAttribute(android.R.attr.colorPrimary, typedValue, true)
        getSupportActionBar()?.setBackgroundDrawable(ColorDrawable(typedValue.data))
    theme.resolveAttribute(android.R.attr.colorPrimaryDark, typedValue, true)
    val window = getWindow()
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.setStatusBarColor(typedValue.data);
  }
}