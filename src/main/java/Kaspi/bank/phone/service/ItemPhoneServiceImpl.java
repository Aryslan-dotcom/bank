package Kaspi.bank.phone.service;

import Kaspi.bank.color.mapper.ColorMapper;
import Kaspi.bank.commentary.mapper.CommentaryMapper;
import Kaspi.bank.image.mapper.ImagesMapper;
import Kaspi.bank.phone.entities.ItemPhone;
import Kaspi.bank.price.entity.Price;
//import Kaspi.bank.phone.mapper.ItemPhoneMapper;
import Kaspi.bank.phone.mapper.ItemPhoneMapper;
import Kaspi.bank.phone.repositories.ItemPhoneRepository;
import Kaspi.bank.seller.mapper.SellerMapper;
import com.netflix.dgs.codegen.generated.types.ItemPhoneInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemPhoneServiceImpl implements ItemPhoneService {
    @Autowired
    private ItemPhoneRepository itemPhoneRepository;
    @Autowired
    private ItemPhoneMapper itemPhoneMapper;
    @Autowired
    private ImagesMapper imagesMapper;
    @Autowired
    private SellerMapper sellerMapper;
    @Autowired
    private ColorMapper colorMapper;
    @Autowired
    private CommentaryMapper commentaryMapper;

    @Override
    public ItemPhoneInput addItemPhone(ItemPhoneInput input) {
        ItemPhone itemPhone = ItemPhone.builder()
                .name(input.getName())
                .description_phone(input.getDescription_phone())
                .price(input.getPrice())
                .imagesList(imagesMapper.mapToImgList(input.getImagesList()))
                .colors(colorMapper.mapToColorList(input.getColors()))
                .memoryPhones(input.getMemoryPhones())
                .description_phone(input.getDescription_phone())
                .brandPhones(input.getBrandPhones())
                .commentaryPhones(commentaryMapper.mapToCommentaryList(input.getCommentaryPhones()))
                .characteristicPhones(input.getCharacteristicPhones())
                .build();
        return itemPhoneMapper.mapToDto(itemPhoneRepository.save(itemPhone));
    }
    @Override
    public List<ItemPhoneInput> getAllItemPhone() {
        return itemPhoneMapper.mapToDtoItemPhoneList(itemPhoneRepository.findAll());
    }

    @Override
    public ItemPhoneInput getByIdItemPhone(Long id) {
        return itemPhoneMapper.mapToDto(itemPhoneRepository.findAllById(id));
    }

    @Override
    public List<ItemPhoneInput> getAllItemPhoneWithPriceName(String minStr, String maxStr, String name) {

        Integer minInt = minStr.isEmpty() ? null : Integer.parseInt(minStr);
        Integer maxInt = maxStr.isEmpty() ? null : Integer.parseInt(maxStr);
        Price priceMin = Price.builder()
                .price(minInt)
                .build();
        Price priceMax = Price.builder()
                .price(maxInt)
                .build();
        if (name.isEmpty()) {
            if (minInt != null && maxInt != null) {
                return itemPhoneMapper.mapToDtoItemPhoneList(itemPhoneRepository.findAllByPriceBetween(priceMin,priceMax));
            } else if (minInt!=null) {
                return itemPhoneMapper.mapToDtoItemPhoneList(itemPhoneRepository.findAllByPriceGreaterThan(priceMin));
            } else if (maxInt!=null) {
                return itemPhoneMapper.mapToDtoItemPhoneList(itemPhoneRepository.findAllByPriceLessThan(priceMax));
            } else {
                return new ArrayList<>();
            }
        } else if (minInt == null && maxInt == null) {
            return itemPhoneMapper.mapToDtoItemPhoneList(itemPhoneRepository.findAllByNameContainsIgnoreCase(name));
        } else if (maxInt == null) {
            return itemPhoneMapper.mapToDtoItemPhoneList(itemPhoneRepository.findAllByNameContainsIgnoreCaseAndPriceGreaterThan(name,priceMin));
        } else if (minInt == null) {
            return itemPhoneMapper.mapToDtoItemPhoneList(itemPhoneRepository.findAllByNameContainsIgnoreCaseAndPriceLessThan(name,priceMax));
        } else {
            return itemPhoneMapper.mapToDtoItemPhoneList(itemPhoneRepository.findAllByNameContainsIgnoreCaseAndPriceBetween(name,priceMin,priceMax));
        }
    }
}
