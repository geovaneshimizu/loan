package dev.geovaneshimizu.loan.application.web

import dev.geovaneshimizu.loan.domain.Loan

data class ConcededLoans(val customer: String,
                         val loans: List<Loan>)
