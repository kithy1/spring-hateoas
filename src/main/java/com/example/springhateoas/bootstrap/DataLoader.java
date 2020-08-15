package com.example.springhateoas.bootstrap;

import com.example.springhateoas.model.Owner;
import com.example.springhateoas.services.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;

    public DataLoader(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {
        int size = ownerService.getOwners().size();
        if (size==0){
            loadData();
        }

    }

    private void loadData() {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.builder().address("123 Bicerel").city("Miami").telephone("123456768999").build();
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Pilsudski Street");
        owner2.setCity("Miami");
        owner2.setTelephone("123456768999");
        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Anna");
        owner3.setLastName("Zielinska");
        owner3.builder().address("123 Bicerel").city("Miami").telephone("123456768999").build();
        ownerService.save(owner3);

        Owner owner4 = new Owner();
        owner4.setFirstName("Adam");
        owner4.setLastName("Nowak");
        owner4.builder().address("123 Bicerel").city("Miami").telephone("123456768999").build();
        ownerService.save(owner4);
    }
}
