package com.submission.roomminiproject.Activity.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.submission.roomminiproject.Activity.ArticleAddUpdateActivity
import com.submission.roomminiproject.Adapter.ArticleAdapter
import com.submission.roomminiproject.Model.Article
import com.submission.roomminiproject.R
import com.submission.roomminiproject.ViewModel.MainViewModel
import com.submission.roomminiproject.databinding.ActivityMainBinding
import com.submission.roomminiproject.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var mAdaper: ArticleAdapter?= null
    private val mainViewModel by viewModel<MainViewModel>()
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initView()
        observeLiveData()

        binding?.fabAdd?.setOnClickListener { view ->
            if (view.id == R.id.fab_add) {
                val intent = Intent(requireActivity(), ArticleAddUpdateActivity::class.java)
                startActivityForResult(intent, ArticleAddUpdateActivity.REQUEST_ADD)
            }
        }

        return root
    }

    private fun observeLiveData() {
        mainViewModel?.getAllArticleList()?.observe(viewLifecycleOwner, Observer {
            initAdapter(it)
        })
    }

    private fun initAdapter(it: List<Article>?) {
        mAdaper = ArticleAdapter(requireActivity())
        binding?.rvNotes?.adapter = mAdaper
        if (it != null) {
            mAdaper?.setListArticle(it)
        }
    }

    private fun initView() {
        binding?.rvNotes?.layoutManager = LinearLayoutManager(requireActivity())
        binding?.rvNotes?.setHasFixedSize(true)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}