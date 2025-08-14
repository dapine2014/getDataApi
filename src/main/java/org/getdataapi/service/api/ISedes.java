package org.getdataapi.service.api;

import org.getdataapi.dto.response.EmpresaSede;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "get-sedes", url = "https://core-positiva-apis-prod-apicast-staging.apps.openshift4.positiva.gov.co/afiliaciones/v1/positiva/scp/afiliaciones")
public interface ISedes {


    @GetMapping("/sedes")
    List<EmpresaSede> consultarEmpresaSedes(@RequestHeader("Authorization") String token,
                                            @RequestParam("idTipoDoc") String tipoDocumento,
                                            @RequestParam("idEmpresa") String idEmpresa);
}
