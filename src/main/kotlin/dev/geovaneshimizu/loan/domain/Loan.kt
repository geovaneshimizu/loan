package dev.geovaneshimizu.loan.domain

sealed class Loan {

    data class Conceded(val type: String,
                        val taxes: Double) : Loan()

    object NotConceded : Loan()
}
