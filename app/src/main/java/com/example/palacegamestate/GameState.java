package com.example.palacegamestate;

import java.util.ArrayList;

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

    private ArrayList<Pair> pairs;
    private int turn;


    /* What do the methods do?
       ◦ verify the move is a legal move for the current game state. If it’s not, return false.
       ◦ modify the game state to reflect that a given player has taken that action. Then, return true.
    */
    public boolean selectCards(int playerID, Card selectedCard) {
        return false;
    }

    public boolean playCards(int playerID) {
        return false;
    }

    public boolean changePalace(int playerID) {
        return false;
    }

    public boolean confirmPalace(int playerID) {
        return false;
    }

    public boolean takeDiscardPile() {
        return false;
    }

}
