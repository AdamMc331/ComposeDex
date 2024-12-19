package com.adammcneilly.pokedex.util

object PokemonImageURLGenerator {
    fun generateImageUrl(
        pokemonId: Int,
    ): String {
        val pokedexNumber = PokedexNumberFormatter.format(pokemonId)

        return "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$pokedexNumber.png"
    }

    /**
     * NOTE: At the moment, the below GLTF file does not work with scene viewer/GLTF 2.0, but leaving as a reference
     * until we find something we can replace this with.
     */
    fun generateGltfUrl(
        pokemonId: Int,
    ): String {
        val pokedexNumber = PokedexNumberFormatter.format(pokemonId)

        return "https://raw.githubusercontent.com/06wj/pokemon/refs/heads/master/models/$pokedexNumber/glTF/model.gltf"
    }
}
