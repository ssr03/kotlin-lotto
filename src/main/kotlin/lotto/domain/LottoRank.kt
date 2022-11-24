package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val isBonus: Boolean,
    val reward: Long
) {
    FIFTH_PLACE(3, false, 5000),
    FOURTH_PLACE(4, false, 50000),
    THIRD_PLACE(5, false, 1500000),
    SECOND_PLACE(5, true, 30000000),
    FIRST_PLACE(6, false, 2000000000);

    companion object {
        private const val DEFAULT_REWARD = 0L

        fun getReward(matchCount: Int): Long =
            values().firstOrNull { it.matchCount == matchCount }
                ?.reward
                ?: DEFAULT_REWARD

        fun getLottoRank(matchCount: Int, isBonus: Boolean): LottoRank? =
            values().firstOrNull {
                it.matchCount == matchCount && it.isBonus == isBonus
            }
    }
}
