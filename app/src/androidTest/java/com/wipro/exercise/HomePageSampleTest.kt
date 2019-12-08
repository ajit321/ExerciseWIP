package com.wipro.exercise

import android.R
import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.wipro.exercise.ui.MainActivity
import org.junit.Rule
import org.junit.Test

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.runner.RunWith

import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers
import com.wipro.exercise.ui.adapter.HomePageAdapter


@RunWith(AndroidJUnit4::class)
@LargeTest
class HomePageSampleTest {


    private val ITEM_BELOW_THE_FOLD = 40

    /**
     * Use [ActivityScenario] to create and launch the activity under test. This is a
     * replacement for [androidx.test.rule.ActivityTestRule].
     */
    /*@Rule
    var activityScenarioRule: ActivityScenarioRule<MainActivity?>? =
        ActivityScenarioRule<MainActivity?>(
            MainActivity::class.java
        )

    @Test
    fun scrollToItemBelowFold_checkItsText() { // First scroll to the position that needs to be matched and click on it.
        onView(withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ViewHolder?>(
                    ITEM_BELOW_THE_FOLD,
                    click()
                )
            )
        // Match the text in an item below the fold and check that it's displayed.
        val itemElementText =
            getApplicationContext<Context?>()!!.resources.getString(
                R.string.item_element_text
            ) + ITEM_BELOW_THE_FOLD.toString()
        onView(withText(itemElementText)).check(matches(isDisplayed()))
    }

    @Test
    fun itemInMiddleOfList_hasSpecialText() { // First, scroll to the view holder using the isInTheMiddle matcher.
        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.scrollToHolder<ViewHolder?>)
        // Check that the item has the special text.
        val middleElementText =
            getApplicationContext<Context?>()
                ?.resources!!.getString(R.string.middle)
        onView(withText(middleElementText)).check(matches(isDisplayed()))
    }

    *//**
     * Matches the [CustomAdapter.ViewHolder]s in the middle of the list.
     *//*
    private fun isInTheMiddle(): Matcher<HomePageAdapter.HomeViewHolder?>? {
        return object : TypeSafeMatcher<HomePageAdapter.HomeViewHolder?>() {
             override fun matchesSafely(customHolder: HomePageAdapter.HomeViewHolder?): Boolean {
                return customHolder.getIsInTheMiddle()
            }

            override fun describeTo(description: Description?) {
                description.appendText("item in the middle")
            }
        }
    }
*/
}