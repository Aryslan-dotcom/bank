package Kaspi.bank.image.service;

import Kaspi.bank.image.entity.Images;
import com.netflix.dgs.codegen.generated.types.ImagesInput;

import java.util.List;

public interface ImagesService {
    Images addImages(ImagesInput images);
    List<Images> getAllImages();
}
