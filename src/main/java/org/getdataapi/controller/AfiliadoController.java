package org.getdataapi.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.getdataapi.dto.input.InputAfiliadoDto;
import org.getdataapi.dto.input.InputSedeEmpresaDto;
import org.getdataapi.service.AfiliacionesService;
import org.getdataapi.service.EmpresaSedeService;
import org.getdataapi.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
@Slf4j
public class AfiliadoController {

    private final AfiliacionesService afiliacionesService;
    private final EmpresaSedeService empresaSedeService;

    @PostMapping("/afiliados")
    public ResponseEntity<Object> getAfiliado(@RequestBody List<InputAfiliadoDto> afiliado){
         Object afiliados = afiliacionesService.consultarAfiliado(afiliado);
         return ResponseEntity.ok(afiliados);
    }

    @PostMapping("/sedes")
    public ResponseEntity<Object> getSedes(@RequestBody List<InputSedeEmpresaDto> afiliado){
        Object sedes = empresaSedeService.consultarEmpresaSedes(afiliado);
         return ResponseEntity.ok(sedes);
    }

}
