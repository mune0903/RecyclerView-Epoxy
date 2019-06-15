package com.github.mune0903.recyclerview_epoxy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mune0903.recyclerview_epoxy.R
import com.github.mune0903.recyclerview_epoxy.databinding.FragmentMainBinding
import com.github.mune0903.recyclerview_epoxy.util.factory.ViewModelFactory

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModelFactory: ViewModelFactory by lazy {
        ViewModelFactory()
    }

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    private val controller = MainItemController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.apply {
            getArticle()
            article.observe(this@MainFragment, Observer {
                controller.setData(MainItemController(it))
                binding.swipeRefresh.isRefreshing = false
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        binding = FragmentMainBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.swipeRefresh.isRefreshing = true
        setupRecyclerView()
        setupSwipeRefresh()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = controller.adapter
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.apply {
                getArticle()
                article.observe(this@MainFragment, Observer {
                    controller.setData(MainItemController(it))
                    binding.swipeRefresh.isRefreshing = false
                })
            }
        }
    }

    companion object {

        val TAG: String = MainFragment::class.java.simpleName

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}