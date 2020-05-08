package com.fmktechnologies.burcrehberi

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.teksatir.view.*

class BurclarArrayAdapter( context: Context, resource: Int, textViewResourceId: Int,  var burcAdlari: Array<String>, var burcTarihleri : Array<String>, var burcResimleri : Array<Int>) : ArrayAdapter<String>(context, resource, textViewResourceId, burcAdlari) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        var viewHolder: ViewHolder

        var inflateedilenteksatir_view= convertView

        if(inflateedilenteksatir_view == null ){
            val inflater= LayoutInflater.from(context)
            inflateedilenteksatir_view=inflater.inflate(R.layout.teksatir,parent,false)
            viewHolder =  ViewHolder(inflateedilenteksatir_view)
            inflateedilenteksatir_view.tag = viewHolder


        }
        else{

            viewHolder = inflateedilenteksatir_view.getTag() as ViewHolder
          //  viewHolder =  ViewHolder(teksatir_view)

        }




        viewHolder.burcAdi.setText(burcAdlari[position])
        viewHolder.burcResim.setImageResource(burcResimleri[position])
        viewHolder.burcTarih.setText(burcTarihleri[position])






        return inflateedilenteksatir_view!!
    }

    class ViewHolder(teksatir_view : View){
        var burcAdi : TextView
        var burcTarih : TextView
        var burcResim : ImageView

        init {
            this.burcResim =teksatir_view.imgBurcSembol
            this.burcAdi = teksatir_view.tvBurcAdi
            this.burcTarih =teksatir_view.tvBurcTarih

        }
    }

}