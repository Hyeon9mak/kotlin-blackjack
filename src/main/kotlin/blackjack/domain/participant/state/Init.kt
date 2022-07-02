package blackjack.domain.participant.state

import blackjack.domain.deck.Card

object Init {
    fun receiveCard(firstCard: Card, secondCard: Card): State {
        return Hit(cards = Cards(mutableListOf(firstCard, secondCard)))
    }
}
