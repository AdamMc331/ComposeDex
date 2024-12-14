package com.adammcneilly.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.adammcneilly.pokedex.home.HomeNavigationContainer
import com.adammcneilly.pokedex.home.HomeTab
import com.adammcneilly.pokedex.pokemonlist.PokemonListScreen
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
                var selectedTab by remember {
                    mutableStateOf(HomeTab.Pokemon)
                }

                HomeNavigationContainer(
                    selectedTab = selectedTab,
                    onTabChanged = { tab ->
                        selectedTab = tab
                    },
                ) {
                    Scaffold { scaffoldPadding ->
                        PokemonListScreen(
                            contentPadding = scaffoldPadding,
                            modifier = Modifier
                                .fillMaxSize(),
                        )
                    }
                }
            }
        }
    }
}
