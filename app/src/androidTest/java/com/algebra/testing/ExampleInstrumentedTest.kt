package com.algebra.testing

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityTestRule = ActivityTestRule( MainActivity::class.java )

    @Test
    fun subtractsNumbersCorrectlyAndDisplaysResult( ) {
        performAction( "6", "3", R.id.bSubtract, "6 - 3 = 3" )
    }

    @Test
    fun addNumbersCorrectlyAndDisplaysResult( ) {
        performAction( "6", "3", R.id.bAdd, "6 + 3 = 9" )
    }

    @Test
    fun multiplyNumbersCorrectlyAndDisplaysResult( ) {
        performAction( "6", "3", R.id.bMultiply, "6 * 3 = 18" )
    }

    @Test
    fun divideNumbersCorrectlyAndDisplaysResult( ) {
        performAction( "6", "3", R.id.bDivide, "6 / 3 = 2" )
    }

    @Test
    fun setsErrorWhenFirstValueIsMissing( ) {
        Espresso.onView( withId( R.id.etFirstNumber ) )
            .perform( ViewActions.typeText( "" ), ViewActions.closeSoftKeyboard( ) )

        Espresso.onView( withId( R.id.etSecondNumber ) )
            .perform( ViewActions.typeText( "12" ), ViewActions.closeSoftKeyboard( ) )

        Espresso.onView( withId( R.id.bAdd ) ).perform( ViewActions.click( ) )

        Espresso.onView( withId( R.id.etFirstNumber ) )
            .check( ViewAssertions.matches( hasErrorText( "Missing first number" ) ) )

    }

    @Test
    fun setsErrorWhenSecondValueIsMissing( ) {
        Espresso.onView( withId( R.id.etFirstNumber ) )
            .perform( ViewActions.typeText( "45" ), ViewActions.closeSoftKeyboard( ) )

        Espresso.onView( withId( R.id.etSecondNumber ) )
            .perform( ViewActions.typeText( "" ), ViewActions.closeSoftKeyboard( ) )

        Espresso.onView( withId( R.id.bAdd ) ).perform( ViewActions.click( ) )

        Espresso.onView( withId( R.id.etSecondNumber ) )
            .check( ViewAssertions.matches( hasErrorText( "Missing second number" ) ) )

    }



    private fun performAction( first : String, second : String, button : Int, result : String ) {
        Espresso.onView( withId( R.id.etFirstNumber ) )
            .perform( ViewActions.typeText( first ), ViewActions.closeSoftKeyboard( ) )

        Espresso.onView( withId( R.id.etSecondNumber ) )
            .perform( ViewActions.typeText( second ), ViewActions.closeSoftKeyboard( ) )

        Espresso.onView( withId( button ) ).perform( ViewActions.click( ) )

        // Check that the text was changed.
        Espresso.onView(withId( R.id.tvResult ) )
            .check( ViewAssertions.matches( ViewMatchers.withText( result ) ) )

        thenEditTextsAreCleared( )
    }

    private fun thenEditTextsAreCleared() {
        Espresso
            .onView( withId( R.id.etFirstNumber ) )
            .check( ViewAssertions.matches( withText( "" ) ) )
        Espresso
            .onView( withId( R.id.etSecondNumber ) )
            .check( ViewAssertions.matches( withText( "" ) ) )
    }
}