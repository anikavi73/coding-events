package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("events")

public class EventsController {

    @GetMapping
    public String displayAllEvents(Model model){
      model.addAttribute("title", "All Events");
      model.addAttribute("events", EventData.getAll());
      return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model){
        model.addAttribute("title", "Create Events");
        model.addAttribute(new Event());
        return "events/create";
    }

    //Using Model-Binding by using  Spring will create the newEvent instance
    @PostMapping("create")
//    public String processCreateEventForm(@ModelAttribute Event newEvent){
    // add valid and errors and if loop
    public String processCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model){

        if (errors.hasErrors()){
            model.addAttribute("title", "Create Events");
//            model.addAttribute("errorMsg", "Bad data!");
            return "events/create";
        }

        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds){
        if(eventIds!= null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        // PathVariable is the variable in the url
        Event event = EventData.getById(eventId); // calling static method so no need of instance
        model.addAttribute("event", event);
        if (event != null) {
            model.addAttribute("title", "Edit Event " + event.getName() + "(Id=" + event.getId() + ")");
        }
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        // controller code will go here
        Event event = EventData.getById(eventId);
        event.setName(name);
        event.setDescription(description);
        return "redirect:";

    }
}
