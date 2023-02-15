package com.volozhinsky.cathunter.ui.select_breed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.volozhinsky.cathunter.R
import com.volozhinsky.cathunter.ui.models.CatBreedUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectBreedFragment : Fragment() {

    private val catBreedViewModel by viewModels<SelectBreedViewModel>()
    private var listbreed: List<CatBreedUI>? = null

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
            emptyList<String>()
        )
        spinner.adapter = spinerAdapter
        catBreedViewModel.breedListLiveData.observe(viewLifecycleOwner) { listBreedLd ->
            listbreed = listBreedLd
            val spinerAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                listBreedLd.map{
                    it.name
                }
            )
            spinner.adapter = spinerAdapter
        }
        view.findViewById<Button>(R.id.buttonShowCat).setOnClickListener{
            listbreed?.let {
                startRandomCatFragment(it[spinner.selectedItemPosition].id)
            }
        }
        catBreedViewModel.getBreedList()
    }

    fun startRandomCatFragment(id: String){
        val action = SelectBreedFragmentDirections.actionSelectBreedFragmentToRandomCatFragment(id)
        findNavController().navigate(action)
    }
}