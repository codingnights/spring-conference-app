package com.capgemini.codingnight.repository;

import com.capgemini.codingnight.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by WDELPEUT on 29-5-2017.
 */
@Component
public class EventsRepository {

    @Qualifier("dataSource")
    @Autowired
    private DataSource datasource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(datasource);
    }

    public List<Event> getAllEvents() throws URISyntaxException {
       List<Event> eventList = new ArrayList<Event>();
       List<Map<String, Object>> maps = jdbcTemplate().queryForList("select * from Events");
       for(Map map : maps) {
           Event event = new Event();
           event.setId(Long.valueOf((Integer) map.get("ID")));
           event.setTitle((String) map.get("title"));
           event.setEventDate((String) map.get("date"));
           event.setDescription((String) map.get("description"));
           event.setEventLocation((String) map.get("location"));
           event.setSubject((String) map.get("subject"));
           event.setUrl(new URI((String) map.get("URI")));

           eventList.add(event);
       }

        return eventList;
    }

    public void insertEvent(Event event) {
        String sqlStatement = "INSERT INTO events(title, date, subject, location, URI, description) VALUE(?, ?, ?, ?, ?, ?)";
        Object objectParams[] = new Object[]{
                event.getTitle(),
                event.getEventDate(),
                event.getSubject(),
                event.getEventLocation(),
                event.getUrl(),
                event.getDescription()
        };

        jdbcTemplate().update(sqlStatement, objectParams);
    }
}
