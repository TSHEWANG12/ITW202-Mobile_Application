package com.gcit.todo_4;

import android.content.Context;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {
    @Rule
    public ActivityScenarioRule mActivityRule=new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.gcit.todo_4", appContext.getPackageName());
    }
    @Test
    public void activityLaunch(){
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
        onView(withId(R.id.replybtn)).perform(click());
        onView(withId(R.id.replytext)).check(matches(isDisplayed()));
    }

    @Test
    public void textInputOutput(){
        onView(withId(R.id.ueser_message)).perform(typeText("This is a text"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.dispaly_message)).check(matches(withText("This is a text")));

        onView(withId(R.id.replytext)).perform(typeText("This is a reply"));
        onView(withId(R.id.replybtn)).perform(click());
        onView(withId(R.id.replymessage)).check(matches(withText("This is a reply")));
    }

}