package dev.geovaneshimizu.loan.domain

sealed class Loan {

    data class Conceded(val type: String,
                        val taxes: Double) : Loan()

    class ConcededConditionally(private val condition: (Customer) -> Boolean,
                                private val concededLoan: Conceded) : Loan() {

        fun grantIfCustomerMeetsCondition(customer: Customer): Loan {
            return if (this.condition(customer)) this.concededLoan else NotConceded
        }
    }

    object NotConceded : Loan()
}
