package org.getdataapi.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InputSedeEmpresaDto {
    private String tipoDocumento;
    private String idEmpresa;
}
