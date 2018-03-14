package com.jsfsi.sample.modules.patient.resources;

import com.jsfsi.sample.core.hateoas.HateoasLinkReference;
import com.jsfsi.sample.extensibility.patient.PatientSearchFilters;
import com.jsfsi.sample.extensibility.rest.HateoasLink;
import com.jsfsi.sample.extensibility.rest.HateoasRel;
import com.jsfsi.sample.extensibility.rest.HttpMethod;
import com.jsfsi.sample.modules.patient.Version;

public class HateoasLinkInjector {
    public static final String BASE_PATH = Version.NAME + Version.PATIENT_PATH;

    private static HateoasLink speciesLink = new HateoasLink<>();
    private static HateoasLink statesLink = new HateoasLink<>();

    private static HateoasLink<PatientSearchFilters> searchLink = new HateoasLink<>();
    private static HateoasLink<PatientSearchFilters> patientLink = new HateoasLink<>();

    public static void injectSearch(){
        String searchLinkPath = String.format("%s/search", BASE_PATH);

        searchLink.setMethod(HttpMethod.GET);
        searchLink.setRequiresAuthentication(true);
        searchLink.setRel(HateoasRel.SEARCH_PATIENT);
        searchLink.setHref(searchLinkPath + "{?patientName,clientName,clientNumber,patientNumber,cardNumber,chipNumber,specie,state}");

        HateoasLinkReference.inject(searchLinkPath,searchLink);
    }

    public static void injectFilters(){
        speciesLink.setMethod(HttpMethod.GET);
        speciesLink.setRel(HateoasRel.PATIENT_SPECIES);
        speciesLink.setRequiresAuthentication(true);

        HateoasLinkReference.inject(String.format("%s/species", BASE_PATH),speciesLink);

        statesLink.setMethod(HttpMethod.GET);
        statesLink.setRel(HateoasRel.PATIENT_STATES);
        statesLink.setRequiresAuthentication(true);

        HateoasLinkReference.inject(String.format("%s/states", BASE_PATH),statesLink);
    }

    public static void injectDetails(){
        patientLink.setMethod(HttpMethod.GET);
        patientLink.setRel(HateoasRel.PATIENT);
        patientLink.setRequiresAuthentication(true);

        HateoasLinkReference.inject(String.format("%s/{id}", BASE_PATH),patientLink);
    }
}
