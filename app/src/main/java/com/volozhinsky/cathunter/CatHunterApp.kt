package com.volozhinsky.cathunter

import android.app.Application
import com.volozhinsky.cathunter.di.ApplicationComponent
import com.volozhinsky.cathunter.di.DaggerApplicationComponent

class CatHunterApp : Application(){

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }
}