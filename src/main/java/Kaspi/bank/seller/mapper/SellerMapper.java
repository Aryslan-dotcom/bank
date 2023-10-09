package Kaspi.bank.seller.mapper;

import Kaspi.bank.seller.entity.Seller;
import com.netflix.dgs.codegen.generated.types.SellersInput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellerMapper {
    List<Seller> mapToSeller(List<SellersInput> sellersInputList);
}
