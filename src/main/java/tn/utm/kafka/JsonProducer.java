package tn.utm.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.Properties;

public class JsonProducer {

    public static void main(String[] args) {

        Properties props = new Properties();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 👇 BONUS SERIALIZER CUSTOM
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CommandeSerializer.class.getName());

        KafkaProducer<String, Commande> producer = new KafkaProducer<>(props);

        Commande cmd1 = new Commande(1, "2026-05-03",
                Arrays.asList("PC", "Souris"), 2500.0);

        Commande cmd2 = new Commande(2, "2026-05-03",
                Arrays.asList("Clavier", "Écran"), 1800.0);

        producer.send(new ProducerRecord<>("commandes", cmd1));
        producer.send(new ProducerRecord<>("commandes", cmd2));

        System.out.println("📤 Commandes envoyées en JSON via Serializer custom");

        producer.close();
    }
}