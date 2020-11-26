package dev.geovaneshimizu.loan.domain

class LoanMatcher(private val customer: Customer) {

    private val concededLoans by lazy {
        val loanOffers = setOf(PersonalLoanOffer(), CollateralizedLoanOffer(), PayrollLoanOffer())
        val loanMatcher = CustomerToIncomeAwareLoanMatcher()(this.customer)

        loanOffers
            .map { loanMatcher.matchOffer(it) }
            .filterIsInstance<Loan.Conceded>()
    }

    fun loans(): List<Loan> {
        return this.concededLoans
    }
}
