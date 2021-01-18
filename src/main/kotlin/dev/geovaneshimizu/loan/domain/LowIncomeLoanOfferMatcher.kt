package dev.geovaneshimizu.loan.domain

class LowIncomeLoanOfferMatcher : IncomeAwareLoanOfferMatcher {

    override fun matchOffer(loanOffer: IncomeAwareLoanOffer): Loan {
        return loanOffer.offerForLowIncome(this);
    }
}
