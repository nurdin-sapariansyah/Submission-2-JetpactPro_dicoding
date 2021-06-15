package com.nurdin.submission1jetpackpro.view.activity.main.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nurdin.submission1jetpackpro.R
import com.nurdin.submission1jetpackpro.data.response.TvShow
import com.nurdin.submission1jetpackpro.utils.Factory
import com.nurdin.submission1jetpackpro.utils.Helper.TV_SHOW
import com.nurdin.submission1jetpackpro.view.activity.detail.DetailActivity
import com.nurdin.submission1jetpackpro.view.adapter.TvAdapter
import com.nurdin.submission1jetpackpro.viewModel.ContentViewModel
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {
    private lateinit var adapter: TvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(true)
        adapter = TvAdapter()
        adapter.notifyDataSetChanged()

        val factory = Factory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[ContentViewModel::class.java]
        viewModel.getListTvShow().observe(viewLifecycleOwner, { tvShow ->
            showLoading(false)
            adapter.setData(tvShow)
            showRecycle()
        })
    }
    private fun showRecycle() {
        rv_tvShow.layoutManager = GridLayoutManager(context,2)
        rv_tvShow.setHasFixedSize(true)
        rv_tvShow.adapter = adapter

        adapter.setOnItemClickCallback(object : TvAdapter.OnItemClickCallback{
            override fun onItemClicked(data: TvShow) {
                showSelectedUser(data)
            }
        })
    }
    private fun showSelectedUser(data: TvShow) {
        val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
        moveWithObjectIntent.putExtra(DetailActivity.DATA_OBJECT, data.id)
        moveWithObjectIntent.putExtra(DetailActivity.TYPE_OBJECT, TV_SHOW)
        startActivity(moveWithObjectIntent)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            tvProgressBar.visibility = View.VISIBLE
        } else {
            tvProgressBar.visibility = View.GONE
        }
    }
}