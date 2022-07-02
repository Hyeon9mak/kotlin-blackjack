package blackjack.domain.participant.state

sealed class Running(cards: Cards) : AfterInit(cards) {

    override fun isFinished(): Boolean = false
}
