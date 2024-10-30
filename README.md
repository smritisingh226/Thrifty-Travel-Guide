# Thrifty-Travel-GuideThrift Travel Guide
INTRODUCTION
Thrift travel guide is a travel application designed to guide travelers to plan a perfect trip by providing them information regarding what they can do while they are visiting the country. The android application has number of activities that navigates the user throughout the application. These activities are the Application Splash screen, Login screen, Registration screen, A recycler view that displays the various countries using a card view, Various splash screens to display the countries selected by the user and finally the last activity that displays the fragments of weather, things to do and must try for each card a user can select.
Various concepts that were covered throughout the course have been used in the development of the application namely but not limited to Threads, Intents, Services, Fragments, various layouts, Shared Preference, Adapters and Recycler view. A total of 27 java files and 25 layout xml files have been used in the development of this project.
APPLICATION DEVELOPMENT
The application was developed in three stages as shown below:
STAGE 1:
The application starts with a splash screen that automatically redirects the user to the login activity. The user is then asked to either register or login (if they are already registered). A user cannot login without registration. Based on what the user chooses, the next screen appears. If the user selects to Register, they are guided to a screen that lets them register as a user for the application. The user is asked to enter a username, password, email address and date of birth. After entering the data, the user has to click on Register. The user’s data is then saved
using shared preferences which is used to validate the user login details, namely email address and password. This screen also displays a Cancel button that can be clicked to reset the fields.
After the user has registered, they can log into the application by entering the email address and password. When a user hits the Login button, the data they enter is compared to the data stored in the shared preference when they registered. If the data matches, they enter the application else a toast appears that says that they need to register first.
STAGE 2:
Upon successful login, the user is presented with various destinations that they can choose from. This done using the using the recycler view using card view. A music also starts playing in the background. This is done by using the android services. The user can choose any destination they wish to explore. Upon selecting of a destination i.e. a card, the background of the card changes to red to indicate that the destination is visited. The user is then redirected to a splash screen that shows the welcome messages like “Welcome to Paris” and the name of the destination is displayed using intents that is received from the card selection. The splash screen is displayed for 30 seconds after which the user is redirected to a different activity.
STAGE 3:
Based on the card the user selects in the previous stage, an activity is presented with various tabs that helps them in planning the trip. This is done using android fragments. There are three buttons that navigates the user to various fragments, namely
• WEATHER – This fragment tells the user how the weather is throughout the year in the country they selected.
• ATTRACTIONS- This fragment tells the user what they can see when they are trying to explore the city.
• MUST TRY- This fragment tells the user what they should eat during the trip that’s famous locally.
CONCEPTS USED
o Linear Layout
o Relative layout
o TextView
o EditText
o Buttons
o ImageView
o Intents
o ListView
o Adapters
o Fragments
o Threads
o Handlers
o Services
o Recycler View
o Shared Preferences
FUTURE DEVELOPMENTS
In the future, the application can be modified to show more countries. It could also offer options to book tickets and hotels. The Attractions fragment could lead to show a map that pin-points the attraction using google maps. The Must Try fragment can also suggest spots they should eat from. More pictures can be added to show other user experiences.
