package com.deck.engine;
import java.util.Comparator;
import com.deck.domain.Card;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		if (o1.get_suit().ordinal() == o2.get_suit().ordinal()) {
			if (o1.is_greater_than(o2)) {
				return -1;
			} else {
				return 1;
			}

		} else if (o1.get_suit().ordinal() > o2.get_suit().ordinal()) {
			return 1;
		} else {
			return -1;

		}

	}

}