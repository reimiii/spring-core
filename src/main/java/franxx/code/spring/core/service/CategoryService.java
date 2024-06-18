package franxx.code.spring.core.service;

import franxx.code.spring.core.repository.CategoryRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    @Getter
    private CategoryRepository repository;

    @Autowired
    public void setRepository(CategoryRepository repository) {
        this.repository = repository;
    }
}
