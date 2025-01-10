package doctorappointment.doctoravailability.Repository;

import doctorappointment.doctoravailability.Entity.Slot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SlotRepository extends MongoRepository<Slot, UUID> {

    // Find all slots by doctor ID where the slot is not reserved
    List<Slot> findByDoctorNameAndIsReservedFalse(String doctorName);

    // Find all slots
    List<Slot> findAll();

    // Find a slot by its ID (returns Optional<Slot>)
    Optional<Slot> findById(UUID slotId);

    List<Slot> findByIsReservedFalse();
}