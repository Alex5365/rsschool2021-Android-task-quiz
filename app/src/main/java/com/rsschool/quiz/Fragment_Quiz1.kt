package com.rsschool.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.rsschool.quiz.databinding.FragmentQuiz1Binding


class Fragment_Quiz1 : Fragment()
{
    private var _binding: FragmentQuiz1Binding? = null
    private val binding  get() = _binding!!
    private lateinit var transfer: Transfer
    private var checked: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        transfer = activity as Transfer
        _binding = FragmentQuiz1Binding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checked = transfer.getData(1)
        when(checked)
        {
            getString(R.string.quest1_ansfer1) -> {
                binding.optionOne.performClick()
                binding.next.setEnabled(true)
            }
            getString(R.string.quest1_ansfer2) -> {
                binding.optionTwo.performClick()
                binding.next.setEnabled(true)
            }
            getString(R.string.quest1_ansfer3) -> {
                binding.optionThree.performClick()
                binding.next.setEnabled(true)
            }
            getString(R.string.quest1_ansfer4) -> {
                binding.optionFour.performClick()
                binding.next.setEnabled(true)
            }
            getString(R.string.quest1_ansfer5) -> {
                binding.optionFive.performClick()
                binding.next.setEnabled(true)
            }
        }
        binding.toolbar.setNavigationOnClickListener()
        {

        }
        binding.next.setOnClickListener()
        {
            transfer.setData(checked, 1)
            val fragment = Fragment_Quiz2.newInstance()
            transfer.newFragment(fragment, R.style.Two)
        }

        binding.previous.setOnClickListener()
        {
            //TODO Vihod iz priloshenia
        }

        binding.optionOne.setOnClickListener()
        {
            checked = getString(R.string.quest1_ansfer1)
            binding.next.setEnabled(true)
        }

        binding.optionTwo.setOnClickListener()
        {
            checked = getString(R.string.quest1_ansfer2)
            binding.next.setEnabled(true)
        }

        binding.optionThree.setOnClickListener()
        {
            checked = getString(R.string.quest1_ansfer3)
            binding.next.setEnabled(true)
        }

        binding.optionFour.setOnClickListener()
        {
            checked = getString(R.string.quest1_ansfer4)
            binding.next.setEnabled(true)
        }

        binding.optionFive.setOnClickListener()
        {
            checked = getString(R.string.quest1_ansfer5)
            binding.next.setEnabled(true)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    companion object {
        @JvmStatic
        fun newInstance(): Fragment_Quiz1 {
            val fragment = Fragment_Quiz1()
            return fragment
        }
    }
}

