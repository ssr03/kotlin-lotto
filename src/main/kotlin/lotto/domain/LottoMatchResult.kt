package lotto.domain

class LottoMatchResult(
    private val lottoMatchList: List<LottoMatch>
) {

    fun setMatchResult(lottoRank: LottoRank, isBonus: Boolean) {
        lottoMatchList.find { lottoMatch ->
            lottoMatch.lottoRank == lottoRank
        }?.let {
            it.matchTotalCount++
            it.isBonusNumber = isBonus
            it
        }
    }

    fun getMatchResult(): List<LottoMatch> =
        lottoMatchList
}
