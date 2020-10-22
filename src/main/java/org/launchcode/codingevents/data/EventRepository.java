package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer>{

}
