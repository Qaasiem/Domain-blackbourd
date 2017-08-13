package Domain;

import java.io.Serializable;

/**
 * Created by qaasiem on 2017-08-02.
 */

public class Branch implements Serializable{

    private Long id;
    private String address;
    private String phoneNumber;

    public Branch() {
    }

    public Long getID() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public Branch (Builder builder)
    {
        this.id = builder.id;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class Builder
    {
        private Long id;
        private String address;
        private String phoneNumber;

        public Builder address(String address)
        {
            this.address = address;
            return this;
        }

        public Builder phoneNumber(String phoneNumber)
        {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Branch build()
        {
            return new Branch(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        return id.equals(branch.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Address: " + address;
    }
}
