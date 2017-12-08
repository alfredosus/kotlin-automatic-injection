package renault.glue.gluepoc.di

import dagger.Module
import dagger.Provides
import renault.glue.gluepoc.AppLifecycleCallbacks
import renault.glue.gluepoc.data.di.DataModule
import javax.inject.Singleton

@Module(includes = arrayOf(DataModule::class))
class AppModule {

  @Singleton @Provides
  fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = DebugAppLifecycleCallbacks()

}