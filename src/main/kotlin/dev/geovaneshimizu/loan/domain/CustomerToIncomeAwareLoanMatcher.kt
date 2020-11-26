package dev.geovaneshimizu.loan.domain

import java.util.NavigableMap
import java.util.TreeMap

class CustomerToIncomeAwareLoanMatcher : (Customer) -> IncomeAwareLoanMatcher {

    private val customerToMatcherAlg: (Customer) -> IncomeAwareLoanMatcher

    init {
        val incomeToMatcherMap: NavigableMap<Long, (Customer) -> IncomeAwareLoanMatcher> = TreeMap()
        incomeToMatcherMap[0L] = { LowIncomeLoanMatcher(it) }
        incomeToMatcherMap[3_001L] = { MidIncomeLoanMatcher(it) }
        incomeToMatcherMap[5_000L] = { HighIncomeLoanMatcher(it) }

        this.customerToMatcherAlg = { incomeToMatcherMap.floorEntry(it.income()).value(it) }
    }

    override fun invoke(customer: Customer): IncomeAwareLoanMatcher {
        return this.customerToMatcherAlg(customer)
    }
}
