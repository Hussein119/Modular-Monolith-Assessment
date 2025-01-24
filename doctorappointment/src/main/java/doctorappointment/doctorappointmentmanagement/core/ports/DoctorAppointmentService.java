package doctorappointment.doctorappointmentmanagement.core.ports;

import doctorappointment.appointmentbooking.Domain.Appointment;
import java.util.List;

public interface DoctorAppointmentService {
    List<Appointment> getUpcomingAppointments();
    void markAppointmentAsCompleted(String appointmentId);
    void cancelAppointment(String appointmentId);
}