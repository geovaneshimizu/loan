package dev.geovaneshimizu.loan.api.http

import dev.geovaneshimizu.loan.domain.Loan

data class ConcededLoans(val customer: String,
                         val loans: List<Loan>)
