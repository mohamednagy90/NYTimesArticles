package com.nytimesarticles.component.articles_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import com.nytimesarticles.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testWeekList() {
        onView(ViewMatchers.withId(R.id.weekBtn)).perform(ViewActions.click())

//        Thread.sleep(30000)
//        onView(withId(R.id.popularPeopleRecyclerView))
//            .perform(RecyclerViewActions
//                .actionOnItemAtPosition<PopularArticlesListAdapter.ArticlesListItemViewHolder>(1,clickItemWithId(R.id.articleImage)))

//        onView(ViewMatchers.withId(R.id.popularPeopleRecyclerView))
//            .perform(RecyclerViewActions.scrollToPosition<PopularArticlesListAdapter.ArticlesListItemViewHolder>(5))
//        Thread.sleep(3000)
//        if (getRVcount() > 0) {
//            onView(withId(R.id.popularPeopleRecyclerView)).perform(
//                RecyclerViewActions.actionOnItemAtPosition<PopularArticlesListAdapter.ArticlesListItemViewHolder>(
//                    0,
//                    click()
//                )
//            )
//        }

    }


    private fun getRVcount(): Int {
        val recyclerView =
            onView(ViewMatchers.withId(R.id.popularPeopleRecyclerView)) as RecyclerView
//            activityRule.scenario.findViewById(R.id.popularPeopleRecyclerView) as RecyclerView
        return recyclerView.adapter!!.itemCount
    }

    inline fun waitUntilLoaded(crossinline recyclerProvider: () -> RecyclerView) {
        Espresso.onIdle()

        lateinit var recycler: RecyclerView

        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            recycler = recyclerProvider()
        }

        while (recycler.hasPendingAdapterUpdates()) {
            Thread.sleep(10)
        }
    }

    fun clickItemWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController, view: View) {
                val v = view.findViewById<View>(id) as View
                v.performClick()
            }
        }
    }
}