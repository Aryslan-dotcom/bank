package Kaspi.bank.category.service;

import Kaspi.bank.category.entity.Category;
import com.netflix.dgs.codegen.generated.types.CategoryInput;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    List<Category> getAllCategoriesWichImage();
    Category addCategory(CategoryInput categoryItem);
}
