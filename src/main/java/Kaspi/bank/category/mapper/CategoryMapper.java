package Kaspi.bank.category.mapper;

import Kaspi.bank.category.entity.Category;
import com.netflix.dgs.codegen.generated.types.CategoryInput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    List<CategoryInput> mapToListCategoryInput (List<Category> category);
    CategoryInput mapToCategoryInput(Category category);
}
