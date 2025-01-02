package doctorappointment.doctoravailability.Entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Slot {
    private UUID id;
    private LocalDateTime time;
    private String doctorName;
    private boolean isReserved;
    private double cost;

    // Constructor
    public Slot(UUID id, LocalDateTime time, String doctorName, boolean isReserved, double cost) {
        this.id = id;
        this.time = time;
        this.doctorName = doctorName;
        this.isReserved = isReserved;
        this.cost = cost;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}