package com.rsschool.quiz;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FragmentQuiz1Binding
import com.rsschool.quiz.databinding.FragmentQuiz2Binding
import com.rsschool.quiz.databinding.FragmentQuiz4Binding

class Fragment_Quiz4: Fragment()
{

    private var _binding: FragmentQuiz4Binding? = null
    private val binding  get() = _binding!!
    private lateinit var transfer: Transfer
    private var checked: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        transfer = activity as Transfer
        _binding = FragmentQuiz4Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checked = transfer.getData(4)
        when(checked)
        {
            getString(R.string.quest4_ansfer1) -> {
                binding.optionOne.performClick()
                binding.next.setEnabled(true)
            }
            getString(R.string.quest4_ansfer2) -> {
                binding.optionTwo.performClick()
                binding.next.setEnabled(true)
            }
            getString(R.string.quest4_ansfer3) -> {
                binding.optionThree.performClick()
                binding.next.setEnabled(true)
            }
            getString(R.string.quest4_ansfer4) -> {
                binding.optionFour.performClick()
                binding.next.setEnabled(true)
            }
            getString(R.string.quest4_ansfer5) -> {
                binding.optionFive.performClick()
                binding.next.setEnabled(true)
            }
        }
        binding.next.setOnClickListener()
        {
            transfer.setData(checked, 4)
            val fragment = Fragment_Quiz5.newInstance()
            transfer.newFragment(fragment, R.style.Five)
        }
        binding.toolbar.setNavigationOnClickListener()
        {
            transfer.setData(checked, 4)
            val fragment = Fragment_Quiz3.newInstance()
            transfer.newFragment(fragment, R.style.Three)
        }
        binding.previous.setOnClickListener()
        {
            transfer.setData(checked, 4)
            val fragment = Fragment_Quiz3.newInstance()
            transfer.newFragment(fragment, R.style.Three)
        }

        binding.optionOne.setOnClickListener()
        {
            checked = getString(R.string.quest4_ansfer1)
            binding.next.setEnabled(true)
        }

        binding.optionTwo.setOnClickListener()
        {
            checked = getString(R.string.quest4_ansfer2)
            binding.next.setEnabled(true)
        }

        binding.optionThree.setOnClickListener()
        {
            checked = getString(R.string.quest4_ansfer3)
            binding.next.setEnabled(true)
        }

        binding.optionFour.setOnClickListener()
        {
            checked = getString(R.string.quest4_ansfer4)
            binding.next.setEnabled(true)
        }

        binding.optionFive.setOnClickListener()
        {
            checked = getString(R.string.quest4_ansfer5)
            binding.next.setEnabled(true)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): Fragment_Quiz4 {
            val fragment = Fragment_Quiz4()
            return fragment
        }
    }
}