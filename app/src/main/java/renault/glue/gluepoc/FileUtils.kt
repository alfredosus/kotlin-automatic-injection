package renault.glue.gluepoc

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import timber.log.Timber


/**
 * Created by az01699 on 06/12/2017.
 */

object FileConstants {
    const val fileConfig: String = "config_FR.json"
    const val fileWording: String = "wording_FR.json"
}

class FileUtils(private var context: Context) {

    fun read(fileName: String): Map<String, Any> {
        val content = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }

        val gson = GsonBuilder().setPrettyPrinting().create()
        val personMap: Map<String, Any> = gson.fromJson(content, object : TypeToken<Map<String, Any>>() {}.type)
        Timber.d(personMap.toString())
        return personMap
    }

}