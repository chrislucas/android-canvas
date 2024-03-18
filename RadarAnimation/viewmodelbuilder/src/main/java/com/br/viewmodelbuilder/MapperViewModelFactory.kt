package com.br.viewmodelbuilder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MapperViewModelFactory(private val argsAndValues: Map<Class<*>, List<*>> = emptyMap()) : ViewModelProvider.Factory{

    constructor(arg: Class<*>, value: Any): this(mapOf(arg to listOf(value)))

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (argsAndValues.isEmpty()) {
            modelClass.getConstructor().newInstance()
        } else {
            val arguments : Array<Class<*>> = argsAndValues.keys.toTypedArray()
            val argumentsOfArgument : List<List<*>> = argsAndValues.values.toList()
            when (argumentsOfArgument.size) {
                1 -> {
                    if (argumentsOfArgument[0].isEmpty()) {
                        modelClass.getConstructor().newInstance()
                    } else {
                        modelClass.getConstructor(*arguments).newInstance(argumentsOfArgument[0][0])
                    }
                }
                else -> {
                    modelClass.getConstructor(*arguments).newInstance(argumentsOfArgument)
                }
            }
        }
    }
}