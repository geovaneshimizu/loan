package dev.geovaneshimizu.loan.domain

class HighIncomeLoanOfferMatcher : IncomeAwareLoanOfferMatcher {

    override fun matchOffer(loanOffer: IncomeAwareLoanOffer): Loan {
        return loanOffer.offerForHighIncome(this);
    }
}
