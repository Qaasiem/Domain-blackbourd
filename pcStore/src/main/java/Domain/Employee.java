package Domain;

import java.io.Serializable;

/**
 * Created by qaasiem on 2017-08-03.
 */

public class Employee implements Person, Serializable{

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String password;
    private String jobDescription;

    public Employee() {
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public Employee (Builder builder)
    {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.password = builder.password;
        this.jobDescription = builder.jobDescription;
    }

    public static class Builder
    {
        private Long id;
        private String firstName;
        private String lastName;
        private String address;
        private String password;
        private String jobDescription;

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

        public Builder address(String address)
        {
            this.address = address;
            return this;
        }

        public Builder password(String password)
        {
            this.password = password;
            return this;
        }

        public Builder jobDescription(String jobDescription)
        {
            this.jobDescription = jobDescription;
            return this;
        }

        public Builder id(Long id)
        {
            this.id = id;
            return this;
        }

        public Builder copy(Employee employee)
        {
            this.id = employee.id;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.address = employee.address;
            this.password = employee.password;
            this.jobDescription = employee.jobDescription;

            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id.equals(employee.id);
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public String toString()
    {
        return "Name: " + firstName + "" + "Surname: " + lastName + "Job Desc.: " + jobDescription;
    }
}
