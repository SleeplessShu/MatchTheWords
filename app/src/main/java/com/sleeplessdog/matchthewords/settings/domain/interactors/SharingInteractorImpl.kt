package com.sleeplessdog.matchthewords.settings.domain.interactors

import com.sleeplessdog.matchthewords.settings.domain.api.SharingInteractor
import com.sleeplessdog.matchthewords.settings.domain.models.EmailData
import com.sleeplessdog.matchthewords.settings.domain.repositories.ExternalNavigatorRepository
import com.sleeplessdog.matchthewords.settings.domain.repositories.SharingRepository


class SharingInteractorImpl (
    private val sharingRepository: SharingRepository,
    private val externalNavigator: ExternalNavigatorRepository
) : SharingInteractor {
    override fun shareApp() {
        return externalNavigator.shareLink(getShareAppLink())
    }

    override fun openTerms() {
        return externalNavigator.openLink(getTermsLink())
    }

    override fun openSupport() {
        return externalNavigator.openEmail(getSupportEmailData())
    }

    private fun getShareAppLink(): String {

        return sharingRepository.getShareAppLink()
    }

    private fun getSupportEmailData(): EmailData {
        return sharingRepository.getSupportEmailData()
    }

    private fun getTermsLink(): String {
        return sharingRepository.getTermsLink()
    }
}