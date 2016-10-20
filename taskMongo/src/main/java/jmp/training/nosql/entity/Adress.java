package jmp.training.nosql.entity;

/**
 * Created by Dzmitry_Charnavoki on 10/20/2016.
 */
public class Adress
{
    private String street;
    private String city;
    private String zip;

    public Adress()
    {
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }
}
