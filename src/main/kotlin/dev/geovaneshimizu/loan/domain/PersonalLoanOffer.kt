package dev.geovaneshimizu.loan.domain

class PersonalLoanOffer : IncomeAwareLoanOffer {

    override fun offerForLowIncome(lowIncomeLoanMatches: LowIncomeLoanMatcher): Loan {
        return Loan.Conceded("personal", 4.0)
    }

    override fun offerForMidIncome(midIncomeLoanMatches: MidIncomeLoanMatcher): Loan {
        return Loan.Conceded("personal", 4.0)
    }

    override fun offerForHighIncome(highIncomeLoanMatches: HighIncomeLoanMatcher): Loan {
        return Loan.Conceded("personal", 4.0)
    }
}
