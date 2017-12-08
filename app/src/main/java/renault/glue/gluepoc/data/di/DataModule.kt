package renault.glue.gluepoc.data.di

import android.content.Context
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import renault.glue.gluepoc.App
import renault.glue.gluepoc.UltimateHelper
import javax.inject.Singleton

@Module
class DataModule {

  @Singleton @Provides
  fun provideGitHubService(  application: App): Context = application.applicationContext


}