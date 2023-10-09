package Kaspi.bank.instalments.service;

import Kaspi.bank.instalments.entity.Instalments;
import Kaspi.bank.instalments.repository.InstalmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstalmentsServiceImpl implements InstamentsService {
    @Autowired
    private InstalmentsRepository instalmentsRepository;
    @Override
    public List<Instalments> getAllInstalments() {
        return instalmentsRepository.findAll();
    }
}
