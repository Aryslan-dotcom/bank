package Kaspi.bank.image.service;

import Kaspi.bank.image.entity.Images;
import Kaspi.bank.image.mapper.ImagesMapper;
import Kaspi.bank.image.repository.ImagesRepository;
import com.netflix.dgs.codegen.generated.types.ImagesInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;
    @Override
    public Images addImages(ImagesInput imagesInput) {
        Images images = Images.builder()
                .link(imagesInput.getLink())
                .build();
        return imagesRepository.save(images);
    }
    @Override
    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }
}
