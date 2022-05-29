package com.juliablack.domain

import com.juliablack.domain.model.Inhabitant
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SearchUseCaseTest {

    private lateinit var inhabitants: List<Inhabitant>
    private lateinit var useCase: SearchUseCase

    @Before
    fun setup() {
        inhabitants = generateList()
        useCase = SearchUseCase()
    }

    @Test
    fun searchUseCase_searchByWord_ResultListReceived() {
        val result = useCase.invoke(inhabitants, "Buster")
        val expectedResult = inhabitants.subList(1, 3)
        assertEquals(expectedResult, result)
    }

    @Test
    fun searchUseCase_searchByEmptyString_FullListReceived() {
        val result = useCase.invoke(inhabitants, "")
        val expectedResult = inhabitants
        assertEquals(expectedResult, result)
    }
}