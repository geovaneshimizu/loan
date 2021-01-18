package dev.geovaneshimizu.loan.domain

enum class LoanOffer : IncomeAwareLoanOffer {

    Personal {

        override fun offerForLowIncome(lowIncomeLoanOfferMatches: LowIncomeLoanOfferMatcher): Loan {
            return Loan.Conceded("personal", 4.0)
        }

        override fun offerForMidIncome(midIncomeLoanOfferMatches: MidIncomeLoanOfferMatcher): Loan {
            return Loan.Conceded("personal", 4.0)
        }

        override fun offerForHighIncome(highIncomeLoanOfferMatches: HighIncomeLoanOfferMatcher): Loan {
            return Loan.Conceded("personal", 4.0)
        }
    },

    Collateralize {

        override fun offerForLowIncome(lowIncomeLoanOfferMatches: LowIncomeLoanOfferMatcher): Loan {
            val customerIsUnder30AndLivesInSP: (Customer) -> Boolean = {
                it.isUnderYearsOld(30) && it.livesIn("SP")
            }

            return Loan.ConcededConditionally(customerIsUnder30AndLivesInSP, Loan.Conceded("collateralized", 3.0))
        }

        override fun offerForMidIncome(midIncomeLoanOfferMatches: MidIncomeLoanOfferMatcher): Loan {
            val customerLivesInSP: (Customer) -> Boolean = { it.livesIn("SP") }

            return Loan.ConcededConditionally(customerLivesInSP, Loan.Conceded("collateralized", 3.0))
        }

        override fun offerForHighIncome(highIncomeLoanOfferMatches: HighIncomeLoanOfferMatcher): Loan {
            val customerIsUnder30: (Customer) -> Boolean = { it.isUnderYearsOld(30) }

            return Loan.ConcededConditionally(customerIsUnder30, Loan.Conceded("collateralized", 3.0))
        }
    },

    Payroll {

        override fun offerForLowIncome(lowIncomeLoanOfferMatches: LowIncomeLoanOfferMatcher): Loan {
            return Loan.NotConceded
        }

        override fun offerForMidIncome(midIncomeLoanOfferMatches: MidIncomeLoanOfferMatcher): Loan {
            return Loan.NotConceded
        }

        override fun offerForHighIncome(highIncomeLoanOfferMatches: HighIncomeLoanOfferMatcher): Loan {
            return Loan.Conceded("payroll", 2.0)
        }
    }
}
