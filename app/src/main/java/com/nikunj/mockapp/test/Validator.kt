package com.nikunj.mockapp.test

object Validator {
    fun validate(username : String , passwordLength :Int): Boolean {
          return !(passwordLength<6||username.isEmpty())
    }
}