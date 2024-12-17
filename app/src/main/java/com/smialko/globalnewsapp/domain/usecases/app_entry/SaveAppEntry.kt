package com.smialko.globalnewsapp.domain.usecases.app_entry

import com.smialko.globalnewsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}