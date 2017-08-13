package Domain;

import java.io.Serializable;

/**
 * Created by qaasiem on 2017-08-05.
 */

public class Supplier implements Serializable{
    private Long id;
    private String name;
    private String address;
    private String contactNumber;

    public Supplier() {
    }

    public Long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public Supplier (Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.contactNumber = builder.contactNumber;
    }

    public static class Builder
    {
        private Long id;
        private String name;
        private String address;
        private String contactNumber;

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder address(String address)
        {
            this.address = address;
            return this;
        }

        public Builder contactNumber(String contactNumber)
        {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Supplier supplier)
        {
            this.id = supplier.id;
            this.name = supplier.name;
            this.address = supplier.address;
            this.contactNumber = supplier.contactNumber;

            return this;
        }

        public Supplier build()
        {
            return new Supplier(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        return id.equals(supplier.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Name: " + name + "" + "Address: " + address;
    }
}

