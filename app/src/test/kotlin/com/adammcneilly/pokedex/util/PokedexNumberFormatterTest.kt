package com.adammcneilly.pokedex.util

import com.google.common.truth.Truth.assertThat
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class PokedexNumberFormatterTest {
    @Test
    fun `throw if negative number`() {
        assertThrows(IllegalArgumentException::class.java) {
            PokedexNumberFormatter.format(-1)
        }
    }

    @Test
    fun `throw if zero`() {
        assertThrows(IllegalArgumentException::class.java) {
            PokedexNumberFormatter.format(0)
        }
    }

    @Test
    fun format(
        @TestParameter testCase: FormatTestCase,
    ) {
        val output = PokedexNumberFormatter.format(testCase.inputId)
        assertThat(output).isEqualTo(testCase.expectedOutput)
    }

    enum class FormatTestCase(
        val inputId: Int,
        val expectedOutput: String,
    ) {
        SINGLE_DIGIT(
            inputId = 1,
            expectedOutput = "001",
        ),
        DOUBLE_DIGIT(
            inputId = 10,
            expectedOutput = "010",
        ),
        TRIPLE_DIGIT(
            inputId = 100,
            expectedOutput = "100",
        ),
        QUADRUPLE_DIGIT(
            inputId = 1000,
            expectedOutput = "1000",
        ),
    }
}
