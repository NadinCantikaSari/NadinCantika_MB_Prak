package com.example.pertemuan3_tia.Home.pertemuan9

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan3_tia.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Pertemuan 9"
        binding.toolbar.setNavigationIcon(com.example.pertemuan3_tia.R.drawable.ic_arrow_back)
        binding.toolbar.setNavigationOnClickListener { finish() }

        binding.btnLogin.setOnClickListener {
            val nama = binding.etNamaPelanggan.text?.toString()?.trim().orEmpty()
            if (nama.isBlank()) {
                binding.textInputLayout.error = "Nama pelanggan harus diisi"
            } else {
                binding.textInputLayout.error = null
                Toast.makeText(this, "Nama pelanggan: $nama", Toast.LENGTH_SHORT).show()
            }
        }

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedId = checkedIds.firstOrNull()
            if (selectedId != null) {
                val chip = group.findViewById<Chip>(selectedId)
                Toast.makeText(this, "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnEspresso.setOnClickListener { toastMenu("Espresso") }
        binding.btnLatte.setOnClickListener { toastMenu("Latte") }
        binding.btnCappuccino.setOnClickListener { toastMenu("Cappuccino") }
        binding.btnAmericano.setOnClickListener { toastMenu("Americano") }
        binding.btnMocha.setOnClickListener { toastMenu("Mocha") }
        binding.btnKopiSusu.setOnClickListener { toastMenu("Kopi Susu") }
    }

    private fun toastMenu(nama: String) {
        Toast.makeText(this, "Kamu memilih $nama", Toast.LENGTH_SHORT).show()
    }
}

