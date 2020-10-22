package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class EventCategory extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max =50, message = "Name is between 3 to 50 characters long!" )
    private String name;

    public EventCategory(@Size(min = 3, max = 50, message = "Name is between 3 to 50 characters long!") String name){
        this.name = name;
    }

    public EventCategory(){}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}