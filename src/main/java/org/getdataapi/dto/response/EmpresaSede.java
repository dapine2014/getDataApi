package org.getdataapi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaSede implements Serializable {

    @JsonProperty("idTipoDoc")
    private String idTipoDoc;

    @JsonProperty("idEmpresa")
    private String idEmpresa;

    @JsonProperty("idSucursal")
    private int idSucursal;

    @JsonProperty("idSede")
    private int idSede;

    @JsonProperty("idActEconomica")
    private int idActEconomica;

    @JsonProperty("idDepartamento")
    private int idDepartamento;

    @JsonProperty("idMunicipio")
    private int idMunicipio;

    @JsonProperty("nombreSede")
    private String nombreSede;

    @JsonProperty("direccionSedeEmpresa")
    private String direccionSedeEmpresa;

    @JsonProperty("telefonoSedeEmpresa")
    private String telefonoSedeEmpresa;

    @JsonProperty("emailSedeEmpresa")
    private String emailSedeEmpresa;

    @JsonProperty("indZona")
    private String indZona;

    @JsonProperty("indPrincipal")
    private int indPrincipal;

    @JsonProperty("tdocResponsable")
    private String tdocResponsable;

    @JsonProperty("ndocResponsable")
    private String ndocResponsable;

    @JsonProperty("tdocEmpMision")
    private String tdocEmpMision;

    @JsonProperty("ndocEmpMision")
    private String ndocEmpMision;

    @JsonProperty("sedeEnMision")
    private String sedeEnMision;

    @JsonProperty("estado")
    private int estado;
}
