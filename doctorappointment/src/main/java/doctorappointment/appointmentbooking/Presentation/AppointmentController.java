package doctorappointment.appointmentbooking.Presentation;

import doctorappointment.appointmentbooking.Application.AppointmentService;
import doctorappointment.appointmentbooking.Domain.Appointment;
import doctorappointment.doctoravailability.Entity.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/available-slots")
    public List<Slot> viewAvailableSlots() {
        return appointmentService.viewAvailableSlots();
    }

    @PostMapping("/book")
    public ResponseEntity<Appointment> bookAppointment(@RequestBody BookAppointmentRequest request) {
        Appointment appointment = appointmentService.bookAppointment(
                request.getSlotId(),
                request.getPatientName()
        );
        return ResponseEntity.ok(appointment);
    }
}
