package vi.talya.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by vitalii on 07.03.17.
 */
@Entity
@Table(name =  "contacts")
public class Contact extends GeneratedIdentifierEntity implements Comparable{

    @Column(length = 20)
    private String name;
    @Column(length = 20)
    private String lastName;
    @Enumerated(EnumType.ORDINAL)
    private ContactGroup contactGroup;
    @Column(length = 12)
    private String phoneNumber;
    @Column(length = 25)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addres_id", referencedColumnName = "id")
    private Address address;
    @Column
    private LocalDate birhtday;

    public Contact() {
    }

    public Contact(String name, String lastName, ContactGroup contactGroup, String phoneNumber, String email, Address address, LocalDate birhtday) {
        this.name = name;
        this.lastName = lastName;
        this.contactGroup = contactGroup;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birhtday = birhtday;
    }

    @Override
    public boolean equals(Object o) {

        return EqualsBuilder.reflectionEquals(this, o);

    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ContactGroup getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(ContactGroup contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBirhtday() {
        return birhtday;
    }

    public void setBirhtday(LocalDate birhtday) {
        this.birhtday = birhtday;
    }

    @Override
    public int compareTo(Object o) {
        return CompareToBuilder.reflectionCompare(this, o, new String[]{"name", "address", "lastName", "contactGroup", "phoneNumber", "email", "birhtday"});
    }
}
