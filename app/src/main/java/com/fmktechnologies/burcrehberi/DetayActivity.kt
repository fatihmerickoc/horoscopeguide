package com.fmktechnologies.burcrehberi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)



        var position = intent.extras?.get("tiklanilanOgePosition") as Int
        var tumBurcBilgileri = intent.extras?.get("tumBurcBilgileri")as ArrayList<Burc>
      //  Toast.makeText(this,"Tiklanilan oge pos : " +position,Toast.LENGTH_LONG).show()
      //  detaytext.setText(tumBurcBilgileri.get(position as Int).burcOzellik)
        tvBurcOzellikleri.setText(tumBurcBilgileri.get(position).burcOzellik)
            header.setImageResource(tumBurcBilgileri.get(position).burcBuyukSembol)

        setSupportActionBar(anim_toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

       collapsing_toolbar.title = tumBurcBilgileri.get(position).burcAdi
       // burcTitle.setText(tumBurcBilgileri.get(position).burcAdi)



        var bitmap = BitmapFactory.decodeResource(resources,tumBurcBilgileri.get(position).burcBuyukSembol)

        Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{

            override fun onGenerated(palette: Palette?) {

                var color = palette!!.getVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color)

                window.statusBarColor = color


            }

        })

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()


    }







}
