package blackjack.domain.participant.state

import blackjack.domain.deck.Card
import blackjack.domain.deck.CardNumber

class Cards(
    val values: List<Card> = listOf(),
) {

    val isBustScore: Boolean = score().isBust

    val isBlackjackScore: Boolean = score().isBlackjack

    val getScoreValue: Int = score().value

    fun receiveCard(card: Card): Cards = Cards(values = values + card)

    private fun score(): Score {
        val score = Score(this.values.sumOf { it.number.score })
        val countOfAce = this.values.count { it.number == CardNumber.ACE }
        return score.increaseAceScoreBeforeBust(countOfAce = countOfAce)
    }
}
