package com.nikunj.mockapp.test

import com.google.common.truth.Truth.assertThat
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun whenInputIsValid(){
        val passwordLength = 6
        val username = "nikunj"
        val result = Validator.validate(username,passwordLength)

        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenInputIsInvalid(){
        val passwordLength = 0
        val username = ""
        val result = Validator.validate(username,passwordLength)

        assertThat(result).isEqualTo(false)
    }
}