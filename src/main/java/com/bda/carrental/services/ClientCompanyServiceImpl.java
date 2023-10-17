package com.bda.carrental.services;

import com.bda.carrental.entities.ClientCompany;
import com.bda.carrental.entities.dto.ClientCompanyDto;
import com.bda.carrental.services.transformations.company.ClientCompanyDtoMapper;
import com.bda.carrental.services.transformations.company.ClientCompanyMapper;
import org.springframework.stereotype.Service;
import com.bda.carrental.repositories.ClientCompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientCompanyServiceImpl implements ClientCompanyService {
    private final ClientCompanyRepository clientCompanyRepository;
    private final ClientCompanyDtoMapper clientCompanyDtoMapper;
    private final ClientCompanyMapper clientCompanyMapper;

    public ClientCompanyServiceImpl(ClientCompanyRepository clientCompanyRepository,
                                    ClientCompanyDtoMapper clientCompanyDtoMapper, ClientCompanyMapper clientCompanyMapper) {
        this.clientCompanyRepository = clientCompanyRepository;
        this.clientCompanyDtoMapper = clientCompanyDtoMapper;
        this.clientCompanyMapper = clientCompanyMapper;
    }

    @Override
    public void add(ClientCompanyDto entity) {
        ClientCompany company = new ClientCompany();
        company.setName(entity.getName());
        company.setEmailContact(entity.getEmailContact());
        company.setPhoneNumber(entity.getPhoneNumber());
        clientCompanyRepository.save(company);
    }

    @Override
    public ClientCompanyDto getById(Long id) {
        Optional<ClientCompany> value = clientCompanyRepository.findById(id);
        return value
                .map(clientCompanyDtoMapper)
                .orElseThrow();
    }

    @Override
    public List<ClientCompanyDto> getAll() {
        List<ClientCompany> values = clientCompanyRepository.findAll();
        return values
                .stream()
                .map(clientCompanyDtoMapper)
                .toList();
    }

    @Override
    public ClientCompanyDto delete(Long id) {
        Optional<ClientCompany> optionalClientCompany = clientCompanyRepository
                .findById(id);
        optionalClientCompany.ifPresent(clientCompanyRepository::delete);
        return optionalClientCompany
                .map(clientCompanyDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(ClientCompanyDto entity) {
        Optional<ClientCompany> optionalClientCompany = clientCompanyRepository
                .findById(entity.getId());
        optionalClientCompany.ifPresent(clientCompany -> {
            clientCompany.setName(entity.getName());
            clientCompany.setPhoneNumber(entity.getPhoneNumber());
            clientCompany.setEmailContact(entity.getEmailContact());
            clientCompanyRepository.save(clientCompany);
        });
    }
}
