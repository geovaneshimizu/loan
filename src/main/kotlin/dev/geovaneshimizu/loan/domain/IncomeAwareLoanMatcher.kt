package dev.geovaneshimizu.loan.domain

import java.util.function.Predicate

interface IncomeAwareLoanMatcher {

    fun matchOffer(incomeAwareLoanOffer: IncomeAwareLoanOffer): Loan

    fun withCustomerAlsoSatisfying(customerPredicate: Predicate<Customer>): Boolean
}
