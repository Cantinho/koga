package br.com.cantinho.kogasample.model

data class NumericId(override val id: Long) : Id<Long>

data class TextId(override val id: String) : Id<String>