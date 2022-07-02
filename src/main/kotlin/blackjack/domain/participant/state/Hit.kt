package blackjack.domain.participant.state

import blackjack.domain.deck.Card

class Hit(cards: Cards) : Running(cards) {
    override fun receiveCard(card: Card): State {
        this.cards.receiveCard(card = card)

        return when (this.cards.isBust()) {
            true -> Bust(this.cards)
            false -> Hit(this.cards)
        }
    }

    override fun stay(): State = Stay(this.cards)
}
