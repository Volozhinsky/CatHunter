package com.volozhinsky.cathunter.ui.select_breed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.volozhinsky.cathunter.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectBreedFragment : Fragment() {

    val catBreedViewModel by viewModels<SelectBreedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_select_breed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner = view.findViewById<Spinner>(R.id.spinnerBreed)
        val spinerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            emptyList<Spinner>()
        )
        spinner.adapter = spinerAdapter
        catBreedViewModel.breedListLiveData.observe(viewLifecycleOwner) { listBreed ->
            val spinerAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                listBreed.map{
                    it.name
                }
            )
            spinner.adapter = spinerAdapter
            spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    startRandomCatFragment(listBreed[p2].id)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
            catBreedViewModel.getBreedList()

        }
    }

    fun startRandomCatFragment(id: String){
        val action = SelectBreedFragmentDirections.actionSelectBreedFragmentToRandomCatFragment(id)
        findNavController().navigate(action)
    }
}