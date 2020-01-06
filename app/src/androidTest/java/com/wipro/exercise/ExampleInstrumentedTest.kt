package com.wipro.exercise

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.wipro.exercise.ui.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.wipro.exercise", appContext.packageName)
    }


    @get:Rule
    val activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)
/*
    @Test
    fun clickItem() {
        Espresso.onView(withId(R.id.mRecyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(27,
                    ViewActions.click()
                ))

        Espresso.onView(withId(R.id.txtTitle))
            .check(ViewAssertions.matches(ViewMatchers.withText("27")))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }*/

}
