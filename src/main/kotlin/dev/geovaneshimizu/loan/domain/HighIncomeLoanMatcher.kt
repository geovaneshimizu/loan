package dev.geovaneshimizu.loan.domain

import java.util.function.Predicate

class HighIncomeLoanMatcher(private val customer: Customer) : IncomeAwareLoanMatcher {

    override fun matchOffer(incomeAwareLoanOffer: IncomeAwareLoanOffer): Loan {
        return incomeAwareLoanOffer.offerForHighIncome(this);
    }

    override fun withCustomerAlsoSatisfying(customerPredicate: Predicate<Customer>): Boolean {
        return customerPredicate.test(this.customer)
    }
}
