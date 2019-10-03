package br.com.cantinho.kogasample.util

import br.com.cantinho.kogasample.model.CardContent
import br.com.cantinho.kogasample.model.EmailAddress
import br.com.cantinho.kogasample.model.MobilePhoneNumber
import br.com.cantinho.kogasample.model.NumericId
import kotlin.random.Random

/**
 * Creates some mock users.
 */
fun generateMockUsers(simple: Boolean = true): List<CardContent> {
    val totalCards = 25
    val users = ArrayList<CardContent>(totalCards)
    for (i in 1..totalCards) {
        val randomAge =  getRandomId()
        if(simple) {
            users.add(EmailAddress("Email: $i", NumericId(randomAge)))
        } else {
            if(Random.nextBoolean()) {
                users.add(EmailAddress("Email: $i", NumericId(randomAge)))
            } else {
                users.add(MobilePhoneNumber("Mobile Phone Number $i", NumericId(randomAge)))
            }
        }
    }
    return users
}

/**
 * Generates random age between 0 and 110 (excluded)
 *
 * @return random age value
 */
private fun getRandomId(): Long {
    return (Math.random() * 110).toLong()
}
