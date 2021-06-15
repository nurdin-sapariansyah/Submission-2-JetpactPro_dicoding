package com.nurdin.submission1jetpackpro.view.activity.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.nurdin.submission1jetpackpro.R
import com.nurdin.submission1jetpackpro.model.DataDetail
import com.nurdin.submission1jetpackpro.utils.Factory
import com.nurdin.submission1jetpackpro.viewModel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.item_content.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val DATA_OBJECT = "data_object"
        const val TYPE_OBJECT = "type_object"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Detail Movie"
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = Factory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras !=null) {

            val idFilm = extras.getInt(DATA_OBJECT)
            val chooseFilm = extras.getString(TYPE_OBJECT)

            if (chooseFilm != null) {
                showLoading(true)

                viewModel.setDetailFilm(idFilm, chooseFilm)
                viewModel.getDetailData().observe(this, { detail ->
                    showLoading(false)
                    showData(detail)
                })
            }
        }
    }

    private fun showData(detail: DataDetail) {
        val genre = detail.genres.toString()
            .replace("[", "")
            .replace("]", "")

            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500" + detail.imageDetail)
                .transform(RoundedCorners(20))
                .error(R.drawable.video_player)
                .into(image_detail)

        text_title.text = detail.title
        text_released.text = detail.date
        text_genre.text = genre
        text_desc.text = detail.desc
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            dtProgressBar.visibility = View.VISIBLE
        } else {
            dtProgressBar.visibility = View.GONE
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}