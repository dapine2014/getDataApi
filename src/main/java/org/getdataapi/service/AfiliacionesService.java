package org.getdataapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.getdataapi.dto.TokenResponseDto;
import org.getdataapi.dto.input.InputAfiliadoDto;
import org.getdataapi.dto.response.ResponseAfiliado;
import org.getdataapi.service.api.IAfiliaciones;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AfiliacionesService {

    private final IAfiliaciones afiliacionesClient;
    private final TokenService tokenService;
    private String tokenData = null;


    //private List<ResponseAfiliado> salida = new ArrayList<>();
    private LocalDateTime tokenExpirationTime;

    public List<ResponseAfiliado> consultarAfiliado( List<InputAfiliadoDto> afiliaciones) {
         int index = 0;
         List<ResponseAfiliado> salida = new ArrayList<>();
        if(isTokenExpiredOrMissing()) {
            TokenResponseDto token = tokenService.obtainToken();
            tokenData = token.getAccessToken();
            tokenExpirationTime = LocalDateTime.now().plusSeconds(token.getExpiresIn() - 30);
        }
        try {
            log.info("######### INICIANDO PROCESO AFILIACION ##########");


            while (index < afiliaciones.size()) {

                    log.info("######### INICIO  AFILIACION : " + afiliaciones.get(index).getNumeroDocumento());
                    log.info("afiliado :" + afiliaciones.get(index).getNumeroDocumento());
                    List<ResponseAfiliado> afiliadoRest = afiliacionesClient.consultarAfiliado("Bearer " + tokenData, afiliaciones.get(index).getTipoDocumento(), afiliaciones.get(index).getNumeroDocumento());
                    salida.addAll(afiliadoRest);
                    log.info("procesados : " + afiliadoRest.size());
                    log.info("######### FIN  AFILIACION : " + afiliaciones.get(index).getNumeroDocumento());
                Thread.sleep(2000);

                    index++;
            }


            log.info("######### FINALIZANDO PROCESO AFILIACION ##########");

        }catch (Exception e){
            tokenData = null;
            log.error("######### ERROR  AFILIACION ##########");
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return salida;
    }



    private boolean isTokenExpiredOrMissing() {
        return tokenData == null
                || tokenExpirationTime == null
                || LocalDateTime.now().isAfter(tokenExpirationTime);
    }

}
