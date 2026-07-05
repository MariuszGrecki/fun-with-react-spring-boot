package pl.learningtracker.topic;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @Enumerated(EnumType.STRING)
    private TopicStatus status = TopicStatus.TODO;

    private Instant createdAt = Instant.now();

    protected Topic() {
    }

    public Topic(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TopicStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void rename(String title) {
        this.title = title;
    }

    public void changeStatus(TopicStatus status) {
        this.status = status;
    }
}
