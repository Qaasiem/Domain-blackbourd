package Domain;

import java.io.Serializable;

/**
 * Created by qaasiem on 2017-08-03.
 */

public class Hardware implements Inventory, Serializable{

    private Long id;
    private String manufacturer;
    private String name;
    private String category;
    private double price;

    public Hardware() {
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public Hardware(Builder builder){
        this.id = builder.id;
        this.manufacturer = builder.manufacturer;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
    }

    public static class Builder
    {
        private Long id;
        private String manufacturer;
        private String name;
        private String category;
        private double price;

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder manufacturer(String manufacturer)
        {
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder category(String category)
        {
            this.category = category;
            return this;
        }

        public Builder price(double price)
        {
            this.price = price;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Hardware hardware)
        {
            this.id = hardware.id;
            this.manufacturer = hardware.manufacturer;
            this.name = hardware.name;
            this.category = hardware.category;
            this.price = hardware.price;

            return this;
        }

        public Hardware build()
        {
            return new Hardware(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Hardware hardware = (Hardware) o;

        return id.equals(hardware.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Item Name: " + name + "" + "Manufacturer: " + manufacturer + "" + "Price: R" + price;
    }
}
