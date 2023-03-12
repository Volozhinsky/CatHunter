package com.volozhinsky.cathunter.ui.random_cat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volozhinsky.cathunter.domain.GetRandomCatOfTheBreedUseCase
import com.volozhinsky.cathunter.ui.mappers.CatUIMapper
import com.volozhinsky.cathunter.ui.models.CatUI
import kotlinx.coroutines.launch
import javax.inject.Inject

class RandomCatViewModel @Inject constructor(
    private val useCase: GetRandomCatOfTheBreedUseCase,
    private val mapper: CatUIMapper
) : ViewModel() {

    private var _catLiveData = MutableLiveData<CatUI>()
    val catLiveData: LiveData<CatUI> get() = _catLiveData

    fun getRandomCat(idBreed: String){
        viewModelScope.launch {
            _catLiveData.value = mapper(useCase.invoke(idBreed))
        }
    }
}