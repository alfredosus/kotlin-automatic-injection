package renault.glue.gluepoc

import dagger.Module
import dagger.Provides

@Module
internal /*abstract*/ class MainModule {

    @Provides
    fun provideUltimateHelper(mainActivity: MainActivity): UltimateHelper = UltimateHelper(mainActivity)
/*
  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

  @ContributesAndroidInjector
  abstract fun contributeMainFragment(): MainFragment
*/
}