package com.example.mehndidesignapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mehndidesignapp.R
import com.example.mehndidesignapp.adapter.GenericSimpleRecyclerBindingInterface
import com.example.mehndidesignapp.adapter.SimpleGenericRecyclerAdapter
import com.example.mehndidesignapp.constants.Constants
import com.example.mehndidesignapp.databinding.FragmentHomePageBinding
import com.example.mehndidesignapp.fragmentUtils.FragmentUtils
import com.example.mehndidesignapp.model.HomePageModelClass
import com.example.mehndidesignapp.viewModels.HomePageViewModel


class HomePageFragment : Fragment(), SimpleGenericRecyclerAdapter.onItemClickListener {
    lateinit var homePageViewModel: HomePageViewModel
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var binding: FragmentHomePageBinding
    lateinit var bindingInterface: GenericSimpleRecyclerBindingInterface<HomePageModelClass>
    lateinit var homePageDataList: ArrayList<HomePageModelClass>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }


    override fun onLongClick(position: Int, ModelClass: Any) {

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModelInitialization()
        bindDataWithGenericAdapter()
        setDataInAdapter()
        backPressedButton()
        clickListener()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun clickListener() {
        binding.toolBarMehndiDesign.imgFavourite.setOnClickListener {
            val fragment: Fragment = FavouriteFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            FragmentUtils.changeFragment(R.id.Fragment, fragment, fragmentManager)
        }


    }

    private fun viewModelInitialization() {

        homePageViewModel = ViewModelProvider(this).get(HomePageViewModel::class.java)

    }


    private fun bindDataWithGenericAdapter() {
        bindingInterface =
            object : GenericSimpleRecyclerBindingInterface<HomePageModelClass> {
                override fun bindData(item: HomePageModelClass, view: View) {
                    val mehndiTitle: TextView = view.findViewById(R.id.tvMehndiTitle)
                    mehndiTitle.text = item.mehndiTitle
                    val mehndiImage: ImageView = view.findViewById(R.id.imgMehndiDesign)
                    mehndiImage.setImageResource(item.mehndiImage)
                }
            }
    }

    private fun setDataInAdapter() {
        homePageDataList = ArrayList()
        manager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewHomePage.apply {
            layoutManager = manager
        }
        val adapter = SimpleGenericRecyclerAdapter(homePageViewModel.homePageListData,
            R.layout.single_row_rv_main_page,
            bindingInterface,
            this@HomePageFragment)
        binding.recyclerViewHomePage.adapter = adapter


    }

    override fun onClick(position: Int, ModelClass: Any) {
        val bundle = Bundle()
        bundle.putInt(Constants.Position, position)
        val fragment: Fragment = SelectedDesignFragment()
        fragment.setArguments(bundle)
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        FragmentUtils.changeFragment(R.id.Fragment, fragment, fragmentManager)

    }


    private fun backPressedButton() {
        activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().moveTaskToBack(true)
                requireActivity().finish()

            }
        })


    }


}