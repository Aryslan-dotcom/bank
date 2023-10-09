package Kaspi.bank.phone.dataFetcher;

import Kaspi.bank.phone.service.ItemPhoneService;
import com.netflix.dgs.codegen.generated.types.ItemPhoneInput;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class ItemPhoneDataFetcher {
    @Autowired
    private ItemPhoneService itemPhoneService;

    @DgsQuery
    public List<ItemPhoneInput> allItemPhone() {
        return itemPhoneService.getAllItemPhone();
    }
}
