package doctorappointment.doctorappointmentmanagement.core.services;

import doctorappointment.appointmentbooking.Domain.Appointment;
import doctorappointment.doctorappointmentmanagement.core.ports.DoctorAppointmentService;
import doctorappointment.appointmentbooking.Infrastructure.AppointmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service("bookingAppointmentService")
public class DoctorAppointmentServiceImpl implements DoctorAppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getUpcomingAppointments() {
        return appointmentRepository.findByIsCompletedFalse();
    }

    @Override
    public void markAppointmentAsCompleted(String appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Appointment not found with ID: " + appointmentId
                ));
        appointment.markAsCompleted();
        appointmentRepository.save(appointment);
    }

    @Override
    public void cancelAppointment(String appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}