package blackjack.domain.participant.state

import blackjack.domain.deck.Card
import blackjack.domain.deck.CardNumber

class Cards(
    val values: MutableList<Card> = mutableListOf(),
) {

    fun receiveCard(card: Card) {
        values.add(card)
    }

    fun isBust(): Boolean = score().isBust()

    fun getScoreValue(): Int = score().value

    private fun score(): Score {
        var score = Score(this.values.sumOf { it.number.score })
        val countOfAce = this.values.count { it.number == CardNumber.ACE }
        return score.increaseAceScoreBeforeBust(countOfAce = countOfAce)
    }
}
