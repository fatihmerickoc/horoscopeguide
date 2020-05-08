package com.fmktechnologies.burcrehberi

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.teksatir.*

class MainActivity : AppCompatActivity() {


   lateinit var tumBurcBilgileri :ArrayList<Burc>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        veriKaynagiHazirla()


        var MyBaseAdapter = BurclarBaseAdapter(this,tumBurcBilgileri)
        listBurclar.adapter = MyBaseAdapter



        window.statusBarColor = Color.rgb(47,187,176)

        listBurclar.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetayActivity ::class.java)
            intent.putExtra("tiklanilanOgePosition",position)
            intent.putExtra("tumBurcBilgileri",tumBurcBilgileri)
            startActivity(intent)
        }



    }



    private fun veriKaynagiHazirla() {

        tumBurcBilgileri = ArrayList<Burc>(12)

        var burclar = resources.getStringArray(R.array.burcAdlari)

        var burcTarihleri = resources.getStringArray(R.array.burcTarihleri)
        var burcSembolleri = arrayOf(R.drawable.aries,R.drawable.taurus,R.drawable.gemini,R.drawable.cancer,R.drawable.leo,R.drawable.virgo,R.drawable.libra,R.drawable.scorpio,R.drawable.sagittarius,R.drawable.capricorn,R.drawable.aquarius,R.drawable.pisces)
        var burcBuyukSembol = arrayOf(R.drawable.koc_buyuk1,R.drawable.boga_buyuk2,R.drawable.ikizler_buyuk3,R.drawable.yengec_buyuk4,R.drawable.aslan_buyuk5,R.drawable.basak_buyuk6,R.drawable.terazi_buyuk7,R.drawable.akrep_buyuk8,R.drawable.yay_buyuk9,R.drawable.oglak_buyuk10,R.drawable.kova_buyuk11,R.drawable.balik_buyuk12)
        var burcGenelOzellikler = resources.getStringArray(R.array.burcGenelOzellikler)

        for(i in 0..11){
            var arraylisteAtanacakDegerler : Burc = Burc(burclar[i],burcTarihleri[i],burcSembolleri[i],burcBuyukSembol[i],burcGenelOzellikler[i])
            tumBurcBilgileri.add(arraylisteAtanacakDegerler)
        }


    }

}
