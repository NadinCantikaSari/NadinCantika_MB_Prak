package com.example.pertemuan3_tia.More

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan3_tia.databinding.FragmentMoreBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoreFragment : Fragment() {

    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!
    private val dataList = listOf(
        "Kotlin", "Java", "Python", "C++", "JavaScript",
        "Dart", "Swift", "Go", "Ruby", "R",
        "PHP", "C#", "TypeScript", "Shell", "SQL",
        "Perl", "Rust", "Scala", "Haskell", "Lua",
        "Erlang", "Prolog", "Assembly", "Objective-C", "VBA"
    )
    private val dataListWithDesc = listOf(
        mapOf("title" to "Kotlin", "desc" to "Bahasa untuk Android modern"),
        mapOf("title" to "Java", "desc" to "Bahasa OOP yang populer"),
        mapOf("title" to "Python", "desc" to "Bahasa yang mudah dipahami"),
        mapOf("title" to "C++", "desc" to "Bahasa cepat untuk game dan aplikasi besar"),
        mapOf("title" to "JavaScript", "desc" to "Bahasa untuk membuat website jadi interaktif"),
        mapOf("title" to "Dart", "desc" to "Bahasa yang dipakai di Flutter"),
        mapOf("title" to "Swift", "desc" to "Bahasa untuk membuat aplikasi iPhone"),
        mapOf("title" to "Go", "desc" to "Bahasa buatan Google yang simpel dan ringan"),
        mapOf("title" to "Ruby", "desc" to "Bahasa dengan tulisan yang enak dibaca"),
        mapOf("title" to "PHP", "desc" to "Bahasa untuk membuat website di sisi server")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "More"

//        val adapter = ArrayAdapter(
//            requireContext(),
//            android.R.layout.simple_list_item_1,
//            dataList
//        )
//// Hubungkan listViewItems dengan adapter
//        binding.listViewItems.adapter = adapter
//// Aksi saat item diklik
//        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
//            val selectedItem = dataList[position]
//                Toast.makeText(requireContext(), "Kamu memilih: $selectedItem",
//                Toast.LENGTH_SHORT).show()
//        }

        val adapter = SimpleAdapter(
            requireContext(),
            dataListWithDesc,
            android.R.layout.simple_list_item_2,
            arrayOf("title", "desc"), // key yang diambil dari data
            intArrayOf(android.R.id.text1, android.R.id.text2) // tempat tampilnya
        )
        binding.listViewItems.adapter = adapter
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataListWithDesc[position]
            val title = selectedItem["title"]
            val desc = selectedItem["desc"]
            Toast.makeText(requireContext(), "Kamu memilih: $title ($desc)", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
