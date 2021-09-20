package com.submission.roomminiproject.Helper

import androidx.recyclerview.widget.DiffUtil
import com.submission.roomminiproject.Model.Article

class ArticleDiffCallback(private val mOld: List<Article>, private val mNew: List<Article>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOld.size
    }

    override fun getNewListSize(): Int {
        return mNew.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return mOld[oldItemPosition].id == mNew[newItemPosition].id

    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       val oldTemp = mOld[oldItemPosition]
        val newTemp = mNew[newItemPosition]
        return oldTemp.title == newTemp.title &&
                oldTemp.description == newTemp.description
    }


}