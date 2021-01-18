package dev.geovaneshimizu.loan.domain

import java.util.NavigableMap
import java.util.TreeMap

class CustomerIncomeAwareLoanOfferMatcher(customer: Customer) : LoanOfferMatcher<IncomeAwareLoanOffer> {

    private val delegate: IncomeAwareLoanOfferMatcher

    init {
        val matcherByMinIncome: NavigableMap<Long, () -> IncomeAwareLoanOfferMatcher> = TreeMap()
        matcherByMinIncome[0L] = { LowIncomeLoanOfferMatcher() }
        matcherByMinIncome[3_001L] = { MidIncomeLoanOfferMatcher() }
        matcherByMinIncome[5_000L] = { HighIncomeLoanOfferMatcher() }

        this.delegate = matcherByMinIncome.floorEntry(customer.income()).value()
    }

    override fun matchOffer(loanOffer: IncomeAwareLoanOffer): Loan {
        return this.delegate.matchOffer(loanOffer)
    }
}
