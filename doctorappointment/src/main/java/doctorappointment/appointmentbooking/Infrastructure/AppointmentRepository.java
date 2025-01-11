package doctorappointment.appointmentbooking.Infrastructure;

import doctorappointment.appointmentbooking.Domain.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AppointmentRepository extends MongoRepository<Appointment, UUID> {
}
