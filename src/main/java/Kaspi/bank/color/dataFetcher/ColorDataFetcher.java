package Kaspi.bank.color.dataFetcher;

import Kaspi.bank.color.entity.Color;
import Kaspi.bank.color.service.ColorService;
import com.netflix.dgs.codegen.generated.types.ColorsInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

@DgsComponent
public class ColorDataFetcher {

    @Autowired
    private ColorService colorService;

    @DgsMutation
    public Color addColor(@InputArgument ColorsInput colorsInput){
        return colorService.addColor(colorsInput);
    }
}
