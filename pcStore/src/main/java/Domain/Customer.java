package Domain;

import java.io.Serializable;

/**
 * Created by qaasiem on 2017-08-02.
 */

public class Customer implements Serializable{

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String password;

    public Customer() {
    }

    public Long getID() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public Customer(Builder builder)
    {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.address = builder.address;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String email;
        private String password;
        private String lastName;
        private String address;

        public Builder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }


        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder email(String email)
        {
            this.email = email;
            return this;
        }

        public Builder password(String password)
        {
            this.password = password;
            return this;
        }

        public Builder address(String address)
        {
            this.address = address;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Customer customer)
        {
            this.id = customer.id;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.password = customer.password;
            this.address = customer.address;

            return this;
        }

        public Customer build()
        {
            return new Customer(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return id.equals(customer.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Name: " + firstName + "" + "Surname: " + lastName;
    }
}

