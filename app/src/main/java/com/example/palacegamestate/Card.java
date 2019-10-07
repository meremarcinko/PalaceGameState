package com.example.palacegamestate;

public class Card
{
	private Suit suit;
	private Value value;

	public Card(Suit suit, Value value)
	{
		this.suit = suit;
		this.value = value;
	}

	public String toString()
	{
		String return_str = "";
		switch(value)
		{
			case TWO:
				return_str += "Two";
			case THREE:
				return_str += "Three";
			case FOUR:
				return_str += "Four";
			case FIVE:
				return_str += "Five";
			case SIX:
				return_str += "Six";
			case SEVEN:
				return_str += "Seven";
			case EIGHT:
				return_str += "Eight";
			case NINE:
				return_str += "Nine";
			case TEN:
				return_str += "Ten";
			case JACK:
				return_str += "Jack";
			case QUEEN:
				return_str += "Queen";
			case KING:
				return_str += "King";
			case ACE:
				return_str += "Ace";
		}
		return_str += " of ";
		switch(suit)
		{
			case CLUBS:
				return_str += "Clubs";
			case DIAMONDS:
				return_str += "Diamonds";
			case HEARTS:
				return_str += "Hearts";
			case SPADES:
				return_str += "Spades";
		}
		return(return_str);
	}
}
