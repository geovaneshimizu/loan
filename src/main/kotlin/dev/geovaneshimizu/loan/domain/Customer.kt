package dev.geovaneshimizu.loan.domain

class Customer(private val income: Long,
               private val location: String,
               private val age: Int) {

    fun livesIn(expectedLocation: String) = this.location == expectedLocation

    fun isUnderYearsOld(maxAge: Int) = this.age < maxAge

    fun income() = this.income
}
