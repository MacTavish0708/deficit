package testgroup.deficit.model;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*неудачеая реализация для вызова проууедуры
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "updateVolumeAndWeight",
                query = "CALL updateVolumeAndWeight()",
                resultClass = Data.class)
})
*/

@Entity
@Table(name = "input_data")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "updateVolumeAndWeight",
                procedureName = "updateVolumeAndWeight",
                resultClasses = { Van.class }
                ),
})
public class Van {

    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "Substance", nullable = false)
    private String Substance;
//        private String DateOfArrival;
    @Column(name = "DateOfArrival", nullable = false)
    private Date DateOfArrival;
    @Column(name = "RailwayTankNumber", nullable = false)
    private String RailwayTankNumber;
//        private String DateOfDrain;
    @Column(name = "DateOfDrain")
    private Date DateOfDrain;
    @Column(name = "TypeOfRailwayTank")
    private String TypeOfRailwayTank;
    @Column(name = "Overflow")
    private Short Overflow;
    @Column(name = "Density")
    private Short Density;
    @Column(name = "Temperature")
    private Short Temperature;
    @Column(name = "WeightInvoice")
    private Float WeightInvoice;
    @Column(name = "VolumeOfTheRailwayTank")
    private Float VolumeOfTheRailwayTank;
    @Column(name = "ActualWeight")
    private Float ActualWeight;
    @Column(name = "DifferenceActInv")
    private Float DifferenceActInv;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getSubstance() {
        return Substance;
    }

    public void setSubstance(String substance) {
        Substance = substance;
    }

    public String getRailwayTankNumber() {
        return RailwayTankNumber;
    }

    public void setRailwayTankNumber(String railwayTankNumber) {
        RailwayTankNumber = railwayTankNumber;
    }

//date//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public Date getDateOfArrival() {
//        return DateOfArrival;
//    }
//
//    public void setDateOfArrival(Date dateOfArrival) {
//        DateOfArrival = dateOfArrival;
//    }
//
//    public Date getDateOfDrain() {
//        return DateOfDrain;
//    }
//
//    public void setDateOfDrain(Date dateOfDrain) {
//        DateOfDrain = dateOfDrain;
//    }


    public String getDateOfArrival() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(DateOfArrival);
    }

    public String getDateOfArrival1() {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        return formater.format(DateOfArrival);
    }

    public void setDateOfArrival(String dateOfArrival) {
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            DateOfArrival = formater.parse(dateOfArrival);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDateOfDrain() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(DateOfDrain);
    }

    public String getDateOfDrain1() {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        return formater.format(DateOfDrain);
    }

    public void setDateOfDrain(String dateOfDrain) {
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            DateOfDrain = formater.parse(dateOfDrain);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

//date//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getTypeOfRailwayTank() {
        return TypeOfRailwayTank;
    }

    public void setTypeOfRailwayTank(String typeOfRailwayTank) {
        TypeOfRailwayTank = typeOfRailwayTank;
    }

    public Short getOverflow() {
        return Overflow;
    }

    public void setOverflow(Short overflow) {
        Overflow = overflow;
    }

    public Short getDensity() {
        return Density;
    }

    public void setDensity(Short density) {
        Density = density;
    }

    public Short getTemperature() {
        return Temperature;
    }

    public void setTemperature(Short temperature) {
        Temperature = temperature;
    }

    public Float getWeightInvoice() {
        return WeightInvoice;
    }

    public void setWeightInvoice(Float weightInvoice) {
        WeightInvoice = weightInvoice;
    }

    public Float getVolumeOfTheRailwayTank() {
        return VolumeOfTheRailwayTank;
    }

    public void setVolumeOfTheRailwayTank(Float volumeOfTheRailwayTank) {
        VolumeOfTheRailwayTank = volumeOfTheRailwayTank;
    }

    public Float getActualWeight() {
        return ActualWeight;
    }

    public void setActualWeight(Float actualWeight) {
        ActualWeight = actualWeight;
    }

    public Float getDifferenceActInv() {
        return DifferenceActInv;
    }

    public void setDifferenceActInv(Float differenceActInv) {
        DifferenceActInv = differenceActInv;
    }

    @Override
    public String toString() {
        return "Data{" +
                "Id=" + Id +
                ", Substance='" + Substance + '\'' +
                ", DateOfArrival='" + DateOfArrival + '\'' +
                ", RailwayTankNumber=" + RailwayTankNumber +
                ", DateOfDrain='" + DateOfDrain + '\'' +
                ", TypeOfRailwayTank='" + TypeOfRailwayTank + '\'' +
                ", Overflow=" + Overflow +
                ", Density=" + Density +
                ", Temperature=" + Temperature +
                ", WeightInvoice=" + WeightInvoice +
                ", VolumeOfTheRailwayTank=" + VolumeOfTheRailwayTank +
                ", ActualWeight=" + ActualWeight +
                ", DifferenceActInv=" + DifferenceActInv +
                '}';
    }
}
