package com.example.shopeasy.ui.theme.screens.search

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopeasy.Navigation.ROUTE_AUDIO
import com.example.shopeasy.Navigation.ROUTE_AUTOMOBILE
import com.example.shopeasy.Navigation.ROUTE_BOOKS
import com.example.shopeasy.Navigation.ROUTE_COMPUTING
import com.example.shopeasy.Navigation.ROUTE_FASHION
import com.example.shopeasy.Navigation.ROUTE_FOOD
import com.example.shopeasy.Navigation.ROUTE_GAMING
import com.example.shopeasy.Navigation.ROUTE_GARDENING
import com.example.shopeasy.Navigation.ROUTE_HEALTH
import com.example.shopeasy.Navigation.ROUTE_KITCHEN
import com.example.shopeasy.Navigation.ROUTE_OFFICE
import com.example.shopeasy.Navigation.ROUTE_PHONES
import com.example.shopeasy.Navigation.ROUTE_SPORTING
import com.example.shopeasy.Navigation.ROUTE_SUPERMARKET
import com.example.shopeasy.Navigation.ROUTE_TV
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
    val itemname: String,
    val function: () -> Modifier
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
    ){ Modifier.clickable { ROUTE_TV }},
    items(
        itemname = "Audio"
    ) { Modifier.clickable { ROUTE_AUDIO } },
    items(
        itemname = "sporting"
    ) { Modifier.clickable { ROUTE_SPORTING } },
    items(
        itemname = "computing"
    ) { Modifier.clickable { ROUTE_COMPUTING } },
    items(
        itemname = "phones&tablets"
    ) { Modifier.clickable { ROUTE_PHONES }},
    items(
        itemname = "supermarket"
    ) { Modifier.clickable { ROUTE_SUPERMARKET } },
    items(
        itemname = "health&beauty"
    ) { Modifier.clickable { ROUTE_HEALTH }},
    items(
        itemname = "Home&office"
    ) { Modifier.clickable { ROUTE_OFFICE } },
    items(
        itemname = "Automible"
    ) { Modifier.clickable { ROUTE_AUTOMOBILE } },
    items(
        itemname = "fashion"
    ) { Modifier.clickable { ROUTE_FASHION } },
    items(
        itemname = "kitchen appliance"
    ) { Modifier.clickable { ROUTE_KITCHEN } },
    items(
        itemname = "Gaming"
    ) {Modifier.clickable { ROUTE_GAMING } },
    items(
        itemname = "Books"
    ) { Modifier.clickable { ROUTE_BOOKS } },
    items(
        itemname = "Gardening"
    ) { Modifier.clickable { ROUTE_GARDENING }},
    items(
        itemname = "food"
    ) { Modifier.clickable { ROUTE_FOOD } }


)

