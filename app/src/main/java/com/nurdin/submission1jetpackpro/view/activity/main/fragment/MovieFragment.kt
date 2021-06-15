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
import com.nurdin.submission1jetpackpro.data.response.MovieShow
import com.nurdin.submission1jetpackpro.utils.Factory
import com.nurdin.submission1jetpackpro.utils.Helper.MOVIE
import com.nurdin.submission1jetpackpro.view.activity.detail.DetailActivity
import com.nurdin.submission1jetpackpro.view.adapter.MvAdapter
import com.nurdin.submission1jetpackpro.viewModel.ContentViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private lateinit var adapter: MvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showLoading(true)
        adapter = MvAdapter()
        adapter.notifyDataSetChanged()

        val factory = Factory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[ContentViewModel::class.java]
        viewModel.getListMovie().observe(viewLifecycleOwner, { movies ->
            showLoading(false)
            adapter.setData(movies)
            showRecycle()
        })
    }
    private fun showRecycle() {
        rv_movie.layoutManager = GridLayoutManager(context,2)
        rv_movie.setHasFixedSize(true)
        rv_movie.adapter = adapter

        adapter.setOnItemClickCallback(object : MvAdapter.OnItemClickCallback{
            override fun onItemClicked(data: MovieShow) {
                showSelectedUser(data)
            }
        })
    }
    private fun showSelectedUser(data: MovieShow) {
        val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
        moveWithObjectIntent.putExtra(DetailActivity.DATA_OBJECT, data.id)
        moveWithObjectIntent.putExtra(DetailActivity.TYPE_OBJECT, MOVIE)
        startActivity(moveWithObjectIntent)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            mvProgressBar.visibility = View.VISIBLE
        } else {
            mvProgressBar.visibility = View.GONE
        }
    }
}