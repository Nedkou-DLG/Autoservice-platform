package com.nedyalkoboydev.autoserviceplatform.application.services.contracts;

import com.nedyalkoboydev.autoserviceplatform.domain.dtos.AutocompleteDataDTO;
import com.nedyalkoboydev.autoserviceplatform.domain.models.SearchModel;

import java.util.List;

public interface IAutocompleteService {

    List<AutocompleteDataDTO> searchCarService(SearchModel model);
    List<AutocompleteDataDTO> searchEmployee(SearchModel model);
    List<AutocompleteDataDTO> searchServiceTypes(SearchModel model);

    List<AutocompleteDataDTO> searchMyVehicles(SearchModel model);
}
