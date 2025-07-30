package org.getdataapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.getdataapi.dto.response.ResponseAfiliado;


import java.util.List;

@Data // Genera getters, setters, toString, equals y hashCode
@NoArgsConstructor // Constructor sin argumentos
@AllArgsConstructor // Constructor con todos los argumentos
public class MessageDto {
    private String messageHeaders;
    private Object messageBody;

    // Constructor
    public MessageDto(String uti, List<ResponseAfiliado> request) {
        this.messageHeaders = uti;
        this.messageBody = request;
    }
}
