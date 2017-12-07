package app.com.mobileassignment;
import app.com.mobileassignment.views.MainActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import app.com.mobileassignment.R;

import android.app.Activity;
import android.app.Application;
import android.support.test.espresso.idling.CountingIdlingResource;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import android.test.ActivityInstrumentationTestCase;
import android.test.ApplicationTestCase;
import android.test.InstrumentationTestCase;
/**
 * some of the functional testcases that covers the search functionality.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    //TestCase number 1 on testcases table (Mobile_QA_Addignment.pdf file)
    @Test
    public void testCheckSearchTextboxIsDisplayed()throws Exception{
        onView(withId(R.id.search)).check(matches(isDisplayed()));
    }

    //testCase number 3 on testcases table (Mobile_QA_Addignment.pdf file)
    @Test
    public void testCheckSearchResultsIsDisplayed()throws Exception{
        onView(withId(R.id.citiesList)).check(matches(isDisplayed()));
    }

    //testCase number 19 on testcases table (Mobile_QA_Addignment.pdf file)
    @Test
    public void testSelectCityFromResults()throws Exception{
        onView(withId(R.id.citiesList)).perform(click());
        //onView(isRoot()).wait(10000);
        new InstrumentationTestCase().getInstrumentation().waitForIdleSync();
        onView(withId(R.id.insert_point)).check(matches(isDisplayed()));
        //check that pin is displayed, but I cannot find the pin ID or any data to use it.
    }

    //testCase number 4 on testcases table (Mobile_QA_Addignment.pdf file)
    @Test
    public void testCheckMapIsDisplayed()throws Exception{
        onView(withId(R.id.citiesList)).perform(click());
        new InstrumentationTestCase().getInstrumentation().waitForIdleSync();
        onView(withId(R.id.insert_point)).check(matches(isDisplayed()));

    }

    //testCase number 16 on testcases table (Mobile_QA_Addignment.pdf file)
    @Test
    public void testCheckSortingList()throws Exception{
        onView(withId(R.id.search)).perform(typeText("amsterdam")).perform(closeSoftKeyboard());
        //onView(withText("Amsterdam, NL")).check(matches(isDisplayed()));
        //new InstrumentationTestCase().getInstrumentation().wait(1000);
        onView(withId(R.id.search)).perform(clearText());
        onView(withId(R.id.cityName)).check(matches(withText("'t Hoeksken, BE")));
        //supposed to check that the results list is sorted again
    }


}