package com.micro.AdministratorService.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.AdministratorService.model.Administrator;
import com.micro.AdministratorService.repository.AdministratorRepository;
import com.micro.AdministratorService.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public Administrator getAdministratorById(Long adminID) {
        Optional<Administrator> optionalAdministrator = administratorRepository.findById(adminID);
        return optionalAdministrator.orElse(null);
    }

    @Override
    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator updateAdministrator(Long adminID, Administrator updatedAdministrator) {
    	Administrator admin=administratorRepository.findById(adminID).orElseThrow();
        if (administratorRepository.existsById(adminID)) {
     	 admin.setEmail(updatedAdministrator.getEmail());
     	 admin.setFirstName(updatedAdministrator.getFirstName());
     	 admin.setLastName(updatedAdministrator.getLastName());
     	 admin.setPhoneNumber(updatedAdministrator.getPhoneNumber());
            return administratorRepository.save(admin);
        }
        return null;
    }

    @Override
    public void deleteAdministrator(Long adminID) {
        administratorRepository.deleteById(adminID);
    }
}
