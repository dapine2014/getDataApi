package org.getdataapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.getdataapi.dto.TokenResponseDto;
import org.getdataapi.dto.input.InputAfiliadoDto;
import org.getdataapi.dto.input.InputSedeEmpresaDto;
import org.getdataapi.dto.response.EmpresaSede;
import org.getdataapi.service.api.ISedes;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmpresaSedeService {

    private final ISedes sedesClient;
    private final TokenService tokenService;
    private LocalDateTime tokenExpirationTime;
    private String tokenData = null;

    public List<EmpresaSede> consultarEmpresaSedes(List<InputSedeEmpresaDto> empresaSedes){

       int index = 0;
       List<EmpresaSede> salida = new ArrayList<>();
       if(isTokenExpiredOrMissing()) {
           TokenResponseDto token = tokenService.obtainToken();
           tokenData = token.getAccessToken();
           tokenExpirationTime = LocalDateTime.now().plusSeconds(token.getExpiresIn() - 30);
       }
       try{
            log.info("######### INICIANDO PROCESO SEDES ##########");
              while (index < empresaSedes.size()) {
                  log.info("######### INICIO  SEDE : " + empresaSedes.get(index).getIdEmpresa());
                  List<EmpresaSede> sedesRest = sedesClient.consultarEmpresaSedes("Bearer " + tokenData, empresaSedes.get(index).getTipoDocumento(), empresaSedes.get(index).getIdEmpresa());
                  salida.addAll(sedesRest);
                  log.info("procesados : " + sedesRest.size());
                  log.info("######### FIN  SEDE : " + empresaSedes.get(index).getIdEmpresa());
                  //Thread.sleep(2000);
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
