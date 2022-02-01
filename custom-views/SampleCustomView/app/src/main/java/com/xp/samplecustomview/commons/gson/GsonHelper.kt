package com.xp.samplecustomview.commons.gson

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader
import java.lang.reflect.Type

inline fun <reified T> fromJson(pathFile: String): T = Gson().fromJson(
    FileReader(pathFile),
    T::class.java
)


inline fun <reified T, C, D> fromJson(
    filepath: String,
    type: Class<C>,
    creator: InstanceCreator<D>
): T {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.registerTypeAdapter(type, creator)
    return gsonBuilder.create().fromJson(FileReader(File(filepath)), T::class.java)
}

inline fun <reified T, reified C> fromJson(filepath: String, creator: JsonDeserializer<C>): T {
    val gsonBuilder = GsonBuilder()
    val classType = object : TypeToken<T>() {}.type
    gsonBuilder.registerTypeAdapter(C::class.java, creator)
    return gsonBuilder.create().fromJson(FileReader(File(filepath)), classType)
}

class DefaultInstanceCreator<T>(private val creator: () -> T): InstanceCreator<T> {
    override fun createInstance(type: Type?): T = creator()
}


/*
    https://futurestud.io/tutorials/gson-advanced-custom-instance-creator
 */


class InterfaceAdapter<T>(val mapper: (JsonObject) -> T) : JsonDeserializer<T> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): T? {
        return json?.let {
            mapper(it.asJsonObject)
        }
    }
}


@Throws(ClassNotFoundException::class)
fun getClass(name: String): Class<*> {
    return try {
        Class.forName(name)
    } catch (c: ClassNotFoundException) {
        throw ClassNotFoundException(c.message)
    }
}