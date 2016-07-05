package br.com.brunobrasilweb.springadm.service;

import br.com.brunobrasilweb.springadm.model.Customers;
import br.com.brunobrasilweb.springadm.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomersService extends AbstractService<Customers, Long> {

    @Autowired
    private CustomersRepository customersRepository;

    @Override
    protected JpaRepository<Customers, Long> getRepository() {
        return customersRepository;
    }

}
