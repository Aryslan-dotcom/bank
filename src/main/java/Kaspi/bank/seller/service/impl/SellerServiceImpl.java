package Kaspi.bank.seller.service.impl;
import Kaspi.bank.seller.entity.Seller;
import Kaspi.bank.seller.repository.SellersRepositories;
import Kaspi.bank.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellersRepositories sellersRepositories;
    @Override
    public Seller addSellerPhone(Seller seller) {
        return sellersRepositories.save(seller);
    }

    @Override
    public List<Seller> getAllSellerPhone() {
        return sellersRepositories.findAll();
    }
}
