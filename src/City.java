/*   Created by IntelliJ IDEA.
 *   Author: Dimpal Agrawal
 *   Date: 11/20/2020
 *   Time: 10:00 AM
 *   File: City.java
 */

import java.util.Objects;

public class City {
    private String name;
    private boolean isTraversed;
    private int Kilometers_required ;



    public City(String name, boolean isTraversed, int kilometers) {
        this.name = name;
        this.isTraversed = isTraversed;
        Kilometers_required = kilometers;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTraversed() {
        return isTraversed;
    }

    public void setTraversed(boolean traversed) {
        isTraversed = traversed;
    }

    public int getKilometers() {
        return Kilometers_required;
    }

    public void setKilometers(int kilometers) {
        this.Kilometers_required = kilometers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return isTraversed == city.isTraversed &&
                this.Kilometers_required == city.Kilometers_required &&
                Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, isTraversed, this.Kilometers_required);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", isTraversed=" + isTraversed +
                ", Kilometers=" + this.Kilometers_required +
                '}';
    }
}