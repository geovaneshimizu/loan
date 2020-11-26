package dev.geovaneshimizu.loan.domain

import java.util.function.Predicate

class LowIncomeLoanMatcher(private val customer: Customer) : IncomeAwareLoanMatcher {

    override fun matchOffer(incomeAwareLoanOffer: IncomeAwareLoanOffer): Loan {
        return incomeAwareLoanOffer.offerForLowIncome(this);
    }

    override fun withCustomerAlsoSatisfying(customerPredicate: Predicate<Customer>): Boolean {
        return customerPredicate.test(this.customer)
    }
}
