Cameron Joyner
CGJ2115
COMS1004
Dr. Blaer

HOMEWORK 8 README

INSTRUCTIONS FOR IN-GAME PLAY

Thanks for you interest in how my game works! I tried really hard to take advantage of print statements to make the game as intuitive as possible for my users. This may not be the best way to do it, but I tried! You’ll see in a minute.

When you start playing, you’ll be whether or not you’re ready to play. If you answer YES or any derivative of yes (I even allow you to answer “Si”) you start playing. From there, you’ll be welcomed and asked how much you’d like to gamble/bet. You can answer any number 1-5.

You’ll then be shown your hand, told the value of your hand, and given the opportunity to exchange cards. If you don’t want to exchange any, and would like to keep all of your cards, you may simply input 0. That would indicate you want to swap 0 cards. When you tell us how many cards you’d like to exchange, you’ll be presented with your options. You will need to enter the single digit number of the card you want to replace. You’ll see the cards organized by value, formatted as follows:

Example for exchanging a card:

c7 |  = 0
h8 |  = 1
c9 |  = 2
h13 |  = 3
s13 |  = 4

You’ll want to input a number 0-4. As you replace cards, that hand above will refresh. Let’s say you told the game you want to replace 3 cards. Once you’ve replaced those three, you are given a new hand. That new hand will be evaluated and you’ll be given your payout. If you want to play again, you can say YES and if not, you can say NO.

ABOUT MY CODE AND MY DECISION MAKING PROCESS

This was a very interesting journey, that taught me a lot about OOP and why it is an important principle. Because it was our first really deep dive into OOP, I found it challenging. I also did local versioning, by saving to a new folder on my desktop every twelve hours or so, so that I wouldn’t lose my code. Believe me, that came in handy tonight.

CARD.JAVA

This was pretty basic. I gave the Card object it’s two values and created the compareTo method. From there, I assigned suits of cards a corresponding number and assigned ranks of cards corresponding numbers. Then I had my toString return the suit’s letter and number in the format that we were provided. I chose to use an if else statement here rather than throwing it in a loop because I wanted to see things stacked vertically for easier detection of bugs. Stylistic choice - I gave aces the value of 14 rather than 1.

DECK.JAVA

This was certainly harder than Card.java. I initialized the deck up at the top, then created the deck with a “for loop”. I chose not to do a nested loop, and instead fill my deck with a “for loop” that took in multiple variables. Shuffle takes my cards from my deck, throws them into an array list, shuffles them, then throws them back into an array. My deal method returns the card at the top of the deck.

PLAYER.JAVA

Growing levels of complexity! My player was initialized with a bet of 0 and a bankroll of 10. Otherwise, my player doesn’t have any other qualities. 

ADD CARD METHOD - adds a card to the hand.

REMOVE CARD METHOD - removes a card to the hand.

BETS METHOD - allows the player’s bet to mean something. It also changes the player’s bankroll after they bet.

WINNINGS METHOD - I filled this but decided against using it.

GET BANKROLL METHOD - this gets our bankroll

ORGANIZE HAND METHOD - very important. Puts our hand in order from smallest to largest.

SHOW HAND METHOD - actually calls on the organizeHand() method than prints out our hand

SHOW REPLACEMENT OPTIONS METHOD - this is how I show my player the cards they can replace. This is the five line statement you saw above, in this readme.

REPLACE METHOD - replaces a card in the players hand

PAYOUT METHOD - this is a series of “if else” statements that determines what the player’s payout is and pays them out. I made sure to tell the player what is happening to their hand and their bankroll as this is being called. This portion of the code is lengthy but easy to understand.

HAND VALUE METHOD - this evaluates our hand. I spoke with classmates and the general consensus was that Boolean values were used here. I thought of an idea that is different, and in my opinion is rather unique. I thought through all of the ways we could have a hand. We can have nothing, runs (n, n+1, n+2), flushes (matching suits), and full houses. In some cases, like that of a straight flush, we have a run and a flush. 

Because I organize my hand from least to greatest value card, I started by trying to detect a match to the first card [0].

If the first card has no match, it will not belong to a pair, a three of a kind, or four of a kind. If it has no match, I try to detect if the next card [1] has a partner next to it [2]. If it doesn’t have a match either, I move on…. Then I checked for straights and checked for flushes. I named these intuitively - straight_count and flushability (trademark pending). Then I determine the value of the player’s hand and assign a payout. This is the payout variable that is used in the payout method. This method also contains a way for me to tell the user what their hand contains. I didn’t just want to show c3, s3, d3 - I wanted to say “you have three of a kind”.


GAME.JAVA

My constructor in Game is just a way to create the test hand for the user. If you push an argument through the command line, you’l see that this works.

If you want to be able to see proof that the test hand works, before you even bet, you can take out the three lines I have commented. I wasn’t sure the preference of the graders.

GAME METHOD - this creates a player, a deck and starts a new game. It also assigned a boolean value that indicates that no cards are currently in the player’s hand.

STARTNEWGAME METHOD - shuffles our deck

PLAY METHOD - where the game is actually played!

I issue a welcome message, then say that as long as the player wants to play and has money, they can play. When you start, I deal you cards.

Then I have a while loop that will only be terminated and moved past when a player tells us a valid number of cards they’d like to exchange. Once they tell us the cards they want to exchange, we deal them new cards. We then show them their final hand. If they have money left, they’re given the chance to play again. If they don’t they can’t play again.

**Note** There are things that probably show up in other people’s play methods that aren’t in mine. You’ll see in one moment - I threw a few messages into their own methods so that the code would read cleaner in PLAY.

CHECK HAND METHOD - returns the hand in a toString format

RESET - removes the hand to create a new game.

WELCOME MESSAGE - a simple welcome message that asks if a user wanted to play and evaluates input

PALYERS_BET METHOD - this is where the player actually places a bet! - its called in GAME METHOD.