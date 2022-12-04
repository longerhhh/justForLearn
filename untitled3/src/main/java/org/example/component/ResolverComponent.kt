package org.example.component

import dagger.BindsInstance
import dagger.Component
import org.example.entity.Context
import org.example.entity.OverlayPlugin
import org.example.module.ResolverModule

@Component(modules = [ResolverModule::class])
interface ResolverComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): ResolverComponent
    }

    fun provideContext(): Context
    fun inject(plugin: OverlayPlugin)
}