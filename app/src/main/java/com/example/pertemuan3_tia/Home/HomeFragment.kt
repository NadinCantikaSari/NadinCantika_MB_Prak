
package com.example.pertemuan3_tia.Home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pertemuan3_tia.DetailActivity
import com.example.pertemuan3_tia.Home.Pertemuan6.EnamActivity
import com.example.pertemuan3_tia.Home.pertemuan5.LimaActivity
import com.example.pertemuan3_tia.Home.pertemuan9.NinthActivity
import com.example.pertemuan3_tia.LoginActivity
import com.example.pertemuan3_tia.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Toolbar
        (requireActivity() as AppCompatActivity)
            .setSupportActionBar(binding.toolbar)

        (requireActivity() as AppCompatActivity)
            .supportActionBar?.title = "Home"

        // Sapaan pengguna dari SharedPreferences
        val sharedPref = requireContext()
            .getSharedPreferences("user_pref", Context.MODE_PRIVATE)

        val username = sharedPref.getString("username", "Pengguna")
        binding.tvWelcome.text = "Halo, $username"
        binding.textView.text = username
        binding.textView2.text = "••••••••"

        // Tombol Snackbar
        binding.SnackBar.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Halo ini snackbar",
                Snackbar.LENGTH_LONG
            ).setAction("KEMBALI") {
                Toast.makeText(
                    requireContext(),
                    "Kembali ke halaman Activity",
                    Toast.LENGTH_LONG
                ).show()
            }.show()
        }

        // Tombol Alert Dialog
        binding.Alert.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }

        // Tombol Detail
        binding.btnDetail.setOnClickListener {
            startActivity(
                Intent(requireContext(), DetailActivity::class.java)
            )
        }

        // Tombol Pertemuan 5
        binding.btnToLima.setOnClickListener {
            startActivity(
                Intent(requireContext(), LimaActivity::class.java)
            )
        }

        // Tombol Pertemuan 6
        binding.btnToEnam.setOnClickListener {
            startActivity(
                Intent(requireContext(), EnamActivity::class.java)
            )
        }

        // Tombol Pertemuan 9
        binding.btnToNinth.setOnClickListener {
            startActivity(
                Intent(requireContext(), NinthActivity::class.java)
            )
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    sharedPref.edit().clear().apply()
                    dialog.dismiss()

                    val intent = Intent(
                        requireContext(),
                        LoginActivity::class.java
                    )

                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK

                    startActivity(intent)
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
