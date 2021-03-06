package renault.glue.gluepoc

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by az01699 on 06/12/2017.
 */
class UltimateHelper @Inject constructor(private var activity: AppCompatActivity) {
    init {
        activity.application.registerActivityLifecycleCallbacks(
                object : Application.ActivityLifecycleCallbacks {

                    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

                    }

                    override fun onActivityStarted(activity: Activity) {

                    }

                    override fun onActivityResumed(activity: Activity) {
                        manage()
                    }

                    override fun onActivityPaused(activity: Activity) {

                    }

                    override fun onActivityStopped(activity: Activity) {

                    }

                    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {

                    }

                    override fun onActivityDestroyed(activity: Activity) {

                    }
                })
    }

    private val visibilityMap: Map<String, Any> by lazy { FileUtils(activity.applicationContext).read(FileConstants.fileConfig) }
    private val tradMap: Map<String, Any>  by lazy { FileUtils(activity.applicationContext).read(FileConstants.fileWording) }

    fun manage() {
        val parent = activity.window.decorView.rootView as ViewGroup
        getLayouts(parent)
    }

    private fun getLayouts(parent: ViewGroup) {
        (0 until parent.childCount).map { parent.getChildAt(it) }
                .map {
                    val resourceEntryName: String?
                    try {
                        resourceEntryName = parent.resources.getResourceEntryName(it.id)
                        val isVisible: Boolean = visibilityMap[resourceEntryName] as Boolean
                        Timber.d("view identified by $resourceEntryName is ${isVisible}")
                        it.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
                        if (it is TextView) {
                            val myText: String = tradMap[resourceEntryName] as String
                            Timber.d("setting view identified by $resourceEntryName to ${myText}")
                            it.text = myText
                        }
                    } catch (e: Exception) {
                        //TODO: Optmise so as to avoid passing this
                    }
                    if (it is ViewGroup) {
                        getLayouts(it)
                    }
                }
    }
}