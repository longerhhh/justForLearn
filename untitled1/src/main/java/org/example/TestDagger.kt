package org.example
//
//import dagger.BindsInstance
//import dagger.Component
//import dagger.Lazy
//import dagger.Module
//import dagger.Provides
//import javax.inject.Inject
//import javax.inject.Scope
//import javax.inject.Singleton
//
//fun main() {
//    Test().test()
//    Test1().test()
//}
//
//class Test {
//    init {
//        DaggerTestComponent.builder().s("sss").build().inject(this)
//    }
//
//    @Inject lateinit var testA: TestA
//    @Inject lateinit var testDagger: TestDagger
//    @Inject lateinit var container: Container
//
//    fun test() {
//        testA.a()
//        testDagger.test()
//        container.test()
//    }
//}
//
//class Test1 {
//    init {
////        DaggerTest1Component.create().inject(this)
//    }
//
//    @Inject lateinit var testA: TestA
//    @Inject lateinit var testDagger: TestDagger
//    @Inject lateinit var container: Container
//    @Inject lateinit var testC: TestC
//
//    fun test() {
//        testC.c()
//        testA.a()
//        testDagger.test()
//        container.test()
//    }
//}
//
//open class TestDagger @Inject constructor(
//    private val a: TestA,
//    private val b: Lazy<TestB>
//) {
//    fun test() {
//        a.a()
//        b.get().b()
//    }
//}
//
//class Container @Inject constructor(
//    private val t1: TestDagger,
//    private val t2: TestDagger,
//    private val a1: TestA,
//    private val a2: TestA,
//    private val b1: TestB,
//    private val b2: TestB,
//){
//    fun test() {
//        t1.test()
//        t2.test()
//        a1.a()
//        a2.a()
//        b1.b()
//        b2.b()
//    }
//}
//
//@Singleton
//@Component(modules = [TestModule::class])
//internal interface TestComponent {
//
//    @Component.Builder
//    interface Builder{
//        @BindsInstance
//        fun s (s:String): Builder
//
//        fun build() : TestComponent
//    }
//    fun inject(t: Test)
//}
//
//@Module
//object TestModule {
//    @Provides
//    fun i(): Int = 1
//}
//
//@Singleton
//@Component
//internal interface Test1Component {
//    fun inject(t: Test1)
//}
//
//@Singleton
//class TestA @Inject constructor(){
//    fun a() {
//        println("a=$this")
//    }
//}
//
//class TestB @Inject constructor(private val i: Int){
//    fun b() {
//        println("b=$this, i=$i")
//    }
//}
//
//class TestC @Inject constructor(private val s: String) {
//    fun c() {
//        println("c=$this, s=$s")
//    }
//}