package com.example.recycleview

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListView : AppCompatActivity() {
    private lateinit var lv_item : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        lv_item = findViewById(R.id.lv_Hewan)
        //listview
        //listview widget --> Adapter --> Data Source (Array List)

        //ArrayList
        val namaHewan = listOf("Gajah","ular","Beruang","Panda","Ikan","Sapi","Kambing")
        val ciriHewan = listOf(
            "Gajah adalah hewan yang kuat namun juga sangat peka dan cerdas yang hidup dalam kelompok keluarga dekat dan perhatian.",
            "Ular adalah kelompok reptilia tidak berkaki dan bertubuh panjang yang tersebar luas di dunia.",
            "Beruang adalah hewan besar dan kekar yang memiliki bulu tebal dan halus.",
            "Panda adalah hewan khas Cina, berbulu hitam dan putih.",
            "Ikan adalah hewan air yang hidup di laut dan sungai.",
            "Sapi adalah hewan ternak yang menghasilkan susu.",
            "Kambing adalah hewan ternak yang sering dijadikan daging kurban."
        )
        val tinggiHewan = listOf(
            "tinggi : 3 - 4 meter",
            "tinggi : 0,5 - 12 meter",
            "tinggi : 1,5 - 3 meter (berdiri tegak)",
            "tinggi : 60 - 90 cm (duduk), 1,2 - 1,8 meter (berdiri)",
            "tinggi : Bervariasi (misalnya paus bisa mencapai 30 meter)",
            "tinggi : 1,2 - 1,5 meter",
            "tinggi : 50 - 60 cm"
        )
        val beratHewan = listOf(
            "berat : 2.700 - 6.000 kg",
            "berat : 0,5 - 250 kg",
            "berat : 80 - 600 kg",
            "berat : 70 - 160 kg",
            "berat : Bervariasi (misalnya paus bisa mencapai 180.000 kg)",
            "berat : 400 - 1.000 kg",
            "berat : 20 - 140 kg"
        )

        val gambarHewan = listOf(
            R.drawable.gajah,
            R.drawable.ular,
            R.drawable.beruang,
            R.drawable.panda,
            R.drawable.ikan,
            R.drawable.sapi,
            R.drawable.kambing

        )
        //Memasukkan data array ke adapter
        lv_item.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, namaHewan)

        lv_item.setOnItemClickListener{
            parent,view, position, id ->
            Toast.makeText(this,"Anda Memilih : ${namaHewan[position]}",
                Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DetailHewan::class.java)


            intent.putExtra("namaHewan", namaHewan[position])
            intent.putExtra("ciriHewan", ciriHewan[position])
            intent.putExtra("tinggiHewan", tinggiHewan[position])
            intent.putExtra("beratHewan", beratHewan[position])
            intent.putExtra("gambarHewan", gambarHewan[position])



            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}