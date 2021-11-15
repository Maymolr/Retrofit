package com.example.retrofitlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class ListAdapter(private val context: Context, private val mQuestions: List<Question>, private val mRowLayout: Int) : RecyclerView.Adapter<ListAdapter.QuestionViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(mRowLayout, parent, false)
            return QuestionViewHolder(view)
        }

        @SuppressLint("StringFormatInvalid")
        override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
            holder.positionNumber.text = context.resources.getString(R.string.question_num, position + 1)
            holder.title.text = context.resources.getString(R.string.questitle, mQuestions[position].title)
            holder.link.text = context.resources.getString(R.string.queslink, mQuestions[position].link)

            holder.containerView.setOnClickListener {
                Toast.makeText(context, "Clicked on: " + holder.title.text, Toast.LENGTH_SHORT).show();
            }
        }

        override fun getItemCount(): Int {
            return mQuestions.size
        }

        class QuestionViewHolder(val containerView: View) : RecyclerView.ViewHolder(containerView) {
            val positionNumber: TextView = containerView.findViewById(R.id.positionNumber)
            val title: TextView = containerView.findViewById(R.id.title)
            val link :TextView=containerView.findViewById(R.id.link)
        }
    }
