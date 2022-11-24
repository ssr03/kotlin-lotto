package lotto.domain

import lotto.util.ErrorCode

class LottoStatistics(
    private val winningLotto: Lotto,
    private val bonusLottoNumber: LottoNumber
) {
    init {
        require(!winningLotto.containLottoNumber(bonusLottoNumber)) {
            ErrorCode.BONUS_LOTTO_NUMBER_EXCEPTION.errorMessage
        }
    }

    private fun initLottoMatchList(): List<LottoMatch> =
        LottoRank.values().map { lottoRank ->
            LottoMatch(
                lottoRank = lottoRank
            )
        }

    fun getWinningStatistics(lottoList: List<Lotto>): List<LottoMatch> {
        val lottoMatchList = initLottoMatchList()

        val lottoMatchResult = LottoMatchResult(lottoMatchList)

        lottoList.forEach { lotto ->
            val matchCount = winningLotto.getMatchCount(lotto)
            val isBonus = lotto.containLottoNumber(bonusLottoNumber)
            LottoRank.getLottoRank(matchCount, isBonus)?.let { lottoRank ->
                lottoMatchResult.setMatchResult(lottoRank, isBonus)
            }
        }
        return lottoMatchResult.getMatchResult()
    }

    fun getProfit(totalPrice: Long, lottMatchList: List<LottoMatch>): Double {
        // 총 이득
        val totalReward = lottMatchList.sumOf { lottoMatch ->
            lottoMatch.matchTotalCount * lottoMatch.lottoRank.reward
        }

        val profit = totalReward / totalPrice.toDouble()

        return (profit * DIGIT_NUMBER).toInt() / DIGIT_NUMBER
    }

    fun isProfitable(profit: Double) = profit >= STANDARD_PROFIT_RATIO

    companion object {
        private const val DIGIT_NUMBER = 100.0
        const val STANDARD_PROFIT_RATIO = 1
    }
}
