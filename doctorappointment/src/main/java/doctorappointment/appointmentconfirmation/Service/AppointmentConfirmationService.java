package doctorappointment.appointmentconfirmation.Service;

import doctorappointment.appointmentconfirmation.Entity.AppointmentConfirmation;
import org.springframework.stereotype.Service;

@Service
public class AppointmentConfirmationService {

    public void sendConfirmation(AppointmentConfirmation confirmation) {
        String message = String.format(
                "Confirmation: Appointment booked for %s with %s at %s.",
                confirmation.getPatientName(),
                confirmation.getDoctorName(),
                confirmation.getAppointmentTime()
        );
        // assume send notification to patient and doctor
        System.out.println(message);
    }
}