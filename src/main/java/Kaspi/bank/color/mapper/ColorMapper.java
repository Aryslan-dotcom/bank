package Kaspi.bank.color.mapper;

import Kaspi.bank.color.entity.Color;
import com.netflix.dgs.codegen.generated.types.ColorsInput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    List<Color>mapToColorList(List<ColorsInput>colorsInputList);
}
