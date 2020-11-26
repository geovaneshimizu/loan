package dev.geovaneshimizu.loan.domain

import java.util.function.Predicate

class CollateralizedLoanOffer : IncomeAwareLoanOffer {

    private val isUnder30: Predicate<Customer> = Predicate { it.isUnderYearsOld(30) }

    private val livesInSP: Predicate<Customer> = Predicate { it.livesIn("SP") }

    override fun offerForLowIncome(lowIncomeLoanMatches: LowIncomeLoanMatcher): Loan {
        return Loan.Conceded("collateralized", 3.0)
                   .takeIf { lowIncomeLoanMatches.withCustomerAlsoSatisfying(isUnder30.and(livesInSP)) }
               ?: Loan.NotConceded
    }

    override fun offerForMidIncome(midIncomeLoanMatches: MidIncomeLoanMatcher): Loan {
        return Loan.Conceded("collateralized", 3.0)
                   .takeIf { midIncomeLoanMatches.withCustomerAlsoSatisfying(livesInSP) }
               ?: Loan.NotConceded
    }

    override fun offerForHighIncome(highIncomeLoanMatches: HighIncomeLoanMatcher): Loan {
        return Loan.Conceded("collateralized", 3.0)
                   .takeIf { highIncomeLoanMatches.withCustomerAlsoSatisfying(isUnder30) }
               ?: Loan.NotConceded
    }
}
