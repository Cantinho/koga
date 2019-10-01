package br.com.cantinho.kogasample.model

import android.util.Patterns

interface PhoneNumber {
    override fun toString(): String
}

fun PhoneNumber.isValid() = Patterns.PHONE.matcher(this.toString()).matches()
