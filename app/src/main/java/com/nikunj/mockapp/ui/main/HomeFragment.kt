package com.nikunj.mockapp.ui.main

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikunj.mockapp.R
import com.nikunj.mockapp.local.ClassDatabase
import com.nikunj.mockapp.local.ClassesEntity
import com.nikunj.mockapp.model.*
import com.nikunj.mockapp.service.NetworkService
import com.nikunj.mockapp.ui.BaseFragment
import com.nikunj.mockapp.util.OnClickItemPackage
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : BaseFragment() {


    lateinit var viewModel: MainViewModel
    private var mainAdapter: MainAdapter? = null
    lateinit var api: NetworkService
    private var res: MutableList<MedicationsClasse>? = null
    var mList: MutableList<ClassesName> = ArrayList()
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//       val name= activity?.intent?.extras?.getString("name")
//       val date= activity?.intent?.extras?.getString("date")
//        Toast.makeText(requireContext(),"Welcome"+"    "+name.toString() +"    "+date.toString(), Toast.LENGTH_SHORT).show()

        createViewModel()
        observeViewModel()
        progress_bar_home.visibility = View.VISIBLE

        super.onViewCreated(view, savedInstanceState)

    }

    private fun observeViewModel() {

        viewModel.classList.observe(viewLifecycleOwner, Observer {
            it.data?.let { it1 -> mList.addAll(it1) }
            Log.d("mainview", it.data.toString())
            if (it.data != null) {
                mainAdapter = MainAdapter(requireContext(), it.data as MutableList<ClassesName>)

                val layoutManager = LinearLayoutManager(requireContext())
                packageRecycler.layoutManager = layoutManager
                packageRecycler.adapter = mainAdapter
                mainAdapter?.clickItemPackage = object : OnClickItemPackage {
                    override fun onClick(classesName: ClassesName, position: Int) {
                        launch {
                            context?.let {


                        classesName.name?.let { it1 ->
                            classesName.strength?.let { it2 ->
                                classesName.dose?.let { it3 ->
                                    ClassesEntity(
                                        it3,
                                        it1, it2
                                    )
                                }
                            }
                        }?.let { it2 -> ClassDatabase(it).getClassDao().addClass(it2) }




                            }
                        }
                    }

                }
            }
        })

        Handler().postDelayed({
            progress_bar_home.visibility = View.INVISIBLE
        }, 1500)


    }

    private fun createViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    }


}