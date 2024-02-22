package com.joaorodrigues.theworldpost.domain.usecases

import com.joaorodrigues.theworldpost.domain.manger.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}