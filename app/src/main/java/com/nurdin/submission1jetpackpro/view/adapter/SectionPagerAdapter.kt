@file:Suppress("DEPRECATION")

package com.nurdin.submission1jetpackpro.view.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nurdin.submission1jetpackpro.R
import com.nurdin.submission1jetpackpro.view.activity.main.fragment.MovieFragment
import com.nurdin.submission1jetpackpro.view.activity.main.fragment.TvShowFragment

class SectionPagerAdapter (private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val tabTitle = intArrayOf(R.string.movie, R.string.tvShow)

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(tabTitle[position])
    }
    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> MovieFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }
    override fun getCount(): Int = tabTitle.size
}