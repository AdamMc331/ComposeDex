package com.adammcneilly.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.adammcneilly.pokedex.list.PokemonListScreen
import com.adammcneilly.pokedex.ui.theme.DexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()

            DexTheme {
                Scaffold { scaffoldPadding ->
                    PokemonListScreen(
                        modifier = Modifier
                            .padding(scaffoldPadding),
                    )
                }
            }
        }
    }
}
