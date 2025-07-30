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


    private List<ResponseAfiliado> salida = new ArrayList<>();
    private LocalDateTime tokenExpirationTime;

    public List<ResponseAfiliado> consultarAfiliado( List<InputAfiliadoDto> afiliaciones) {

        if(isTokenExpiredOrMissing()) {
            TokenResponseDto token = tokenService.obtainToken();
            tokenData = token.getAccessToken();
            tokenExpirationTime = LocalDateTime.now().plusSeconds(token.getExpiresIn() - 30);
        }
        try {
            log.info("######### INICIANDO PROCESO AFILIACION ##########");

            /*afiliaciones.forEach(afiliacion -> {
                try {
                    log.info("afiliado :"+ afiliacion.getNumeroDocumento());
                    List<ResponseAfiliado> test = afiliacionesClient.consultarAfiliado("Bearer " + tokenData, afiliacion.getTipoDocumento(), afiliacion.getNumeroDocumento());
                    salida.addAll(test);

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });*/

            for(int index = 0; index < afiliaciones.size(); index++){
                log.info("######### INICIO  AFILIACION : "+ afiliaciones.get(index).getNumeroDocumento() );
                log.info("afiliado :"+ afiliaciones.get(index).getNumeroDocumento());
                List<ResponseAfiliado> test = afiliacionesClient.consultarAfiliado("Bearer " + tokenData, afiliaciones.get(index).getTipoDocumento(), afiliaciones.get(index).getNumeroDocumento());
                salida.addAll(test);
                Thread.sleep(2000);
                log.info("procesados : " + test.size());
                log.info("######### FIN  AFILIACION :+ "+ afiliaciones.get(index).getNumeroDocumento());
            }

            log.info("######### FINALIZANDO PROCESO AFILIACION ##########");

        }catch (Exception e){
            log.error("######### ERROR  AFILIACION ##########");
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return salida;
    }


    /*public String consultarAfiliadoSQS( List<InputAfiliadoDto> afiliaciones) {

        Runnable procesadorAfiliacion = new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("######### INICIANDO PROCESO AFILIACION ##########");

                    if(isTokenExpiredOrMissing()) {
                        TokenResponseDto token = tokenService.obtainToken();
                        tokenData = token.getAccessToken();
                        tokenExpirationTime = LocalDateTime.now().plusSeconds(token.getExpiresIn() - 30);
                    }


                }
                catch (Exception e) {
                    log.error("Error en el proceso de afiliación: {}", e.getMessage());
                }
            }
        };

        Thread thread = new Thread(procesadorAfiliacion);
        thread.start();

        return  "";
    }*/


    private boolean isTokenExpiredOrMissing() {
        return tokenData == null
                || tokenExpirationTime == null
                || LocalDateTime.now().isAfter(tokenExpirationTime);
    }
/*
    private MessageDto createMessage(String uti, List<ResponseAfiliado> request) {
        return new MessageDto(uti, request);
    }

    private void produce(MessageDto message) {
        try {
            log.info("Sending Message to RabbitMQ: " + message);
            publisherRMQ.send(message);
            //rabbitTemplate.convertAndSend(PaymentStatus.QUEUE_NAME.getValue(), message);
        } catch (Exception exception) {
            log.error("Error sending Message to RabbitMQ: " + exception.getMessage());
        }
    }*/


}
