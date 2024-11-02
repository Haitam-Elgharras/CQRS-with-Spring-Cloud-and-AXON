package me.elgharras.coreapi.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
        @TargetAggregateIdentifier
        open val id: T
        )

data class CreateCustomCommand(
        override val id : String,
        val name: String,
        val email: String,
        ):BaseCommand<String>(id)

data class UpdateCustomCommand(
        override val id : String,
        val name: String,
        val email: String,
):BaseCommand<String>(id)