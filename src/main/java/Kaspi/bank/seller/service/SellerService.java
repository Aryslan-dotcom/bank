package Kaspi.bank.seller.service;


import Kaspi.bank.seller.entity.Seller;

import java.util.List;

public interface SellerService {
    Seller addSellerPhone(Seller seller);
    List<Seller> getAllSellerPhone();
}
