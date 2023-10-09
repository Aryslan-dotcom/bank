package Kaspi.bank.category.dataFetcher;

import Kaspi.bank.category.entity.Category;
import Kaspi.bank.category.service.CategoryService;
import com.netflix.dgs.codegen.generated.types.CategoryInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class CategoryDataFetcher {

    @Autowired
    private CategoryService categoryService;

    @DgsMutation
    public Category addCategory(@InputArgument CategoryInput categoryInput){
        return categoryService.addCategory(categoryInput);
    }
    @DgsQuery
    public List<Category> allCategories(){
        return categoryService.getAllCategories();
    }

}
