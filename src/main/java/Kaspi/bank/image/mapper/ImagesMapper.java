package Kaspi.bank.image.mapper;

import Kaspi.bank.image.entity.Images;
import com.netflix.dgs.codegen.generated.types.ImagesInput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagesMapper {
    List<ImagesInput> mapToImgInputList(List<Images>imagesList);
    List<Images> mapToImgList(List<ImagesInput>imagesInputList);
    ImagesInput mapToImagesInput(Images images);
}
