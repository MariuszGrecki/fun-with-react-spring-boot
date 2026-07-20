package pl.learningtracker.productitem;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ProductItem {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String summary;

    @Enumerated(EnumType.STRING)
    private ProductItemType type;

    @Enumerated(EnumType.STRING)
    private ProductItemStage stage = ProductItemStage.CONCEPT;

    private Instant createdAt = Instant.now();

    private Instant updatedAt = Instant.now();

    protected ProductItem() {

    }

    public ProductItem(String title, String summary, ProductItemType type) {
        this.title = title;
        this.summary = summary;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public ProductItemType getType() {
        return type;
    }

    public ProductItemStage getStage() {
        return stage;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
