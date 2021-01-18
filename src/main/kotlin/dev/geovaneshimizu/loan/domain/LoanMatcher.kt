package dev.geovaneshimizu.loan.domain

class LoanMatcher(customer: Customer) {

    private val loanMatcherStrategy = CustomerIncomeAwareLoanOfferMatcher(customer)

    private val concededLoans by lazy {
        LoanOffer.values()
            .map { this.loanMatcherStrategy.matchOffer(it) }
            .map { if (it is Loan.ConcededConditionally) it.grantIfCustomerMeetsCondition(customer) else it }
            .filterIsInstance<Loan.Conceded>()
    }

    fun loans(): List<Loan> {
        return this.concededLoans
    }
}
