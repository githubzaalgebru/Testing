package com.algebra.testing.utils

fun transformToNumber( value : String ) : Int? {
    return try {
        if( value.isEmpty( ) )
            null
        else
            value.toInt( )
    } catch ( e : Exception ) {
        null
    }
}

fun add( num1 : Int, num2 : Int ) : Int {
    return num1+num2
}

fun subtract( num1 : Int, num2 : Int ) : Int {
    return num1-num2
}

fun multiply( num1 : Int, num2 : Int ) : Int {
    return num1*num2
}

fun divide( num1 : Int, num2 : Int ) : Int {
    if( num2==0 )
        return 0
    return num1/num2
}