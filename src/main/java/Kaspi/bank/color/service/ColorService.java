package Kaspi.bank.color.service;

import Kaspi.bank.color.entity.Color;
import com.netflix.dgs.codegen.generated.types.ColorsInput;

import java.util.List;

public interface ColorService {
    Color addColor(ColorsInput colorsInput);
    List<Color> getAllColors();
}
