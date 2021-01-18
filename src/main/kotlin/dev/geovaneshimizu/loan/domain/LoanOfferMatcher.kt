package dev.geovaneshimizu.loan.domain

interface LoanOfferMatcher<T> {

    fun matchOffer(loanOffer: T): Loan
}
