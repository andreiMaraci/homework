package com.homework

import com.homework.common.data.network.NetworkError
import com.homework.pets.domain.PetRepository
import com.homework.pets.domain.usecase.GetAnimalsUseCase
import com.homework.pets.domain.usecase.LoadAnimalsUseCase
import com.homework.pets.ui.petList.PetListViewModel
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PetListViewModelTest {

    private val dispatcher = StandardTestDispatcher()

    private lateinit var mockLoadAnimalsUseCase : LoadAnimalsUseCase
    private lateinit var mockGetAnimalsUseCase : GetAnimalsUseCase
    private val mockPetRepository = mockk<PetRepository>()

    private lateinit var viewModel: PetListViewModel


    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)

        every { mockPetRepository.getAnimalsFlow() } returns flowOf(listOf())
        mockLoadAnimalsUseCase = LoadAnimalsUseCase(mockPetRepository)
        mockGetAnimalsUseCase = GetAnimalsUseCase(mockPetRepository)

        viewModel = PetListViewModel(mockLoadAnimalsUseCase, mockGetAnimalsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testUiState_Success() {
        runBlocking {
            coEvery { mockPetRepository.loadAnimals() } just Runs

            dispatcher.scheduler.advanceUntilIdle()
            assertEquals(viewModel.state.value.contentLoaderState.isLoading, false)
            assertEquals(viewModel.state.value.contentLoaderState.isError, false)
        }
    }

    @Test
    fun testUiState_Error() {
        runBlocking {
            coEvery { mockPetRepository.loadAnimals() } throws NetworkError("test")

            dispatcher.scheduler.advanceUntilIdle()
            assertEquals(viewModel.state.value.contentLoaderState.isLoading, false)
            assertEquals(viewModel.state.value.contentLoaderState.isError, true)
        }
    }

}