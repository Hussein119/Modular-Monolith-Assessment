package doctorappointment.doctoravailability.Repository;

import doctorappointment.doctoravailability.Entity.Slot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SlotRepository extends MongoRepository<Slot, UUID> {

    List<Slot> findAll();

    Optional<Slot> findById(String slotId);

    List<Slot> findByIsReservedFalse();
}