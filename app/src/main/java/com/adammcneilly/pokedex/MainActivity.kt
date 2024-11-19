package com.adammcneilly.pokedex

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import com.adammcneilly.pokedex.data.remote.ApolloPokeAPIService
import com.adammcneilly.pokedex.theme.DexTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var repository: ApolloPokeAPIService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repository
            .observePokemonList()
            .onEach {
                Log.d("ADAMLOG", it.toString())
            }.launchIn(lifecycleScope)

        setContent {
            enableEdgeToEdge()

            DexTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
