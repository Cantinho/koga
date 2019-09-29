package br.com.cantinho.kogasample.model

data class EmailAddress(override val content: String, val id: Id<*>?) : CardContent

/**
 * These are 800-numbers (e.g. 855, etc.). We can host or provision 800-numbers for you.
 */
data class TollFreeNumber(override val content: String, val id: Id<*>?) : CardContent, PhoneNumber

/**
 * These phone numbers are hardwired into the telephone grid. We can host all landline numbers.
 */
data class LandlineNumber(override val content: String, val id: Id<*>?) : CardContent, PhoneNumber

/**
 * An acronym for Voice Over Internet Protocol, these numbers are entirely digital.
 * They transfer voice, SMS, and media through the internet. Because VOIP numbers
 * are more complex, there are some we can host and some we cannot.
 */
data class VoIPNumber(override val content: String, val id: Id<*>?) : CardContent, PhoneNumber

/**
 * These are cell phone numbers. They already have both voice and SMS portions active,
 * so we cannot host these numbers.
 */
data class MobilePhoneNumber(override val content: String, val id: Id<*>?) : CardContent, PhoneNumber

/**
 * These are 5- and 6-digit numbers used primarily for mass alerts and promotions.
 * These numbers are also very expensive ($1,000+/mo), but you can get the same functionality
 * using our Keywords feature for just a few bucks.
 */
data class ShortCodeTextOnlyNumber(override val content: String, val id: Id<*>?) : CardContent, PhoneNumber

/**
 * These are the 10-digit numbers Text Request provides if you choose to get a number through us
 * instead of using your current business number. These numbers have no voice functionality
 * (i.e. they are text only).
 */
data class LongCodeTextOnlyNumber(override val content: String, val id: Id<*>?) : CardContent, PhoneNumber

/**
 * These are private phone numbers.
 */
data class PersonalPhoneNumber(override val content: String, val id: Id<*>?) : CardContent, PhoneNumber

/**
 * These are business phone numbers.
 */
data class BusinessPhoneNumber(override val content: String, val id: Id<*>?) : CardContent, PhoneNumber