package br.com.brunobrasilweb.springadm.controller;

import br.com.brunobrasilweb.springadm.model.Customers;
import br.com.brunobrasilweb.springadm.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomersService customerService;

    @Autowired
    public void setCustomerService(CustomersService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String list(Model model) {

        model.addAttribute("list", customerService.getList());
        return "customers/list";

    }

    @RequestMapping("/customers/add")
    public String add(Model model) {

        model.addAttribute("customer", new Customers());
        return "customers/form";

    }

    @RequestMapping("/customers/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        model.addAttribute("customer", customerService.get(id));
        return "customers/form";

    }

    @RequestMapping(value = "/customers/save", method = RequestMethod.POST)
    public String save(Customers customer) {

        Customers save = customerService.save(customer);
        return "redirect:/customers";

    }

    @RequestMapping("/customers/delete/{id}")
    public String delete(@PathVariable Long id) {

        customerService.delete(id);
        return "redirect:/customers";

    }

}
