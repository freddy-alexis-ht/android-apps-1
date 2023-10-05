package com.sunday.myapps2

import org.junit.Test
import kotlin.concurrent.thread

class ExampleUnitTest {

    fun asyncFun(name: String, hello: (String) -> Unit) {
        val str = "Hello $name"
        thread {
            Thread.sleep(3000)
            hello(str)
        }
    }

    @Test
    fun funX() {
        asyncFun(name = "Domingo", { println(it) }) // Hello Domingo
    }

}