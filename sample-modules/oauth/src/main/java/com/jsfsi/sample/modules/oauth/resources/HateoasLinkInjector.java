package com.jsfsi.sample.modules.oauth.resources;

import com.jsfsi.sample.core.hateoas.HateoasLinkReference;
import com.jsfsi.sample.extensibility.patient.PatientSearchFilters;
import com.jsfsi.sample.extensibility.rest.HateoasLink;
import com.jsfsi.sample.extensibility.rest.HateoasRel;
import com.jsfsi.sample.extensibility.rest.HttpMethod;
import com.jsfsi.sample.extensibility.user.OAuthCredentials;
import com.jsfsi.sample.modules.oauth.Version;

public class HateoasLinkInjector {
    public static final String BASE_PATH = Version.NAME + Version.OAUTH_PATH;

    private static HateoasLink<OAuthCredentials> tokenLink = new HateoasLink<>();
    private static HateoasLink userLink = new HateoasLink();

    public static void inject(){
        tokenLink.setMethod(HttpMethod.POST);
        tokenLink.setBody(new OAuthCredentials());
        tokenLink.setRel(HateoasRel.OAUTH);

        HateoasLinkReference.inject(String.format("%s/token", BASE_PATH),tokenLink);

        userLink.setMethod(HttpMethod.GET);
        userLink.setRel(HateoasRel.USER);
        userLink.setRequiresAuthentication(true);

        HateoasLinkReference.inject(String.format("%s/user", BASE_PATH),userLink);
    }

    public static void injectDetails(){
        HateoasLink<PatientSearchFilters> patientLink = new HateoasLink<>();
        patientLink.setMethod(HttpMethod.GET);
        patientLink.setRel(HateoasRel.PATIENT);
        patientLink.setRequiresAuthentication(true);

        HateoasLinkReference.inject(String.format("%s/filters", BASE_PATH),patientLink);
    }
}
