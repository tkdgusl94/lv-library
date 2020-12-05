package com.leveloper.library.ext

fun Any?.isNotNull() = this != null

fun Any?.isNull() = this == null

val Any?.TAG: String
    get() = if (this != null) this::class.java.simpleName else ""
