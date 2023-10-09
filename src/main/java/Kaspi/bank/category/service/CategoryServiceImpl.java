package Kaspi.bank.category.service;

import Kaspi.bank.category.entity.Category;
import Kaspi.bank.image.mapper.ImagesMapper;
import Kaspi.bank.category.repository.CategoryItemRepository;
import Kaspi.bank.category.service.CategoryService;
import com.netflix.dgs.codegen.generated.types.CategoryInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryItemRepository categoryItemRepository;
    @Autowired
    private ImagesMapper imagesMapper;

    @Override
    public List<Category> getAllCategories() {
        return categoryItemRepository.findAll();
    }

    @Override
    public List<Category> getAllCategoriesWichImage() {
        List<Category> list = categoryItemRepository.findAll();
        List<Category> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getImages().isEmpty()) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    @Override
    public Category addCategory(CategoryInput categoryInput) {

        Category category = Category.builder()
                .name(categoryInput.getName())
                .images(imagesMapper.mapToImgList(categoryInput.getImages()))
                .link(categoryInput.getLink())
                .build();
        return categoryItemRepository.save(category);
    }
}
