package com.jobsedule.report.controller;

import com.jobsedule.report.domain.ApiTypeEnum;
import com.jobsedule.report.domain.ElementTypeEnum;
import com.jobsedule.report.util.ReportProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@Slf4j
public class ReportController {

  @Autowired private ReportProperties reportProperties;

  /*public ReportController(ReportProperties reportProperties) {
    reportProperties = this.reportProperties;
  }*/

  @GetMapping(value = "/getProperties", produces = MediaType.APPLICATION_JSON_VALUE)
  public ReportProperties getProperties() {
    log.info("Loaded Properties: {}", reportProperties.toString());
    // Fetch the hashmap value
    log.info(reportProperties.getSplunkProperties().getApi().get("accounts-and-transactions"));

    // Convert String to Enum
    log.info(
        "String to Enum : {}",
        ApiTypeEnum.valueOf(
            reportProperties.getSplunkProperties().getApi().get("accounts-and-transactions")));
    System.out.println(
        reportProperties.getSplunkProperties().getType().getConsent().entrySet().stream()
            .filter(stringListEntry -> stringListEntry.getKey().equalsIgnoreCase("CONSENT")));
    if (reportProperties.getSplunkProperties().getType().getConsent().get("CONSENT").stream()
        .anyMatch(s -> s.equals("/cpb/psd2/accounts-access-consent"))) {
      log.info("TYPE is : {}", ElementTypeEnum.CONSENT);
    } else if (reportProperties.getSplunkProperties().getType().getConsent().get("consent").stream()
        .anyMatch(s -> s.equals("/cpb/psd2/domestic-payments-consent"))) {
      log.info("TYPE is : {}", ElementTypeEnum.CONSENT);
    } else if (reportProperties
        .getSplunkProperties()
        .getType()
        .getConsent()
        .get("resource")
        .stream()
        .anyMatch(s -> s.equals("/cpb/psd2/accounts"))) {
      log.info("TYPE is : {}", ElementTypeEnum.RESOURCE);
    } else if (reportProperties.getSplunkProperties().getType().getConsent().get("others").stream()
        .anyMatch(s -> s.equals("/cpb/psd2/oidc/token"))) {
      log.info("TYPE is : {}", ElementTypeEnum.OTHERS);
    } else {
      log.info("Type is {}", "INTERNAL");
    }

    return reportProperties;
  }
}
