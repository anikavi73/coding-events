package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")

public class EventsController {

    @GetMapping
    public String displayAllEvents(Model model){

        Map<String, String> eventsCode = new HashMap<>();
        eventsCode.put("Code with Pride", "LGBT Friendly Coding meetup");
        eventsCode.put("Strange Loop", "Loops that are strange");
        eventsCode.put("Apple WWDC", "Event for people with pricey computers");

        model.addAttribute("events", eventsCode);

        return "events/index";
    }
}
