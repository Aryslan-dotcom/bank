package Kaspi.bank.color.service;

import Kaspi.bank.color.entity.Color;
import Kaspi.bank.color.repository.ColorRepository;
import com.netflix.dgs.codegen.generated.types.ColorsInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository colorRepository;

    @Override
    public Color addColor(ColorsInput colorsInput) {

        Color color = Color.builder()
                .name(colorsInput.getName()).build();
        return colorRepository.save(color);
    }

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }
}
