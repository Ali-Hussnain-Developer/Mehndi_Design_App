package com.example.mehndidesignapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
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
import com.example.mehndidesignapp.databinding.FragmentSelectedDesignBinding
import com.example.mehndidesignapp.fragmentUtils.FragmentUtils
import com.example.mehndidesignapp.model.SelectedDesignModelClass
import com.example.mehndidesignapp.viewModels.SelectedDesignViewModel

class SelectedDesignFragment : Fragment(), SimpleGenericRecyclerAdapter.onItemClickListener {
    lateinit var selectedDesignViewModel: SelectedDesignViewModel
    lateinit var manager: RecyclerView.LayoutManager
    lateinit var binding: FragmentSelectedDesignBinding
    lateinit var bindingInterface: GenericSimpleRecyclerBindingInterface<SelectedDesignModelClass>
    lateinit var selectedDesignDataList: ArrayList<SelectedDesignModelClass>
    var position: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSelectedDesignBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }


    override fun onLongClick(position: Int, ModelClass: Any) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModelInitialization()
        bindDataWithGenericAdapter()
        selectedDesignData()
        clickLisstener()
        backPressedButton()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun clickLisstener() {

        binding.toolBarMehndiDesign.imgFavourite.setOnClickListener {
            val fragment: Fragment = FavouriteFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            FragmentUtils.changeFragment(R.id.Fragment, fragment, fragmentManager)
        }
    }

    private fun selectedDesignData() {
        val bundle = this.arguments
        position = bundle?.getInt(Constants.Position)!!
        if (position == 0) {
            setDataInAdapter(selectedDesignViewModel.backHandListData)
        } else if (position == 1) {
            setDataInAdapter(selectedDesignViewModel.frontHandListData)
        } else if (position == 2) {
            setDataInAdapter(selectedDesignViewModel.golTikkiListData)
        } else if (position == 3) {
            setDataInAdapter(selectedDesignViewModel.fingerListData)
        } else if (position == 4) {
            setDataInAdapter(selectedDesignViewModel.armListData)
        } else if (position == 5) {
            setDataInAdapter(selectedDesignViewModel.footListData)
        } else if (position == 6) {
            setDataInAdapter(selectedDesignViewModel.weddingListData)
        } else if (position == 7) {
            setDataInAdapter(selectedDesignViewModel.eidSpecialListData)
        } else {
            Toast.makeText(requireContext(), getString(R.string.txt_app_title), Toast.LENGTH_LONG)
                .show()
        }

    }

    private fun viewModelInitialization() {

        selectedDesignViewModel = ViewModelProvider(this).get(SelectedDesignViewModel::class.java)

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

    private fun setDataInAdapter(list: ArrayList<SelectedDesignModelClass>) {
        selectedDesignDataList = ArrayList()
        selectedDesignDataList = list
        manager = GridLayoutManager(requireContext(), 2)
        binding.rvSelectedDesign.apply {
            layoutManager = manager
        }
        val adapter = SimpleGenericRecyclerAdapter(list,
            (R.layout.single_view_rv_selected_design),
            bindingInterface,
            this@SelectedDesignFragment)
        binding.rvSelectedDesign.adapter = adapter


    }

    override fun onClick(position: Int, ModelClass: Any) {
        val picture: Int = selectedDesignDataList.get(position).selectedDesignImage
        val bundle = Bundle()
        bundle.putInt(Constants.Position, picture)
        val fragment: Fragment = SingleDesignFragment()
        fragment.setArguments(bundle)
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        FragmentUtils.changeFragment(R.id.Fragment, fragment, fragmentManager)
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