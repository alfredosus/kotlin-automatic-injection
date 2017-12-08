package renault.glue.gluepoc.di

import android.app.Application
import renault.glue.gluepoc.AppLifecycleCallbacks
import timber.log.Timber

class DebugAppLifecycleCallbacks : AppLifecycleCallbacks {

  override fun onCreate(application: Application) {
    Timber.plant(Timber.DebugTree())
  }

  override fun onTerminate(application: Application) {

  }
}
