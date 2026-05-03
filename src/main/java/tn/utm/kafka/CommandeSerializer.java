package tn.utm.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class CommandeSerializer implements Serializer<Commande> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Commande data) {
        try {
            return mapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException("Erreur serialization Commande", e);
        }
    }
}