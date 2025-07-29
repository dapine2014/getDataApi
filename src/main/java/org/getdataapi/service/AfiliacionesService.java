package org.getdataapi.service;

import lombok.RequiredArgsConstructor;
import org.getdataapi.dto.AfiliacionDto;
import org.getdataapi.dto.TokenResponseDto;
import org.getdataapi.dto.input.InputAfiliadoDto;
import org.getdataapi.service.api.IAfiliaciones;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AfiliacionesService {

    private final IAfiliaciones afiliacionesClient;
    private final TokenService tokenService;

    public List<AfiliacionDto> consultarAfiliado( List<InputAfiliadoDto> afiliaciones) {
        TokenResponseDto token = tokenService.obtainToken();

         afiliaciones.forEach(afiliacion -> {

             afiliacionesClient.consultarAfiliado("Bearer " + token.getAccessToken(), afiliacion.getTipoDocumento(), afiliacion.getNumeroDocumento());

         });



        return null;
    }


}
