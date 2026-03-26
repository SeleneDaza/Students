package co.edu.uptc.actividadDos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private String programa;
    private String ipOrigen;
    private T datos;
}