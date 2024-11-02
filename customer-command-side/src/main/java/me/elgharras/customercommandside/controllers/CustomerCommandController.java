package me.elgharras.customercommandside.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elgharras.coreapi.commands.CreateCustomCommand;
import me.elgharras.coreapi.dtos.CustomerRequestDto;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/customers/commands")
public class CustomerCommandController {
    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> newCustomer(@RequestBody CustomerRequestDto request) {
        return commandGateway.send(new CreateCustomCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getEmail()
        ));
    }

    @GetMapping("/eventStore/{id}")
    public Stream eventStore(@PathVariable String id) {
        return eventStore.readEvents(id).asStream();
    }
}