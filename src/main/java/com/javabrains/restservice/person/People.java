package com.javabrains.restservice.person;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class People {
    @Id
    private int personId;
    private String firstName;
    private String lastName;
    private int generationLevel;

    public People() {
    }

    public People(int id, String firstName, String lastName, int generationLevel) {
        this.personId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.generationLevel = generationLevel;
    }

    public int getId() {
        return personId;
    }

    public void setId(int id) {
        this.personId = id;
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

    public int getGenerationLevel() {
        return generationLevel;
    }

    public void setGenerationLevel(int generationLevel) {
        this.generationLevel = generationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return personId == people.personId &&
                generationLevel == people.generationLevel &&
                Objects.equals(firstName, people.firstName) &&
                Objects.equals(lastName, people.lastName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(personId, firstName, lastName, generationLevel);
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", generationLevel=" + generationLevel +
                '}';
    }
}
