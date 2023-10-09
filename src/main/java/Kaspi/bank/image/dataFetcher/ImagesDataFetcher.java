package Kaspi.bank.image.dataFetcher;

import Kaspi.bank.image.entity.Images;
import Kaspi.bank.image.service.ImagesService;
import com.netflix.dgs.codegen.generated.types.ImagesInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class ImagesDataFetcher {

    @Autowired
    private ImagesService imagesService;

    @DgsMutation
    public Images addImages(@InputArgument ImagesInput imagesInput){
        return imagesService.addImages(imagesInput);
    }

    @DgsQuery
    public List<Images> allImages(){
        return imagesService.getAllImages();
    }
}
