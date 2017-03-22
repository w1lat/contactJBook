package vi.talya.model;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by vitalii on 07.03.17.
 */
@Entity
@Table(name = "addresses")
public class Address extends GeneratedIdentifierEntity{

    @Column(length = 50)
    private String street;
    @Column(length = 10)
    private String houseNumber;
    @Column(length = 5)
    private String flatNumber;

    public Address() {
    }

    public Address(String street, String houseNumber, String flatNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    public Address(String street, String houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }
}
