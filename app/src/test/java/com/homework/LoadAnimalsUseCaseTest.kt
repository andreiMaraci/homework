package com.homework

import app.cash.turbine.Event
import app.cash.turbine.test
import com.homework.common.data.network.NetworkError
import com.homework.common.domain.UseCaseResult
import com.homework.pets.domain.PetRepository
import com.homework.pets.domain.usecase.LoadAnimalsUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LoadAnimalsUseCaseTest {

    private val mockPetRepository = mockk<PetRepository>()

    private lateinit var loadAnimalsUseCaseTest: LoadAnimalsUseCase

    @Before
    fun setUp() {
        loadAnimalsUseCaseTest = LoadAnimalsUseCase(mockPetRepository)
    }

    @Test
    fun testLoadAnimals_HasRun() {
        runBlocking {
            loadAnimalsUseCaseTest().test {
                cancelAndConsumeRemainingEvents()
            }
            coVerify { mockPetRepository.loadAnimals() }
        }
    }

    @Test
    fun testLoadTariffs_Error() {
        runBlocking {
            coEvery { mockPetRepository.loadAnimals() } throws NetworkError("test")

            loadAnimalsUseCaseTest().test {
                val eventsList = cancelAndConsumeRemainingEvents()
                TestCase.assertEquals(eventsList.size, 3)

                val loadingState = (eventsList[0] as Event.Item<*>).value
                TestCase.assertTrue(loadingState is UseCaseResult.Loading<*>)

                val errorState = (eventsList[1] as Event.Item<*>).value
                TestCase.assertTrue(errorState is UseCaseResult.Error<*>)

                val successState = eventsList[2]
                TestCase.assertTrue(successState is Event.Complete)
            }

            coVerify { mockPetRepository.loadAnimals() }
        }
    }
}