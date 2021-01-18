package dev.geovaneshimizu.loan.domain

interface IncomeAwareLoanOffer {

    fun offerForLowIncome(lowIncomeLoanOfferMatches: LowIncomeLoanOfferMatcher): Loan

    fun offerForMidIncome(midIncomeLoanOfferMatches: MidIncomeLoanOfferMatcher): Loan

    fun offerForHighIncome(highIncomeLoanOfferMatches: HighIncomeLoanOfferMatcher): Loan
}
