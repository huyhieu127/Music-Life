package com.kotlin.musiclife.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.musiclife.R
import com.kotlin.musiclife.models.TabLibraryClass

class TabLibraryAdapter(var context: Context, var listTabs: ArrayList<TabLibraryClass>) :
    RecyclerView.Adapter<TabLibraryAdapter.ViewHolder>() {

    lateinit var listener: OnClickItemListener

    fun setOnClickItemListener(listener: OnClickItemListener) {
        this.listener = listener
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.tvTitleTab)
        var fltab: FrameLayout = itemView.findViewById(R.id.flTab)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_tab_library,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listTabs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = listTabs[position].title
        if (listTabs[position].isChecked) {
            holder.tvTitle.setTextColor(context.getColor(R.color.colorWhite))
            holder.tvTitle.background = context.getDrawable(R.drawable.bg_gradient)
        } else {
            holder.tvTitle.setTextColor(context.getColor(R.color.colorStartGradient))
            holder.tvTitle.setBackgroundColor(0)
            holder.tvTitle.setOnClickListener {
                for (i in 0 until itemCount) {
                    if (listTabs[i].isChecked) {
                        listTabs[i].isChecked = false
                    }
                }
                listTabs[position].isChecked = true
                listener.onClick(position)
                notifyDataSetChanged()
            }
        }
        if (position == 0) {
            holder.fltab.setPadding(60, 0, 0, 0)
        }
        if (position == itemCount - 1) {
            holder.fltab.setPadding(0, 0, 60, 0)
        }
    }
    interface OnClickItemListener{
        fun onClick(position: Int)
    }
}
