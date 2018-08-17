package marzec.pl.daggerexample.di

import com.google.common.util.concurrent.ListenableFuture
import dagger.Component
import dagger.MembersInjector
import dagger.Module
import dagger.Provides
import dagger.producers.ProducerModule
import dagger.producers.Produces
import dagger.producers.ProductionComponent
import marzec.pl.daggerexample.App
import dagger.producers.Production
import java.util.concurrent.Executor
import java.util.concurrent.Executors


@ProductionComponent(modules = [AppModule::class, ExecutorModule::class])
interface AppComponent {

    fun inject(app: App)

    fun getUserName(): ListenableFuture<UserName>
}

@Module
object ExecutorModule {
    @Provides
    @Production
    fun executor(): Executor {
        return Executors.newCachedThreadPool()
    }
}
@ProducerModule(includes = [ExecutorModule::class])
class AppModule {

    @Produces
    fun provideUserName() : UserName {
        Thread.sleep(10 * 1000)
        return UserName()
    }
}