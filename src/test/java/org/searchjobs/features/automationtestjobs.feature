Feature: Search for at least one (or more) available jobs

  As a user of the LexisNexis website
  Navigate from LexisNexis homepage to Careers page & search for 'Automation Tester'

  1)  Test starts on homepage 'risk.lexisnexis.com'

  2)  As this is a virtual test, all cookies are clear therefore they need handling
      script will click 'Cookie Settings' on popup & then Confirm my choices (accepting minimal amount of cookies)

  3)  Script will open collapse menu revealing About Us. It will then click About Us to reveal Careers.
      Careers will be clicked and new tab will open on webpage 'risk.lexisnexis.com/about-us/careers'

  4)  Script select 'Search Jobs' on this new webpage & will be navigated to 'risk.lexisnexis.com/about-us/careers/jobs'
      This is on the same tab

  5)  Script will find text box to search for job. 'Automation Tester' will be searched

  6)  If no results for said job, test will fail

  If no results show, test has failed

    @JobSearch
    Scenario: Navigating from homepage to job page, search 'Automation Tester' and failing if no results
      Given The user is on the homepage
      When Clearing cookies pop-up
      And Navigating from homepage to Careers
      And Clicking Search Jobs
      And Searching for Automation Tester
      Then Show results of test