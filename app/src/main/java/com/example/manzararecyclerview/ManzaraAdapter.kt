package com.example.manzararecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_satir_manzara.view.*


class ManzaraAdapter(tumManzaralar:ArrayList<manzara>) : RecyclerView.Adapter<ManzaraAdapter.ManzaraViewHolder>() {

     var manzaralar = tumManzaralar

    override fun getItemCount(): Int {

        return manzaralar.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraViewHolder {

        var inflater = LayoutInflater.from(parent.context)
        var tekSatırManzara = inflater.inflate(R.layout.tek_satir_manzara,parent,false)

        return ManzaraViewHolder(tekSatırManzara)

    }


    override fun onBindViewHolder(holder: ManzaraViewHolder, position: Int) {

        var oAnkiNesne = manzaralar.get(position)
        holder.setData(oAnkiNesne,position)

       /* holder?.manzaraBaslık.text = manzaralar.get(position).baslık
        holder?.manzaraAcıklama.text = manzaralar.get(position).acıklama
        holder?.manzaraResim.setImageResource(manzaralar.get(position).resim)*/

    }


    inner class ManzaraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tekSatırManzara = itemView as CardView

        var manzaraBaslık = tekSatırManzara.txtViewManzara
        var manzaraAcıklama = tekSatırManzara.txtViewManzaraAcıklama
        var manzaraResim = tekSatırManzara.imgManzara

        var btnKopyala = tekSatırManzara.imgEkle
        var btnSil = tekSatırManzara.imgSil


        fun setData(currentNesne: manzara, position: Int) {
            manzaraResim.setImageResource(currentNesne.resim)
            manzaraAcıklama.setText(currentNesne.acıklama)
            manzaraBaslık.setText(currentNesne.baslık)


            btnKopyala.setOnClickListener {

                manzaralar.add(position,currentNesne)
                notifyItemInserted(position)
                notifyItemRangeChanged(position,manzaralar.size)
            }

            btnSil.setOnClickListener {
                btnSil.isClickable = false
                manzaralar.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,manzaralar.size)

            }

        }
    }



}

