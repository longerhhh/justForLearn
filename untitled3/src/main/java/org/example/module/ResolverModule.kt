package org.example.module

import dagger.Module
import dagger.Provides
import org.example.entity.Context
import org.example.entity.Controller
import org.example.entity.Resolver

@Module
object ResolverModule {
    @JvmStatic
    @Provides
    fun resolver(context: Context, controller: Controller): Resolver {
        return Resolver(context, controller)
    }

    @JvmStatic
    @Provides
    fun controller(context: Context): Controller {
        return Controller(context)
    }
}