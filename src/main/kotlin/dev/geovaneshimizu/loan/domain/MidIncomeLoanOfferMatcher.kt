package dev.geovaneshimizu.loan.domain

class MidIncomeLoanOfferMatcher : IncomeAwareLoanOfferMatcher {

    override fun matchOffer(loanOffer: IncomeAwareLoanOffer): Loan {
        return loanOffer.offerForMidIncome(this);
    }
}
