package pl.sda.orange.java2.event.dto;

import pl.sda.orange.java2.event.entity.Event;

public class EventDtoMapper {

    public static EventDto mapToEventDto(Event event){

        return EventDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .description(event.getDescription())
                .host(event.getHost())
                .attendees(event.getAttendees())
                .build();
    }

    public static Event mapToEvent(EventDto eventDto){

        Event event = new Event();
        event.setId(eventDto.getId());
        event.setTitle(eventDto.getTitle());
        event.setStartDate(eventDto.getStartDate());
        event.setEndDate(eventDto.getEndDate());
        event.setDescription(eventDto.getDescription());
        event.setHost(eventDto.getHost());
        event.setAttendees(eventDto.getAttendees());

        return event;
    }
}
