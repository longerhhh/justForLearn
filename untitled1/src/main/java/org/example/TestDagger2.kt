package org.example

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject
import javax.inject.Qualifier

fun main() {
//    val car = DaggerEngineComponent.builder().build().carBuilder().build().carA
    println("cylinderNumbers : " + car.engine.cylinderNumbers)
}

class Car(val engine: Engine) {
    var name: String? = null
}

const val CYLINDER_FUEL_COST = 10

class Engine() {
    var cylinderNumbers: Int = -1

    constructor(cylinderNumbers: Int) : this() {
        this.cylinderNumbers = cylinderNumbers
    }

//    fun run(fuel: Fuel) {
//        fuel.burn(cylinderNumbers * CYLINDER_FUEL_COST)
//    }
}

@Component(modules = [EngineModule::class])
interface EngineComponent {
    val engine: Engine

    @EngineA
    val engineA: Engine

    @EngineB
    val engineB: Engine

    fun carBuilder(): CarComponent.Builder
}

@Module(subcomponents = [CarComponent::class])
object EngineModule {
    @Provides
    @EngineA
    fun provideEngineA(): Engine = Engine(3)

    @Provides
    @EngineB
    @JvmStatic
    fun provideEngineB(): Engine = Engine(4)
}

//@Component(dependencies = [EngineComponent::class])
//interface CarComponent {
//    fun inject(car: Car)
//    val car: Car
//}

@Subcomponent(modules = [CarModule::class])
interface CarComponent {

    @CarA
    val carA: Car

    @CarB
    val carB: Car

    @Subcomponent.Builder
    interface Builder {
        fun build(): CarComponent
    }
}

@Module
object CarModule {
    @CarA
    @Provides
    @JvmStatic
    fun carA(@EngineA engine: Engine): Car = Car(engine)

    @CarB
    @Provides
    @JvmStatic
    fun carB(@EngineB engine: Engine): Car = Car(engine)
}

@Qualifier
annotation class EngineA

@Qualifier
annotation class EngineB

@Qualifier
annotation class CarA

@Qualifier
annotation class CarB
