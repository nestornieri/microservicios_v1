package com.example.demoMicro;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("aplicacion.nombre", "Tema 13 - deplegar microservicio cliente");
        builder.withDetail("aplicacion.version", "1.0.0");
        builder.withDetail("desarrollador.nombre", "Liz Cabrera");
        builder.withDetail("desarrollador.correo", "liz.cabrera@gmail.com");
    }
}