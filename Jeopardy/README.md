# Jeopardy quiz game


### Create a Quiz Question Server and Client:

---

## Server Code

Your server should work as follows:

When a user connects to the server (this should look similar to the BankAccount Server example), multiple people should be allowed to play the game at the same time.

They will be prompted to enter a username, if that user has played before their previous accumulated dollars is loaded, otherwise they start with zero dollars.

They are then shown their total dollars and asked if they'd like to play a game, see the current leaderboard or quit (this is the main menu).

If they ask to see the leaderboard then the top 5 users in terms of total accumulated dollars are displayed and they are re-prompted to either play or see the leaderboard. The leaderboard should be kept as up to date as possible so currently playing players can see themselves and others moving up and down the scoreboard (upon multiple calls to display the scoreboard).

If they ask to quit they are disconnected from the server.

If they ask to play a game:

They are presented with a random Jeopardy category. (If you are not familiar with Jeopardy you should search for Jeopardy on YouTube) and 1 question from that category. The user will get to see the original value of the question, however the question will play like a daily double. In a daily double the user is asked to make a wager on the question following this rule:

They can wager up to $1000 or if they have over $1000 they can wager up to their total amount of money, they can wager $0 but not less than zero.

If they get the question correct they win their bet. Otherwise they lose that amount (negative values are possible and you can always wager up to $1000 even if you have no money).

After the question is completed the user's score is saved (so it might show on the leaderboard) and they are returned to the main menu.

There is a web api that allows people to access questions from the TV show Jeopardy hosted at: jservice.io

How to retrieve categories:

the following url can retrieve a single category from a jeopardy show
http://jservice.io/api/categories?count=1&offset=312

where the number after count is the number of categories you want to retrieve and the number after offset is where to `jump` into the data at. Thus if offset is a random number (between 0 and 18419) - and count is 1, you'll get one random category. You should type that url into your browser and then change the offset to verify you can retrieve different category information.

How to retrieve clues (questions) for a specific category:

http://jservice.io/api/clues?category=11765

The above url retrieves all the clues associated with a category. You should type that into a browser to verify it works.

Your program will use that api through HttpConnection to retrieve the required parameters to play the game - namely a `random` category and then select a random clue from within the clues in that category.

To make things easier given the textual input - I suggest that if the user has typed anything that the answer contains they should get the question correct. Otherwise semantics may discourage all the players of your game.

For example if the question is:

*Though Bob has retired from this game show, it still tapes in the "Bob Barker Studio"*

and the user types:

*price is right*

while the actual answer is:

*The Price is Right*

the user should get the question correct.

---

## JSON Details

The above web queries return JSON data which is a way of encoding text. You are given a sample project that shows how to parse json text like what you'll get back from the web queries.

It includes a json parsing library - which has been added to the project dependencies in the Project structure - settings:

json-simple-1.1.1.jar

You are welcome to build off the provided project to create your server and client code - and thus not have to add the dependency yourself.


---

## Client Code

Your client code should allow the user to connect to the server and pass the information back and forth to the server.

Because the server largely drives what happens next you should implement a simple protocol to send the required information back and forth from the server.

---

## Bonus

Two Bonus points are up for grabs if you implement an SQL database to keep track of the user names and scores in an SQL database so that the data persists even when the server is shut down and then restarted.


Grading:

| Item | Grade | Description |
| --- | --- | --- | 
| Readability| 2 | Does your code follow the class conventions |
| Design | 3 | Have you employed proper coding design choices |
| Functionality| 5 | Does your client - server program work as expected | 
| Bonus | 2 | Did you implement an SQL server to allow user names and scores to persist |   






