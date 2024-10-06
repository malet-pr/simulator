package org.acme.simulator.api;


import org.acme.simulator.kafkaproducer.MessageProducer;
import org.acme.simulator.simulations.Simulations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private Simulations simu;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("quantity") int quantity, @RequestParam("topic") String topic) {
        String message = simu.prepareKafkaMessages(quantity);
        messageProducer.sendMessage(topic, message);
        return "Message sent: " + message;
    }

}