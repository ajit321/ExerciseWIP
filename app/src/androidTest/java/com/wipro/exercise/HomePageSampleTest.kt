package com.wipro.exercise

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class HomePageSampleTest {



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
     * Matches the s in the middle of the list.
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