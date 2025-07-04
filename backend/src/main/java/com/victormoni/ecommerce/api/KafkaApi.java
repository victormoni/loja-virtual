package com.victormoni.ecommerce.api;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.victormoni.ecommerce.dto.response.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * @author Victor Moni
 */

@Tag(name = "Kafka", description = "Endpoints para envio de eventos ao Kafka")
public interface KafkaApi {

    @Operation(summary = "Enviar evento ao Kafka", description = "Envia um evento OrderEvent para o Kafka com o status informado")
    @ApiResponse(responseCode = "200", description = "Evento enviado com sucesso", content = @Content(mediaType = "text/plain", examples = @ExampleObject(name = "OK", value = "Evento enviado com status: NEW")))
    @ApiResponse(responseCode = "400", description = "Parâmetro 'status' ausente ou inválido", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class), examples = @ExampleObject(name = "Bad Request", value = "{\"error\":\"O status é obrigatório\"}")))
    ResponseEntity<String> sendEvent(@RequestParam String status);
}
