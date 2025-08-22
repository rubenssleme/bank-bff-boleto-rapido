package br.com.bank.generated.capd_bff_boleto_rapido.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Detalhes dos erros listados.
 */

@Schema(name = "ErrorDetail", description = "Detalhes dos erros listados.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-22T14:13:09.803280500-03:00[America/Sao_Paulo]")
public class ErrorDetail {

  private String code;

  private String message;

  private String details;

  public ErrorDetail code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Código do erro HTTP
   * @return code
  */
  
  @Schema(name = "code", example = "500", description = "Código do erro HTTP", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorDetail message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Mensagem de erro resumida
   * @return message
  */
  
  @Schema(name = "message", example = "Erro interno do servidor", description = "Mensagem de erro resumida", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorDetail details(String details) {
    this.details = details;
    return this;
  }

  /**
   * Detalhes do erro
   * @return details
  */
  
  @Schema(name = "details", example = "Um erro inesperado ocorreu no servidor", description = "Detalhes do erro", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("details")
  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetail errorDetail = (ErrorDetail) o;
    return Objects.equals(this.code, errorDetail.code) &&
        Objects.equals(this.message, errorDetail.message) &&
        Objects.equals(this.details, errorDetail.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetail {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

