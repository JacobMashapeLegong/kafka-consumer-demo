package za.co.kafka.consumerdemo.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

  @Value("${spring.kafka.consumer.bootstrap-servers}")
  private String bootstrapAddress;

  @Value("${kafka.topics.demo}")
  private String topic;

  @Value("${kafka.topics.partitions}")
  private int partitions;

  @Value("${kafka.topics.replication-factor}")
  private short replicationFactor;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic topic() {
    return new NewTopic(topic, partitions, replicationFactor);
  }
}
