package dev.geovaneshimizu.loan.domain

interface IncomeAwareLoanOffer {

    fun offerForLowIncome(lowIncomeLoanMatches: LowIncomeLoanMatcher): Loan

    fun offerForMidIncome(midIncomeLoanMatches: MidIncomeLoanMatcher): Loan

    fun offerForHighIncome(highIncomeLoanMatches: HighIncomeLoanMatcher): Loan
}
