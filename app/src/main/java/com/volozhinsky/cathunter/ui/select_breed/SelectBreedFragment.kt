package com.volozhinsky.cathunter.ui.select_breed

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.volozhinsky.cathunter.CatHunterApp
import com.volozhinsky.cathunter.R
import com.volozhinsky.cathunter.di.ViewModelFactory
import com.volozhinsky.cathunter.ui.BroadCastRec
import com.volozhinsky.cathunter.ui.models.CatBreedUI
import javax.inject.Inject

class SelectBreedFragment : Fragment() {

    private lateinit var br: BroadcastReceiver

    @Inject
    lateinit var factory: ViewModelFactory
    private val catBreedViewModel: SelectBreedViewModel by viewModels {factory}
    private var listbreed: List<CatBreedUI>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireContext().applicationContext as CatHunterApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBroadcastReceiver()
        return inflater.inflate(R.layout.fragment_select_breed, container, false)
    }

    private fun registerBroadcastReceiver() {
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        br = BroadCastRec()
        val resflags = ContextCompat.RECEIVER_EXPORTED
        ContextCompat.registerReceiver(requireContext(),br,filter,resflags)
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
                listBreedLd.map {
                    it.name
                }
            )
            spinner.adapter = spinerAdapter
        }
        view.findViewById<Button>(R.id.buttonShowCat).setOnClickListener {
            listbreed?.let {
                startRandomCatFragment(it[spinner.selectedItemPosition].id)
            }
        }
        catBreedViewModel.getBreedList()
    }

    fun startRandomCatFragment(id: String) {
        val action = SelectBreedFragmentDirections.actionSelectBreedFragmentToRandomCatFragment(id)
        findNavController().navigate(action)
    }
}