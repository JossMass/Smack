package com.example.josemascaro.smack.Model

/**
 * Created by josemascaro on 3/13/20.
 */
class Channel(val name: String, val description :String, val id : String) {

    override fun toString(): String {
        return "#$name"
    }
}