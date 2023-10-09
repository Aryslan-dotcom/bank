package Kaspi.bank.phone.mapper;

import Kaspi.bank.phone.entities.ItemPhone;
import com.netflix.dgs.codegen.generated.types.ItemPhoneInput;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemPhoneMapper {

    ItemPhoneInput mapToDto(ItemPhone itemPhone);
    List<ItemPhoneInput> mapToDtoItemPhoneList(List<ItemPhone> listDtoItemPhone);

}
