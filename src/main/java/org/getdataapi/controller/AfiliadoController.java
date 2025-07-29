package org.getdataapi.controller;


import lombok.RequiredArgsConstructor;
import org.getdataapi.dto.input.InputAfiliadoDto;
import org.getdataapi.service.AfiliacionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class AfiliadoController {

    private final AfiliacionesService afiliacionesService;
    @PostMapping("/afiliados")
    public ResponseEntity<Object> getAfiliado(@RequestBody List<InputAfiliadoDto> afiliado){
         Object afiliados = afiliacionesService.consultarAfiliado(afiliado);
         return ResponseEntity.ok(afiliados);
    }
}
