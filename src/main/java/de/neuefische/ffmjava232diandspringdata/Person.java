package de.neuefische.ffmjava232diandspringdata;

import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Person") // -> verändert den Namen der Collection in eurer Database!
@With
public record Person( String id, String name) {
}
