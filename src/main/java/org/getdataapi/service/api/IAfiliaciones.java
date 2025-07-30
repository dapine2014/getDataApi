package org.getdataapi.service.api;

import org.getdataapi.dto.response.ResponseAfiliado;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "get-afiliacion",url ="https://core-positiva-apis-prod-apicast-staging.apps.openshift4.positiva.gov.co/validacionafiliado/v2/positiva/scp/afiliado")
public interface IAfiliaciones {

    @GetMapping("/consultaAfiliadoEmpresa")
    List<ResponseAfiliado> consultarAfiliado(@RequestHeader("Authorization") String token,
                                             @RequestParam("idTipoDoc") String tipoDocumento,
                                             @RequestParam("idAfiliado") String numeroDocumento
    );

}
