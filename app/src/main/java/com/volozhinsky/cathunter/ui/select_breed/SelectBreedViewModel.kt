package com.volozhinsky.cathunter.ui.select_breed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.volozhinsky.cathunter.domain.GetBreedsListUseCase
import com.volozhinsky.cathunter.ui.mappers.CatBreedUIMapper
import com.volozhinsky.cathunter.ui.models.CatBreedUI
import kotlinx.coroutines.launch
import javax.inject.Inject

class SelectBreedViewModel @Inject constructor(
    private val useCase: GetBreedsListUseCase,
    private val breedUIMapper: CatBreedUIMapper
) : ViewModel() {

    private var _breedListLiveData = MutableLiveData<List<CatBreedUI>>()
    val breedListLiveData: LiveData<List<CatBreedUI>> get() = _breedListLiveData

    fun getBreedList() {
        viewModelScope.launch {
            _breedListLiveData.value = useCase.invoke().map { breedUIMapper(it) }
        }
    }
}