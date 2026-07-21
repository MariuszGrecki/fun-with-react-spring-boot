package pl.learningtracker.productitem;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemService {

    private final ProductItemRepository productItemRepository;

    public ProductItemService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    public List<ProductItem> findAll() {
        return productItemRepository.findAll();
    }

    public ProductItem create(String title, String summary, ProductItemType type) {

        ProductItem productItem = new ProductItem(title, summary, type);

        return productItemRepository.save(productItem);
    }

}