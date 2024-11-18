package com.adammcneilly.pokedex

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paparazzi.Paparazzi
import com.adammcneilly.pokedex.theme.DexTheme
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Rule
import org.junit.runner.RunWith

/**
 * This base class allows us to write Paparazzi tests that validate composable content in both light and dark theme
 * using a parameterized test. Just extend this base class and call [snapshotScreen] with your composable content.
 */
@RunWith(TestParameterInjector::class)
abstract class BasePaparazziTest {
    @get:Rule
    val paparazzi = Paparazzi()

    @TestParameter
    val useDarkTheme: Boolean = false

    /**
     * Validates the supplied [content] in both light and dark theme.
     */
    fun snapshotScreen(content: @Composable () -> Unit) {
        paparazzi.snapshot {
            DexTheme(
                darkTheme = useDarkTheme,
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(DexTheme.dimensions.screenPadding),
                    ) {
                        content()
                    }
                }
            }
        }
    }
}
