package renault.glue.gluepoc.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import renault.glue.gluepoc.MainActivity
import renault.glue.gluepoc.MainModule

@Module
internal abstract class UiModule {

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
  internal abstract fun contributeMainActivity(): MainActivity

}