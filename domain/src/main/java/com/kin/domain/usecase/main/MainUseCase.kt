package com.kin.domain.usecase.main

import com.kin.domain.repository.MainRepository
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository
){
    suspend operator fun invoke() = kotlin.runCatching {
        mainRepository.main()
    }
}