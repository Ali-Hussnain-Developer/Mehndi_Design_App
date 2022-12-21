package com.example.mehndidesignapp.ui.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.mehndidesignapp.BuildConfig
import com.example.mehndidesignapp.R
import com.example.mehndidesignapp.constants.Constants
import com.example.mehndidesignapp.databinding.FragmentSingleDesignBinding
import com.example.mehndidesignapp.fragmentUtils.FragmentUtils
import com.example.mehndidesignapp.model.SelectedDesignModelClass
import com.example.mehndidesignapp.viewModels.FavouriteViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream


class SingleDesignFragment : Fragment() {
    lateinit var binding: FragmentSingleDesignBinding
    private lateinit var favouriteViewModel: FavouriteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSingleDesignBinding.inflate(inflater, container, false)
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = this.arguments
        val picture = bundle?.getInt(Constants.Position)!!
        binding.imgSelectedDesign.setImageResource(picture)
        clickListener(picture)
        viewModelInitializer()
        backPressedButton()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun viewModelInitializer() {
        favouriteViewModel = ViewModelProvider(this).get(FavouriteViewModel::class.java)

    }


    private fun clickListener(picture: Int) {
        binding.toolBarMehndiDesign.imgFavourite.setOnClickListener {
            val fragment: Fragment = FavouriteFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            FragmentUtils.changeFragment(R.id.Fragment, fragment, fragmentManager)
        }
        binding.btnFavourite.setOnClickListener {
            Toast.makeText(requireContext(),
                getString(R.string.txt_add_favourite),
                Toast.LENGTH_LONG).show()
            favouriteViewModel.insertRecord(SelectedDesignModelClass(0, picture))
        }

        binding.btnShare.setOnClickListener {
            val bit = BitmapFactory.decodeResource(requireContext().resources, picture)
            val filesDir = requireContext().applicationContext.filesDir
            val imageFile = File(filesDir, Constants.DesignPNG)
            val os: OutputStream
            try {
                os = FileOutputStream(imageFile)
                bit.compress(Bitmap.CompressFormat.PNG, 100, os)
                os.flush()
                os.close()
            } catch (e: Exception) {
                Log.e(javaClass.simpleName, getString(R.string.txt_error_bitmap), e)
            }

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION

            val imageUri: Uri =
                FileProvider.getUriForFile(requireContext(), BuildConfig.APPLICATION_ID, imageFile)

            intent.putExtra(Intent.EXTRA_STREAM, imageUri)
            intent.type = Constants.Image
            requireContext().startActivity(intent)

        }


    }


    private fun backPressedButton() {
        activity?.onBackPressedDispatcher?.addCallback(object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val fragment: Fragment = SelectedDesignFragment()
                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                FragmentUtils.changeFragment(R.id.Fragment, fragment, fragmentManager)
            }
        })


    }
}