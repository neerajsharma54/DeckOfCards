package com.deck.domain;
import java.util.Random;

/**
 * Deck.java
 * 
 * @brief A class that represents a deck of playing cards
 * 
 * @details This class is responsible for shuffling and dealing a deck of cards.
 *          The deck should contain 52 cards A,2 - 10, J,Q K or four suits, but
 *          no jokers.
 */
public class Deck {

	Card[] cardList = new Card[52];
	public Deck() {
		Card card;
		int i=0;
		for (Card.Suit suit : Card.Suit.values()) {
			for (Card.Value value : Card.Value.values()) {
				card = new Card();
				if (!(value.equals(Card.Value.JOKER))) {
					card.set_value(value, suit);
					cardList[i++] = card;
					//cardList.add(card);
				}
			}
		}
	}

	public void deal_hand(int sets, int cards) {
		
		for (int i = 0; i < sets; i++) {
		    System.out.println("Player: " + (i + 1));
		    for (int j = 0; j < cards; j++) {
		    	cardList[i + j * cards].print();
		        //cardList.get(i + j * cards).print();
		        System.out.println();
		    }
		}
		
	}

	public void print_deck() {
		int i = 0;
		for (Card c : cardList) {
			if(i == 0) {
				c.print();
				i++;
				
			}
			else if (i % 13 == 0) {
				System.out.println();
				c.print();
				i=1;

			} else {
				
				c.print();
				i++;
			}
			
			
		}

	}
	
	public void shuffle(int seed) {
		
		int n = cardList.length;
        Random random = new Random(seed);
        random.nextInt();
        for (int i = 0; i < n; i++) {
            int shuffle = i + random.nextInt(n - i);
            swap(cardList, i, shuffle);
        }
		
	}
	private static void swap(Card[] cards, int i, int shuffle) {
		Card tempCard = cards[i];
		cards[i] = cards[shuffle];
		cards[shuffle] = tempCard;
    }

	public void sort() {
		//cardList.sort(new CardComparator());		
	}

}