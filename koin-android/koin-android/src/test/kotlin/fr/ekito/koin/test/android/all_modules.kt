package fr.ekito.koin.test.android

import android.app.Activity
import org.koin.android.AndroidModule
import org.koin.android.R

/**
 * Some tests classes
 */

class SampleModule : AndroidModule() {
    override fun context() =
            declareContext {
                provide { AndroidComponent(get()) }
            }
}


class ComplexModule : AndroidModule() {
    override fun context() =
            declareContext {
                provide { AndroidComponent(get()) }
                provide { OtherService(get(), resources.getString(R.string.url)) }
            }
}


class ComplexPropertyModule : AndroidModule() {
    override fun context() =
            declareContext {
                provide { AndroidComponent(get()) }
                provide { OtherService(get(), getProperty(OtherService.URL)) }
            }
}

class ActivityModule : AndroidModule() {
    override fun context() =
            declareContext {
                scope { Activity::class }
                provide { OtherService(get(), resources.getString(R.string.url)) }
            }
}
