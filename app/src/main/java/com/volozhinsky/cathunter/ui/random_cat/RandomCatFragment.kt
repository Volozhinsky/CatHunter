package com.volozhinsky.cathunter.ui.random_cat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.volozhinsky.cathunter.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomCatFragment : Fragment() {

    private val randomCatViewModel by viewModels<RandomCatViewModel>()
    val args: RandomCatFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_random_cat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomCatViewModel.catLiveData.observe(viewLifecycleOwner){
            Glide.with(requireContext()).load(it.catUrl).into(view.findViewById(R.id.imageViewRandomCat))
        }
        randomCatViewModel.getRandomCat(args.idBreed)
    }
}