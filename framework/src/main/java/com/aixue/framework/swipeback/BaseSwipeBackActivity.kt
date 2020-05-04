package com.aixue.framework.swipeback

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import com.aixue.framework.common.PreferenceUtils
import com.aixue.sodu.main.BaseActivity
import me.imid.swipebacklayout.lib.SwipeBackLayout
import me.imid.swipebacklayout.lib.Utils
import me.imid.swipebacklayout.lib.app.SwipeBackActivityBase
import me.imid.swipebacklayout.lib.app.SwipeBackActivityHelper

/**
 * 侧滑返回界面
 */
class BaseSwipeBackActivity : BaseActivity(), SwipeBackActivityBase {

    companion object {
        val KEY_TRACKING_MODE = "KEY_TRACKING_MODE"
    }

    private var mHelper: SwipeBackActivityHelper? = null
    private lateinit var mSwipeBackLayout: SwipeBackLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mHelper = SwipeBackActivityHelper(this)
        mHelper!!.onActivityCreate()
        mSwipeBackLayout = swipeBackLayout
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT)
        saveTrackingMode(SwipeBackLayout.EDGE_LEFT)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mHelper!!.onPostCreate()
    }

    override fun onResume() {
        super.onResume()
        restoreTrackingMode()
    }

    private fun saveTrackingMode(flag: Int) {
        PreferenceUtils.setPrefInt(applicationContext, KEY_TRACKING_MODE, flag)
    }

    private fun restoreTrackingMode() {
        val flag = PreferenceUtils.getPrefInt(
            applicationContext, KEY_TRACKING_MODE,
            SwipeBackLayout.EDGE_LEFT
        )
        mSwipeBackLayout.setEdgeTrackingEnabled(flag)
    }

    override fun <T : View> findViewById(@IdRes id: Int): T? {
        val v: T? = super.findViewById(id)
        return if (v == null && mHelper != null) mHelper!!.findViewById(id) as T? else v
    }

    override fun getSwipeBackLayout(): SwipeBackLayout {
        return mHelper!!.getSwipeBackLayout()
    }

    override fun setSwipeBackEnable(enable: Boolean) {
        getSwipeBackLayout().setEnableGesture(enable)
    }

    override fun scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this)
        getSwipeBackLayout().scrollToFinishActivity()
    }

}