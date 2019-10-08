package com.example.palacegamestate;

public class Pair
{
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
