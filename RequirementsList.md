Team: @mastermomo @moadic @KMorales1 @mouraofp

After compiling all information given to us by our client, we believe the following are the requirements to the application.

**Login/Signup:**

*   Alternative signup/login methods, such as Facebook and/or Gmail, should be available to users. Users should also be able to create an account and login without such alternative methods if they choose.

*   When signing up, a method in the account creation process should verify the authenticity of the provided email address.

*   Login information must always be saved on the internal application (via a database or some other means) in order to verify logins.

*   User can have their log in information saved, so they aren’t required to type in their email/password when logging in. However, it should be made aware to the user that this is a possible security risk when they decide to save their information. More so, if a user wishes to stop having their login information saved, they must have the ability to erase the credentials.

*   Unlimited attempts should be allowed for users to log in.

*   Passwords should never be unhidden when logging in.

*   To interact with any of the app’s functionality, it must be required for users to log in.
*   In regards to password recovery, the app security process will be developed at our team’s discretion. Common examples of security measures are email verification and/or security questions. A forgot password option should be available regardless at the login page.
*   When signing up, the following criteria must be met for user passwords:
	- 6+ alphanumeric characters in length
 	- At least one character
	- At least one number 
 
* Logging into the app should consist of entering either a username or email along with a password.
*   There must be a one to one relationship between emails and accounts (usernames). As a result, no duplicate accounts should be seen. This does not include accounts where users have the same first and last name.

Optional Additions:

*   Our client has explained that we are allowed to create a "forgot email" option at the login page if we wish.
  
**Profile/Users:**

*   Profiles for Coaches/Athletes should contain (but is not limited to) the following information:
	- Name
	- Profile Photo or Icon
	- Email address
	- Affiliated Teams
	
In additon for coaches, their account should also contain any accreditation they've received (Titles, Awards, Certifications, Etc...)

*   Users should have the ability to be both athletes and coaches in regards to teams. For example: someone who is on a couple of teams as an athlete can also start a team as a coach on the same account. Verification for either case must come from the aspect of approving team subscriptions.
 
*   Both coaches and athletes should be able to hide their accounts from public search. The exception to this will be for members on the same team as the user with the hidden account. Specifically, when looking at all members on such a team. Another exception is for head coaches(someone who creates a team), who should be publicly visible. For non-head coaches, basic account information can be made private to the public.

*   No viewable history for users should be seen. Only the history of teams can be viewable. Please reference the "Teams" section to see what history of a team can be seen.

*   There must be no sensitive user information carried in the app (such as in their profile). More so, emails should only be accessible through the app’s notification system and must not viewable to other users.

*   Users should be able to remove their accounts, which will erase their information from whatever data storage the app utilizes.

Optional Additions:

*   Our client has explained that we are allowed to include a section on profiles where users can include a bio if wanted.

*   Our client has explained that we are allowed to create a way for users to interact with one another, such as through messaging.

*   Our client has explained that we are allowed to implement a way for user to include info such as age and gender if we wish. If we decide to implement this, we must also explain to user why such data is needed in the app.

**Events:**

*   An event notification should contain the following information:
	- The name of the event
	- A brief description
	- The time and location

Furthermore, If the event is a match, then expected roles and players that will fill them should be included. These expected roles and players should be options from a list of the roles that were made and the athletes that are subscribed to the team.

Event notification example given by the client:
REC LEAGUE QUALIFYING MATCH
DESCRIPTION: Our teams first match against xxxxxxx
TIME: 9:00am
LOCATION: 123 Sample St.
POSITIONS: Sally - Pitcher
Keith - Catcher
John - Outfield
Emily - Outfield
Kate - Outfield
Mike - Infield
Pat - Infield
Zach - Infield
Dani - Short Stop

*   Events have the ability to involve multiple teams.
 
*   When coaches select who to notify for an event, it must not be possible for an athlete to "block" that notification.

*   In events such as matches, coaches must be able to list expected positions and who will fill them. It must then be allowed for athletes to block being assigned to a position.

*   If there is a time conflict between two events for an athlete, a notification should be sent to the them when the 2nd (conflicting) event is scheduled.

*   In regards to events in general, event notifications should come mandatorily to email and optionally as a push notification to team members a part of the event.

*   For an event calendar, events must only be viewable on a monthly basis. However a history of all events must be kept in some form.

*   To access the historical records of an event, a user must be subscribed and accepted to a team in the event to view its history. That history is viewable to all members equally.

*   Coaches can erase events on the team's history and the head coach (creator of the team) can choose to either make a different coach the head coach or delete the team.

*   In regards to changing events that are already scheduled, the following options must be provided (more option can be added at our discretion):
	- Delays
	- Cancellations
	- Location Changes
	- Description Changes

Such options are allowed by the creator of the event and the head coach of the team (maker of the team). Other coaches can be given permissions by the creator of the event or the head coach to make edits to an event.

Optional Additions:

*   Our client has explained that we are allowed to develop a way for coaches to create events that are open to the general public (such as auditions for example).
 
*   Our client has explained that we are allowed to develop a way for events to be shared to other platforms such as Facebook, Twitter, etc. If implemented, then only coaches must be allowed to share the events.

**Teams:**

*   Teams should be created by a single coach, and other coaches or athletes can be invited or request to subscribe to a team. Furthermore, each team must be for a designated sport.

*   For athlete/coach approval to join teams, as long as coaches for that team have the final decision, any mechanism is allowed (examples: invitations, requests, or both)
	- For requests: Coaches currently affiliated with the team should receive a notification (it’s left to our team decide how they are notified) prompting them to log into the app and either accept or deny the subscription request
	- For invitations: if a coach sends an invitation to another coach or athlete to join a team, the recipient should receive a similar notification.

*   There can there be more than one coach per team with the privileges to approve/deny subscriptions to such team, but that privilege must optionally be given to them by the first coach who created the team.
 
*   There should be no limits to how many and what type of teams a person can join.
 
*   There should be no limit to the number of members in a team in regards to any sport.

*   Coaches should be able to remove players from their team at their own discretion.
 
*   For teams, the following stat histories are allowed:
	- Team creation date
	- when new members join
	- the team’s events

*   Teams have two types of accounts affiliated, that being coaches and athletes. Beyond that, there must be optional titles that can be given to any team members by coaches. There is also no limit to the positions created for each user.
 
*   Player may have multiple titles within the team. But when filling a roster for a game they take a maximum of one title.

*   Things a non-team member can see about a team should include but are not limited to:
	- Team's coach and member count
	- The name of the head coach
	- The name of the sport that the team is affiliated with

**Sports:**

*   The application should be able to accommodate any conventional team’s sport (e-sports and made up ones are even allowed). Furthermore, the app should be able to take in information about the positions in the sport as input and build a team preset for the sport.
  
Optional Additions:

*   Our client has explained that we are allowed to have a record of scores from sport events and for the app to keep track of team winning percentages.

**UI Navigation:**

*   After logging in, the main menu (home screen) should include but is not limited to: 
	- Profile
	- Your Calendar
  	- Team Search
	- Settings/Options

When our team has the functionality above developed, we are allowed to then design the home screen however we wish.
