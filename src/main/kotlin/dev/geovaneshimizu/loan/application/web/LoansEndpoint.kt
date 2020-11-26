package dev.geovaneshimizu.loan.application.web

import dev.geovaneshimizu.loan.domain.LoanMatcher
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/loans")
class LoansEndpoint() {

    @PostMapping
    fun post(@RequestBody lead: Lead): ResponseEntity<ConcededLoans> {

        val concededLoans = LoanMatcher(lead.customer()).loans()

        return ResponseEntity.ok(ConcededLoans(lead.customerName(), concededLoans))
    }
}
