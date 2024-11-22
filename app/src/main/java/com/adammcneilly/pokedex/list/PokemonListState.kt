package com.adammcneilly.pokedex.list

import com.adammcneilly.pokedex.data.DataRequest
import com.adammcneilly.pokedex.displaymodels.PokemonDisplayModel

data class PokemonListState(
    val request: DataRequest<List<PokemonDisplayModel>>,
)
