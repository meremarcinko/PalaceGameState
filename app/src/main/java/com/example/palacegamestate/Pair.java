package com.example.palacegamestate;

public class Pair
{
	private enum Location
	{
		PLAYER_ONE_HAND, PLAYER_ONE_UPPER_PALACE, PLAYER_ONE_LOWER_PALACE,
		PLAYER_TWO_HAND, PLAYER_TWO_UPPER_PALACE, PLAYER_TWO_LOWER_PALACE,
		DRAW_PILE,       DISCARD_PILE,            DEAD_PILE
	}

	private Card card;
	private Location location;

	public Pair(Card card, Location location)
	{
		this.card = card;
		this.location = location;
	}

	public Card get_card() { return(card); }
	public Location get_location() { return(location); }
	public void set_location(Location location) { this.location = location; }
}
