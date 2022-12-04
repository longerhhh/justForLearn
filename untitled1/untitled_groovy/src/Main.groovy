//static void main(String[] args) {
//  println "Hello world!"
//}

//int a = 1;
//println a.class

//def a = 1;
//println a.class
//
//a = 1.1
//println a.class

//def a = "abcdef"
//println a[0]
//println a[5]
//println a[1..3]

//def a = "abc", b = "abd"
//println a>b
//println a<b
//println a==b

//def a =  {
//  1
//  'a'
//}
//
//println a()

//def list = [0,1,2,'a','b',"dd"]
//
//list.leftShift('e')
//
//println list.toListString()
//
//list << 9
//
//println list.toListString()


class A {
    def a
    int b
    float c
    double d
    long e
    String f

    @Override
    Object invokeMethod(String name, Object args) {
        println args.iterator().toList().toListString()
        return 0
    }
}

def a = new A(a: 1, b: 2, c: 3, d: 4, e: 5, f: 6)

a.aa a.a, a.b, a.c, a.d, a.e, a.f

a.metaClass.g=1000

println a.g

a.metaClass.fun = { i->
    println i
}

a.fun('a')

//A.metaClass.static.sss = 999
//println A.sss

ExpandoMetaClass.enableGlobally()
A.metaClass.ss = 55
def a1 = new A()
println a1.ss

A.metaClass.static.sss =  {
    'sss'
}
println A.sss()

def b = new A(ss: 666)
println b.ss

def s = """aaaaaaaa
asdf
asdf
"""

for (i in 0..9) {

}

switch (s) {
    case 1:
        break
    case 's':
        break
    case "fadsfa":
        break
    case b:
        break
    case 1.1:
        break
}

def a8 = {
    this // main file context
    owner // current clourse
    delegate // default is equals to owner, but can be modify
    return 'a'
}

def s8 = ""
s8.each {true}
s8.findAll()
s8.find()
s8.toListString()
s8.any()
s8.every()
s8.every {}
s8.collect {}
s8.collect()
s8.chars()
s8.contains('a')

a8.resolveStrategy = Closure.DELEGATE_FIRST
a8.resolveStrategy = Closure.OWNER_FIRST
a8.resolveStrategy = Closure.OWNER_ONLY
a8.resolveStrategy = Closure.DELEGATE_ONLY

def list = [1,2,3,6,5,4,'a',"aa",A()]

int[] arr = [1,2,3,40]
list.sort()
list.sort(true){
    return false
}
list.find()
list.every()
list.min()
list.max()
list.leftShift(a)
list << 'a'

def colors = [red:1, blue:2, green:3]
colors.get('red')
colors['red']
colors.red
colors.getAt('red')
colors.toMapString()
colors.yellow = 4
colors.leftShift(a to be)

