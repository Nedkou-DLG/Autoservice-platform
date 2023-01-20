package com.nedyalkoboydev.autoserviceplatform.application.controllers;

import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IAuthenticationService;
import com.nedyalkoboydev.autoserviceplatform.application.services.contracts.IAutocompleteService;
import com.nedyalkoboydev.autoserviceplatform.domain.dtos.AutocompleteDataDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.models.SearchModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/autocomplete")
@RequiredArgsConstructor
public class AutocompleteController {

    private final IAutocompleteService autocompleteService;

    @PostMapping("/search/car-service")
    public List<AutocompleteDataDTO> SearchCarService(@RequestBody SearchModel model){
        return autocompleteService.searchCarService(model);
    }

    @PostMapping("/search/employee")
    public List<AutocompleteDataDTO> SearchEmployee(@RequestBody SearchModel model){
        return autocompleteService.searchEmployee(model);
    }

    @PostMapping("/search/type-of-services")
    public List<AutocompleteDataDTO> SearchServiceTypes(@RequestBody SearchModel model){
        return autocompleteService.searchServiceTypes(model);
    }

    @PostMapping("/search/my-vehicles")
    public List<AutocompleteDataDTO> SearchMyVehicles(@RequestBody SearchModel model){
        return autocompleteService.searchMyVehicles(model);
    }


}
