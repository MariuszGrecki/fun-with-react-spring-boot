package pl.learningtracker.topic;

import jakarta.validation.constraints.NotBlank;

public record TopicRequest(
        @NotBlank(message = "Topic title is required")
        String title
) {
}
