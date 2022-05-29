package com.juliablack.domain

import com.juliablack.domain.model.Gender
import com.juliablack.domain.model.Inhabitant
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FilterByGenderUseCaseTest {
    private lateinit var inhabitants: List<Inhabitant>
    private lateinit var useCase: FilterByGenderUseCase

    @Before
    fun setup() {
        inhabitants = generateList()
        useCase = FilterByGenderUseCase()
    }

    @Test
    fun filterByGenderUseCase_filterByWoman_OnlyWomenReceived() {
        val result = useCase.invoke(inhabitants, Gender.WOMAN)
        val expectedResult = inhabitants.subList(0, 1)
        assertEquals(expectedResult, result)
    }

    @Test
    fun filterByGenderUseCase_filterByMan_OnlyMenReceived() {
        val result = useCase.invoke(inhabitants, Gender.MAN)
        val expectedResult = inhabitants.subList(1, 3)
        assertEquals(expectedResult, result)
    }

    @Test
    fun filterByGenderUseCase_filterByAllGenders_FullListReceived() {
        val result = useCase.invoke(inhabitants, null)
        val expectedResult = inhabitants
        assertEquals(expectedResult, result)
    }
}