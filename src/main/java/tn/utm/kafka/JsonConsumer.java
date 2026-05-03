package tn.utm.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class JsonConsumer {

    public static void main(String[] args) {

        Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "groupe-commandes");

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // IMPORTANT : on reçoit des bytes (CommandeSerializer) → on lit en bytes indirectement via StringSerializer compatible Kafka
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.ByteArrayDeserializer.class.getName());

        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singletonList("commandes"));

        ObjectMapper mapper = new ObjectMapper();

        while (true) {

            ConsumerRecords<String, byte[]> records =
                    consumer.poll(Duration.ofMillis(500));

            for (ConsumerRecord<String, byte[]> record : records) {

                try {
                    Commande cmd = mapper.readValue(record.value(), Commande.class);

                    System.out.println("📦 Commande reçue : " + cmd);

                } catch (Exception e) {
                    System.err.println("❌ Erreur désérialisation : " + e.getMessage());
                }
            }
        }
    }
}