package Domain;

import java.io.Serializable;

/**
 * Created by qaasiem on 2017-08-02.
 */

public class CustomerServices implements Serializable{

    private Long id;
    private String date;
    private String serviceDescription;
    private double bill;

    public CustomerServices() {
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public double getBill() {
        return bill;
    }

    public CustomerServices(Builder builder)
    {
        this.id = builder.id;
        this.date = builder.date;
        this.serviceDescription = builder.serviceDescription;
        this.bill = builder.bill;
    }

    public static class Builder
    {
        private Long id;
        private String date;
        private String serviceDescription;
        private double bill;

        public Builder date(String date)
        {
            this.date = date;
            return this;
        }

        public Builder serviceDescription(String serviceDescription)
        {
            this.serviceDescription = serviceDescription;
            return this;
        }

        public Builder bill(double bill)
        {
            this.bill = bill;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(CustomerServices service)
        {
            this.id = service.id;
            this.date = service.date;
            this.serviceDescription = service.serviceDescription;
            this.bill = service.bill;

            return this;
        }

        public CustomerServices build()
        {
            return new CustomerServices(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        CustomerServices service = (CustomerServices) o;

        return id.equals(service.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Date: " + date + "" + "Service description: " + serviceDescription;
    }
}

