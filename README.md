
NOTES:

Due to lack of time there needs to be additional work on:

1. 800x600 tests: Navigation bar buttons are not clickable in these dimensions, so there should be refactoring so as to click on RESEARCH & EDUCATION button
   from the navigation collapse menu to the left.
2.  JUnit tests could be parameterized via @RunWith(Parameterized.class) JUnit annotation so as to avoid multiple TestSuite files for the three different dimensions.
3.  The tests were executed locally with Mozilla Firefox browser, because there were compatibility issues of Chromederiver with latest versions of Chrome.
