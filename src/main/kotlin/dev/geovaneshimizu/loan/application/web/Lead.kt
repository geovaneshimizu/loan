package dev.geovaneshimizu.loan.application.web

import com.fasterxml.jackson.annotation.JsonProperty
import dev.geovaneshimizu.loan.domain.Customer

data class Lead(@JsonProperty("customer") val profile: Profile) {

    data class Profile(val name: String,
                       val age: Int,
                       val location: String,
                       val income: Long)

    fun customer() = Customer(
        income = this.profile.income,
        location = this.profile.location,
        age = this.profile.age
    )

    fun customerName() = this.profile.name
}
