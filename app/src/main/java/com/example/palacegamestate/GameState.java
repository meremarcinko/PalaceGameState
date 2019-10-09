package com.example.palacegamestate;

import java.util.ArrayList;

import static com.example.palacegamestate.Location.PLAYER_ONE_HAND;
import static com.example.palacegamestate.Location.PLAYER_ONE_UPPER_PALACE;

/*Within the same package as the MainActivity class, create a new game state
class for your game. (Eventually this class will be a subclass of the GameState class in
the game framework but it doesn't have to be for this assignment.) Your game state class'
instance variables should encompass all the information you will need about the current
state of the game in order to display it properly for a human user or allow a computer
player to make decisions. Things to consider:
◦ Information about the resources each player has (e.g., cards, pawns, money)
◦ Information about the state of any resources (e.g., card is visible, pawn is yellow)
◦ Whose turn is it?
◦ Detailed information about shared resources (e.g., the game board, contents of a draw
pile)
◦ The visibility of certain information from the perspective of each player
◦ Current score of each player
◦ Current state of a timer
◦ Current state of the dice
◦ What stage of the game you are at (e.g., setup phase, placement phase, buy phase,
main play stage, etc.).
◦ You may need to create additional classes to describe specific elements of the game
state (e.g., a playing card, a pawn, a tile, etc.)*/
public class GameState {

    private ArrayList<Pair> the_deck = new ArrayList<Pair>(52);
    private int turn;

    /**
     * Constructor for the objects in the GameState
     */
    public GameState() {
        initialize_the_deck();
        shuffleTheDeck();
        // TODO: dealTheDeck();
        turn = 0;
    }

    /**
     *
     */
    private void initialize_the_deck()
    {
        for(int i = Rank.THREE_INT; i <= Rank.TEN_INT; i++)
            for(int j = Suit.SPADES_INT; j <= Suit.HEARTS_INT; j++)
                the_deck.add(new Pair(new Card(Rank.int_to_rank(i), Suit.int_to_suit(j)), Location.DRAW_PILE));
    }

    /**
     * shuffle Deck
     *
     * Method to shuffle the deck
     */
    //function wont be implemented until the arrayList for theDeck is made
    public void shuffleTheDeck()
    {
        Collections.shuffle(the_deck);
    }

    /* What do the methods do?
       ◦ verify the move is a legal move for the current game state. If it’s not, return false.
       ◦ modify the game state to reflect that a given player has taken that action. Then, return true.
    */

    private ArrayList<Pair> selectedCards = new ArrayList<>();
    private ArrayList<Pair> discardPile = new ArrayList<>();

    public boolean selectCards(int playerID, Pair userSelectedCard) {
        if (isLegal(userSelectedCard)) {
            if (selectedCards.size() == 0) {
                selectedCards.add(userSelectedCard);
                return true;
            }
            else if (!selectedCards.contains(userSelectedCard) && /*other cards are of the same rank*/) {
                selectedCards.add(userSelectedCard);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean playCards(int playerID) {
        for (int i = 0; i < selectedCards.size(); i++) {
            discardPile.add(selectedCards.get(i));
        }
        
        for (Pair p : selectedCards) {
                p.set_location(Location.DISCARD_PILE);
        }

        selectedCards.clear();



        //bomb the discard pile if there at least 4 cards and the top four are of the same rank
        if (discardPile.size() >= 4) {
            if (discardPile.get(discardPile.size()-1).get_Card().getRank() == discardPile.get(discardPile.size()-2).get_Card().getRank()
                && discardPile.get(discardPile.size()-1).get_Card().getRank() == discardPile.get(discardPile.size()-3).get_Card().getRank()
                && discardPile.get(discardPile.size()-1).get_Card().getRank() == discardPile.get(discardPile.size()-4).get_Card().getRank()) {
                    bombDiscardPile();
            }
        }
        return false;
    }

    /**
     * changePalace
     * method to let the user change their palace at the beginning of the
     * game
     *
     * @param playerID
     * @return
     */
    public boolean changePalace(int playerID) {
        /*An array to store the selected cards in the players
        * hand that will be changed with the palacecards*/
        ArrayList<Pair> handPairs = new ArrayList<>();
        /*An array to store the selected cards in the players palace */
        ArrayList<Pair> palacePairs = new ArrayList<>();

        /*iterate through the deck to find the Pairs
        * that are either in the player's hand or palace
        * and then adds these to the corresponding arraylist*/
        for(Pair p:the_deck){
            if(p.get_location()== PLAYER_ONE_HAND && selectedCards.contains(p)){
                handPairs.add(p);
            }
            else if(p.get_location()==PLAYER_ONE_UPPER_PALACE && selectedCards.contains(p)){
                palacePairs.add(p);
            }
            else{
                return false;
            }
        }
        for(int i = 0; i<handPairs.size(); i++){
            handPairs.get(i).set_location(PLAYER_ONE_UPPER_PALACE);
            palacePairs.get(i).set_location(PLAYER_ONE_HAND);
        }

        return true;
    }

    /**
     * confirmPalace
     *
     * method that lets the user confirm their selected palace
     *
     * @param playerID
     * @return
     */
    public boolean confirmPalace(int playerID) {
        return false;
    }

    /**
     * takeDiscardPile
     *
     * method that lets the user take the dicard pile
     *
     * @return
     */
    public boolean takeDiscardPile() {
        return false;
    }

    private boolean isLegal(Pair selectedCard) {
        if (discardPile.isEmpty()) {
            return true;
        }

        else if (discardPile.get(discardPile.size()-1).get_Card().getRank() <= selectedCard.get_Card().getRank()) {
            return true;
        }

        else if (discardPile.get(discardPile.size()-1).get_Card().getRank() == Rank.SEVEN && selectedCard.get_Card().getRank() <= Rank.SEVEN) {
            return true;
        }
        return false;
    }

    /**
     * Empties the discardPile ArrayList, all cards in pair list with location DiscardPile get changed to Trash pile
     */
    private void bombDiscardPile () {
        discardPile.clear();
        for (Pair p : the_deck) {
            if (p.get_location() == Location.DISCARD_PILE) {
                p.set_location(Location.DEAD_PILE);
            }
        }
    }
}
