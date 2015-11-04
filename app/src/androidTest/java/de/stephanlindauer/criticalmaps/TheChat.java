package de.stephanlindauer.criticalmaps;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class TheChat {
    @Rule
    public ActivityTestRule<Main> mActivityRule =
            new ActivityTestRule<>(Main.class);

    @Test
    public void mapShouldOpenFirst() {
        onView(withId(R.id.map_container)).check(matches(isDisplayed()));
        Spoon.screenshot(mActivityRule.getActivity(), "map");
    }

    @Test
    public void chatShouldBeAccessible() {
        onView(withId(R.id.drawer_layout)).perform(open());
        onView(withText(R.string.section_chat)).perform(click());
        onView(withId(R.id.chat_recycler)).check(matches(isDisplayed()));
        Spoon.screenshot(mActivityRule.getActivity(), "chat");
    }

    @Test
    public void aboutShouldBeAccessible() {
        onView(withId(R.id.drawer_layout)).perform(open());
        onView(withText(R.string.section_about)).perform(click());
        onView(withText(R.string.about_heading_social)).check(matches(isDisplayed()));
        Spoon.screenshot(mActivityRule.getActivity(), "about");
    }

    @Test
    public void rulesShouldBeAccessible() {
        onView(withId(R.id.drawer_layout)).perform(open());
        onView(withText(R.string.section_rules)).perform(click());
        onView(withId(R.id.btnCorken)).check(matches(isDisplayed()));
        Spoon.screenshot(mActivityRule.getActivity(), "rules");
    }

    @Test
    public void twitterShouldBeAccessible() {
        onView(withId(R.id.drawer_layout)).perform(open());
        onView(withText(R.string.section_twitter)).perform(click());
        onView(withId(R.id.tweet_text)).check(matches(isDisplayed()));
        Spoon.screenshot(mActivityRule.getActivity(), "twitter");
    }
}