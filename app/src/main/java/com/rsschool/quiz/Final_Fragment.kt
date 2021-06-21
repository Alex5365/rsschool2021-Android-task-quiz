package com.rsschool.quiz

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FinalFragmentBinding

class Final_Fragment: Fragment()
{
    private var _binding: FinalFragmentBinding? = null
    private val binding  get() = _binding!!
    private var List: ArrayList<String> = ArrayList()
    private lateinit var transfer: Transfer
    private var rezult = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        for (i in 0..4) List.add("")
        transfer = activity as Transfer
        List = transfer.getList()
        println("List = $List")
        for (i in 0..4)
        {
            when(i)
            {
                0 -> {if (List.get(i).equals(getString(R.string.quest1_ansfer2))) rezult++}
                1 -> {if (List.get(i).equals(getString(R.string.quest2_ansfer4))) rezult++}
                2 -> {if (List.get(i).equals(getString(R.string.quest3_ansfer4))) rezult++}
                3 -> {if (List.get(i).equals(getString(R.string.quest4_ansfer1))) rezult++}
                4 -> {if (List.get(i).equals(getString(R.string.quest5_ansfer4))) rezult++}
            }
        }
        _binding = FinalFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Rezult.setText("${binding.Rezult.text} ${100/5*rezult}%")
        binding.tell.setOnClickListener()
        {
            val textMessage = "${binding.Rezult.text}\n \n Вопрос 1: ${getString(R.string.Question1)} \n    Ваш ответ: ${List.get(0)} \n    Верный ответ: ${getString(R.string.quest1_ansfer2)} \n" +
                                                       "\n Вопрос 2: ${getString(R.string.Question2)} \n    Ваш ответ: ${List.get(1)} \n    Верный ответ: ${getString(R.string.quest2_ansfer4)} \n" +
                                                       "\n Вопрос 3: ${getString(R.string.Question3)} \n    Ваш ответ: ${List.get(2)} \n    Верный ответ: ${getString(R.string.quest3_ansfer4)} \n" +
                                                       "\n Вопрос 4: ${getString(R.string.Question4)} \n    Ваш ответ: ${List.get(3)} \n    Верный ответ: ${getString(R.string.quest4_ansfer1)} \n" +
                                                       "\n Вопрос 5: ${getString(R.string.Question5)} \n    Ваш ответ: ${List.get(4)} \n    Верный ответ: ${getString(R.string.quest5_ansfer4)}"
            val sendIntent = Intent().apply{
                action = Intent.ACTION_SEND
                type = "text/palin"
                putExtra(Intent.EXTRA_TEXT, textMessage)
            }
            startActivity(Intent.createChooser(sendIntent, ""))
        }
        binding.back.setOnClickListener()
        {
            val fragment = Fragment_Quiz1.newInstance()
            for (i in 1..5) transfer.setData( "", i)
            transfer.newFragment(fragment)
        }

        binding.close.setOnClickListener()
        {
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }

   /* fun Answer(numberQuestion: Int):String
    {
            when(List.get(numberQuestion - 1))
            {
                "One" -> {
                    R.string.
                }
                "Two" -> {

                }
                "Three" -> {

                }
                "Four" -> {

                }
                "Five" -> {

                }
                else return ""
            }
    }*/

    companion object {
        @JvmStatic
        fun newInstance(): Final_Fragment {
            val fragment = Final_Fragment()
            return fragment
        }
    }
}

