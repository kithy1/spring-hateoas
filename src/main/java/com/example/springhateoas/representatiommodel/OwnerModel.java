package com.example.springhateoas.representatiommodel;

import com.example.springhateoas.model.Owner;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value = "owner", collectionRelation = "owners")
public class OwnerModel extends RepresentationModel<OwnerModel> {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

    public OwnerModel(Owner owner) {
        this.firstName = owner.getFirstName();
        this.lastName = owner.getLastName();
        this.address = owner.getAddress();
        this.city = owner.getCity();
        this.telephone = owner.getTelephone();

    }

    public OwnerModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
