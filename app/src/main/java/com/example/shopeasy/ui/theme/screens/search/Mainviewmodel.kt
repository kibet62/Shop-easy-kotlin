package com.example.shopeasy.ui.theme.screens.search

import android.app.DownloadManager.Query
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

@OptIn(FlowPreview::class)
class Mainviewmodel:ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _issearching =  MutableStateFlow(false)
    val issearching = _issearching.asStateFlow()

    private val _items = MutableStateFlow(allitems)
    val items = searchText
        .debounce(1000L)
        .onEach { _issearching.update { true } }
        .combine(_items){ text, items->
            if (text.isBlank()){
                items
            }else{
                delay(1500L)
                items.filter {
                    it.doesMatchsearchQuery(text)
                }
            }

        }
        .onEach { _issearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _items.value
        )


    fun onsearchTextchange(text: String){
        _searchText.value = text

    }
}
data class items(
    val itemname:String
){
    fun doesMatchsearchQuery(query: String):Boolean{
        val matchingCombinations = listOf(
            "$itemname",
            "${itemname.first()}",
            "${itemname.last()}",
        )
        return matchingCombinations.any {
            it.contains(query, ignoreCase = true)
        }

    }
}
private val allitems = listOf(
    items(
        itemname = "tv"
    ),
    items(
        itemname = "Audio"
    ),
    items(
        itemname = "sporting"
    ),
    items(
        itemname = "computing"
    ),
    items(
        itemname = "phones&tablets"
    ),
    items(
        itemname = "supermarket"
    ),
    items(
        itemname = "health&beauty"
    ),
    items(
        itemname = "Home&office"
    ),
    items(
        itemname = "Automible"
    ),
    items(
        itemname = "fasion"
    ),
    items(
        itemname = "kitchen appliance"
    ),
    items(
        itemname = "Gaming"
    ),
    items(
        itemname = "Babyproducts"
    ),
    items(
        itemname = "Books"
    ),
    items(
        itemname = "Gardening"
    ),
    items(
        itemname = "food"
    ),


)

