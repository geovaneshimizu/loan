package dev.geovaneshimizu.loan.domain

class PayrollLoanOffer : IncomeAwareLoanOffer {

    override fun offerForLowIncome(lowIncomeLoanMatches: LowIncomeLoanMatcher): Loan {
        return Loan.NotConceded
    }

    override fun offerForMidIncome(midIncomeLoanMatches: MidIncomeLoanMatcher): Loan {
        return Loan.NotConceded
    }

    override fun offerForHighIncome(highIncomeLoanMatches: HighIncomeLoanMatcher): Loan {
        return Loan.Conceded("payroll", 2.0)
    }
}
