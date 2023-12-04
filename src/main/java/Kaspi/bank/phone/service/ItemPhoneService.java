package Kaspi.bank.phone.service;

import com.netflix.dgs.codegen.generated.types.ItemPhoneInput;

import java.util.List;

public interface ItemPhoneService {

    ItemPhoneInput addItemPhone(ItemPhoneInput itemPhone);

    List<ItemPhoneInput> getAllItemPhone();

    ItemPhoneInput getByIdItemPhone(Long id);

    List<ItemPhoneInput> getAllItemPhoneWithPriceName(String min, String max, String name);
}
