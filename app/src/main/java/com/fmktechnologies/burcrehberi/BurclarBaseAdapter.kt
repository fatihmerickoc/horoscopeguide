package com.fmktechnologies.burcrehberi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.teksatir.view.*
import kotlin.coroutines.coroutineContext

class BurclarBaseAdapter(context: Context,tumBurcBilgileri : ArrayList<Burc>) : BaseAdapter() {

    var tumBurclar:ArrayList<Burc>
    var context  : Context

    init {
        tumBurclar = tumBurcBilgileri
        this.context = context
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

       var  teksatir_view = convertView
        var viewHolder : ViewHolder2

        if (teksatir_view == null){
            var inflater = LayoutInflater.from(context)
            teksatir_view  = inflater.inflate(R.layout.teksatir,parent,false)
            viewHolder = ViewHolder2(teksatir_view)
            teksatir_view.tag = viewHolder
        }
        else{
            viewHolder = teksatir_view.getTag()as ViewHolder2

        }




        viewHolder.burcresim.setImageResource(tumBurclar.get(position).burcSembol)
        viewHolder.burcAdi.setText(tumBurclar.get(position).burcAdi)
        viewHolder.burcTarih.setText(tumBurclar.get(position).burcTarih)

        return teksatir_view


    }

    override fun getItem(position: Int): Any {
       return tumBurclar.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return tumBurclar.size
    }

}

class ViewHolder2(teksatir_view : View){

    var burcresim:ImageView
    var burcAdi :TextView
    var burcTarih : TextView
    init {
        this.burcresim = teksatir_view.imgBurcSembol
        this.burcAdi = teksatir_view.tvBurcAdi
        this.burcTarih = teksatir_view.tvBurcTarih
    }

}