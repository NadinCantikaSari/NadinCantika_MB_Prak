package com.example.pertemuan3_tia.Message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan3_tia.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://i.pravatar.cc/150?img=1", "09.15"),
        MessageModel("Budi", "Sudah makan?", "https://i.pravatar.cc/150?img=2", "09.30"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://i.pravatar.cc/150?img=3", "10.05"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://i.pravatar.cc/150?img=4", "10.45"),
        MessageModel("Eka", "Nice job kemarin!", "https://i.pravatar.cc/150?img=5", "11.20"),
        MessageModel("Fajar", "Lagi ngapain?", "https://i.pravatar.cc/150?img=6", "12.10"),
        MessageModel("Gita", "Boleh minta tolong?", "https://i.pravatar.cc/150?img=7", "13.00"),
        MessageModel("Hana", "Lihat email ya", "https://i.pravatar.cc/150?img=8", "14.25"),
        MessageModel("Irfan", "Oke noted", "https://i.pravatar.cc/150?img=9", "15.40"),
        MessageModel("Joko", "Sampai jumpa besok", "https://i.pravatar.cc/150?img=10", "16.55")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Message"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
