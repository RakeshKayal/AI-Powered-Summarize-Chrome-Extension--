package com.Ai.Summary_Assistant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
@CrossOrigin(origins = {"*"})
public class ResearchController {
    @Autowired
    public  ResearchService service;

    @PostMapping("/get")
    public String response(@RequestBody ResearchRequest request){

        return  service.ProcessContent(request);

    }
}
