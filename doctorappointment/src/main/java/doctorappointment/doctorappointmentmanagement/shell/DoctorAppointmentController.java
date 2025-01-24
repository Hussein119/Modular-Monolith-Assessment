package doctorappointment.doctorappointmentmanagement.shell;

import doctorappointment.appointmentbooking.Domain.Appointment;
import doctorappointment.doctorappointmentmanagement.core.ports.DoctorAppointmentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/doctor/appointments")
public class DoctorAppointmentController {

    @Autowired
    private DoctorAppointmentService appointmentService;

    @GetMapping("/upcoming")
    public List<Appointment> getUpcomingAppointments() {
        return appointmentService.getUpcomingAppointments();
    }

    @PutMapping("/{id}/complete")
    public void markAppointmentAsCompleted(@PathVariable String id) {
        appointmentService.markAppointmentAsCompleted(id);
    }

    @DeleteMapping("/{id}")
    public void cancelAppointment(@PathVariable String id) {
        appointmentService.cancelAppointment(id);
    }
}
