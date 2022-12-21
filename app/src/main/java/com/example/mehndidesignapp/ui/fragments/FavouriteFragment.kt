package com.example.mehndidesignapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mehndidesignapp.R
import com.example.mehndidesignapp.adapter.GenericSimpleRecyclerBindingInterface
import com.example.mehndidesignapp.adapter.SimpleGenericRecyclerAdapter
import com.example.mehndidesignapp.databinding.FragmentFavouriteBinding
import com.example.mehndidesignapp.fragmentUtils.FragmentUtils
import com.example.mehndidesignapp.model.SelectedDesignModelClass
import com.example.mehndidesignapp.viewModels.FavouriteViewModel


class FavouriteFragment : Fragment(), SimpleGenericRecyclerAdapter.onItemClickListener {
    private lateinit var favouriteViewModel: FavouriteViewModel
    lateinit var binding: FragmentFavouriteBinding
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var bindingInterface: GenericSimpleRecyclerBindingInterface<SelectedDesignModelClass>
    lateinit var favouriteDesignDataList: ArrayList<SelectedDesignModelClass>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModelInitializer()
        bindDataWithGenericAdapter()
        setDataInAdapter()
        backPressedButton()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun viewModelInitializer() {
        favouriteViewModel = ViewModelProvider(this).get(FavouriteViewModel::class.java)
        favouriteDesignDataList = ArrayList()

    }

    private fun setDataInAdapter() {
        favouriteViewModel.allUserFavouriteData.observe(viewLifecycleOwner, Observer { list ->
            favouriteDesignDataList = list as ArrayList<SelectedDesignModelClass>
            manager = GridLayoutManager(requireContext(), 2)
            binding.rvFavourite.apply {
                layoutManager = manager
            }
            val adapter = SimpleGenericRecyclerAdapter(favouriteDesignDataList,
                (R.layout.single_view_rv_selected_design),
                bindingInterface,
                this@FavouriteFragment)
            binding.rvFavourite.adapter = adapter
        })


    }

    private fun bindDataWithGenericAdapter() {
        bindingInterface =
            object : GenericSimpleRecyclerBindingInterface<SelectedDesignModelClass> {
                override fun bindData(item: SelectedDesignModelClass, view: View) {
                    val selectedMehndiImage: ImageView =
                        view.findViewById(R.id.selectedImageMehndiDesign)
                    selectedMehndiImage.setImageResource(item.selectedDesignImage)
                }
            }
    }

    override fun onClick(position: Int, ModelClass: Any) {

    }

    override fun onLongClick(position: Int, ModelClass: Any) {
    }


    private fun backPressedButton() {
        activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val fragment: Fragment = HomePageFragment()
                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                FragmentUtils.changeFragment(R.id.Fragment, fragment, fragmentManager)


            }
        })


    }


}