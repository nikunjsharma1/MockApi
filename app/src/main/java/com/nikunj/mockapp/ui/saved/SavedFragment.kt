package com.nikunj.mockapp.ui.saved

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikunj.mockapp.R
import com.nikunj.mockapp.local.ClassDatabase
import com.nikunj.mockapp.local.ClassesEntity
import com.nikunj.mockapp.model.ClassesName
import com.nikunj.mockapp.model.MedicationsClasse
import com.nikunj.mockapp.service.NetworkService
import com.nikunj.mockapp.ui.BaseFragment
import com.nikunj.mockapp.ui.main.MainAdapter
import com.nikunj.mockapp.ui.main.MainViewModel
import com.nikunj.mockapp.util.OnClickItemDelete
import com.nikunj.mockapp.util.OnClickItemPackage
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_saved.*
import kotlinx.coroutines.launch


class SavedFragment : BaseFragment() {
    lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createViewModel()
        viewModel.getAllClasses(requireContext())
        observeViewModel()

        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeViewModel() {
        viewModel.savedClassList.observe(viewLifecycleOwner, Observer {
            val layoutManager = LinearLayoutManager(requireContext())
            savedRecycler.layoutManager = layoutManager
            savedRecycler.adapter =
                SavedAdapter(requireContext(), it as MutableList<ClassesEntity>)
        })
    }

    private fun createViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    }
}