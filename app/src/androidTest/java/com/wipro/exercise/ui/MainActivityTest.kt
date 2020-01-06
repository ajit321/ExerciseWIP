package com.wipro.exercise.ui


import android.os.SystemClock
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.wipro.exercise.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkSwipeLayout() {
        // onView(withId(R.id.homeRefreshLayout)).perform(typeText("Steve"))
        val swipeLayout =
            mActivityTestRule.activity.findViewById<SwipeRefreshLayout>(R.id.homeRefreshLayout)
        assert(swipeLayout.isRefreshing)
        SystemClock.sleep(30000)

    }

    @Test
    fun checkDataLoaded() {
        val swipeLayout =
            mActivityTestRule.activity.findViewById<SwipeRefreshLayout>(R.id.homeRefreshLayout)
        assert(swipeLayout.isRefreshing)
        SystemClock.sleep(100000)
        onView(withId(R.id.mRecyclerView)).check(matches(isDisplayed()))

    }
}
