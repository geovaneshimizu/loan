package dev.geovaneshimizu.loan.domain

import java.util.function.Predicate

class MidIncomeLoanMatcher(private val customer: Customer) : IncomeAwareLoanMatcher {

    override fun matchOffer(incomeAwareLoanOffer: IncomeAwareLoanOffer): Loan {
        return incomeAwareLoanOffer.offerForMidIncome(this);
    }

    override fun withCustomerAlsoSatisfying(customerPredicate: Predicate<Customer>): Boolean {
        return customerPredicate.test(this.customer)
    }
}
