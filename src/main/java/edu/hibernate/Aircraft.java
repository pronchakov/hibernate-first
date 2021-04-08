package edu.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aircrafts")
public class Aircraft {


    @Id
    @Column(name = "aircraft_code")
    private String code;

    @Column(name = "model")
    private String model;

    @Column(name = "range")
    private Integer range;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        if (code != null ? !code.equals(aircraft.code) : aircraft.code != null) return false;
        if (model != null ? !model.equals(aircraft.model) : aircraft.model != null) return false;
        return range != null ? range.equals(aircraft.range) : aircraft.range == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (range != null ? range.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "code='" + code + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}
