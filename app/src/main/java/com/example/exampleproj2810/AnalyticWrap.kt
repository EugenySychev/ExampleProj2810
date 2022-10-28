package com.example.exampleproj2810

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig

private const val API_key = "8441110b-1477-4f0b-8daa-8aa659f5d4e3"

class AnalyticWrap(application: Application) {

    private var firebaseAnalytics: FirebaseAnalytics

    init {
        val config : YandexMetricaConfig = YandexMetricaConfig.newConfigBuilder(API_key).build()
        YandexMetrica.activate(application, config)
        YandexMetrica.enableActivityAutoTracking(application)
        FirebaseApp.initializeApp(application)
        firebaseAnalytics = Firebase.analytics
    }

    public fun login(userId: String) {
        firebaseAnalytics.setUserId(userId)
        YandexMetrica.setUserProfileID(userId)
    }
    public fun logout() {
        firebaseAnalytics.setUserId("")
        YandexMetrica.setUserProfileID("")
    }

    public fun sendEvent() {
        firebaseAnalytics.logEvent("Some_event") {
            param("param1", "PARAM1")
            param("param2", "PARAM2")
        }
        YandexMetrica.reportEvent("Some_event",  "{\"param1\":\"PARAM1\", \"param2\":\"PARAM2\"}")
    }

    public fun simCrash() {
        throw RuntimeException("CRASH!!!")
    }


}