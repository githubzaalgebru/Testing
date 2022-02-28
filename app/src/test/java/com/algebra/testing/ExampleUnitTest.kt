package com.algebra.testing

import com.algebra.testing.utils.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val result = add( 7, 8 )
        assertTrue( result==15 )
    }

    @Test
    fun subtraction_isCorrect() {
        val result = subtract( 7, 8 )
        assertTrue( result==-1 )
    }

    @Test
    fun multiplication_isCorrect() {
        val result = multiply( 7, 8 )
        assertTrue( result==56 )
    }

    @Test
    fun division_isCorrect() {
        val result = divide( 16, 8 )
        assertTrue( result==2 )
    }

    @Test
    fun transformValidNumber( ) {
        val result = transformToNumber( "11" )
        assertTrue( result==11 )
    }

    @Test
    fun transformEmptyToNull( ) {
        val result = transformToNumber( "   " )
        assertNull( result )
    }

    @Test
    fun transformStringToNull( ) {
        val result = transformToNumber( "Danas je ponedjeljak" )
        assertNull( result )
    }
}