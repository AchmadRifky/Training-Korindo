package com.submission.roomminiproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.submission.roomminiproject.Adapter.ArticleAdapter
import com.submission.roomminiproject.Model.Article
import com.submission.roomminiproject.ViewModel.MainViewModel
import com.submission.roomminiproject.ViewModel.ViewModelFactory
import com.submission.roomminiproject.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {


    private var binding: ActivityMainBinding? = null
    private var mAdaper: ArticleAdapter?= null
    private var mViewModel: MainViewModel?= null
    private val appPreferences: AppPreferences by inject()

    // test
    // test laptop


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val factory = ViewModelFactory.getInstance(application)
        mViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        initView()
        observeLiveData()

        val getTitle = appPreferences.getTitle()
//        Toast.makeText(this, getTitle, Toast.LENGTH_SHORT).show()


        binding?.fabAdd?.setOnClickListener { view ->
            if (view.id == R.id.fab_add) {
                val intent = Intent(this@MainActivity, ArticleAddUpdateActivity::class.java)
                startActivityForResult(intent, ArticleAddUpdateActivity.REQUEST_ADD)
            }
        }
//        EventBus.getDefault().register(this)
    }

    private fun observeLiveData() {
        mViewModel?.getAllArticleList()?.observe(this, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(it: List<Article>?) {
        mAdaper = ArticleAdapter(this@MainActivity)
        binding?.rvNotes?.adapter = mAdaper
        if (it != null) {
            mAdaper?.setListArticle(it)
        }
    }

    private fun initView() {
        binding?.rvNotes?.layoutManager = LinearLayoutManager(this)
        binding?.rvNotes?.setHasFixedSize(true)
    }

//    @Subscribe
//    fun onMessageEvent(article: Article){
//        showSnackbarMessage(article.description.toString())
//    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data != null) {
            if (requestCode == ArticleAddUpdateActivity.REQUEST_ADD) {
                    showSnackbarMessage(getString(R.string.added))
            } else if (requestCode == ArticleAddUpdateActivity.REQUEST_UPDATE) {
                if (resultCode == ArticleAddUpdateActivity.RESULT_UPDATE) {
                    showSnackbarMessage(getString(R.string.changed))
                } else if (resultCode == ArticleAddUpdateActivity.RESULT_DELETE) {
                    showSnackbarMessage(getString(R.string.deleted))
                }
            }
        }
    }

    private fun showSnackbarMessage(message: String) {
        Snackbar.make(binding?.root as View, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
//        EventBus.getDefault().unregister(this)
    }

}