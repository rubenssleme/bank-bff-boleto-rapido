package br.com.bank.generated.capd_bff_boleto_rapido.model;

import java.net.URI;
import java.util.Objects;
import br.com.bank.generated.capd_bff_boleto_rapido.model.ErrorDetail;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Modelo que representa um erro na resposta da API
 */

@Schema(name = "Error", description = "Modelo que representa um erro na resposta da API")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-08-22T14:12:24.313237200-03:00[America/Sao_Paulo]")
public class Error {

  @Valid
  private List<@Valid ErrorDetail> errors;

  public Error errors(List<@Valid ErrorDetail> errors) {
    this.errors = errors;
    return this;
  }

  public Error addErrorsItem(ErrorDetail errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Lista de erros
   * @return errors
  */
  @Valid 
  @Schema(name = "errors", description = "Lista de erros", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errors")
  public List<@Valid ErrorDetail> getErrors() {
    return errors;
  }

  public void setErrors(List<@Valid ErrorDetail> errors) {
    this.errors = errors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.errors, error.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

