package za.co.kafka.consumerdemo.listener;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    @JsonProperty("details")
    private String details;
    @JsonProperty("status")
    private String status;

    public String toString() {
        return "Details: " + details + " with Status: " + status;
    }
}
