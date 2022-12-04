package org.example.entity

import org.example.component.DaggerResolverComponent
import javax.inject.Inject

class OverlayPlugin {
    @JvmField
    @Inject
    var resolver: Resolver? = null
    fun onCreate(context: Context) {
        DaggerResolverComponent.builder().context(context).build().inject(this)
        println("onCreate: context is $context")
        println("onCreate: resolver is $resolver")
    }
}