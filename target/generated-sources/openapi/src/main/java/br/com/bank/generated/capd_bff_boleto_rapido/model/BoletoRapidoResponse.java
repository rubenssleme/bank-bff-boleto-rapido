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
 * BoletoRapidoResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-05-25T08:46:35.092326173-03:00[America/Sao_Paulo]")
public class BoletoRapidoResponse {

  private String idProduto;

  public BoletoRapidoResponse idProduto(String idProduto) {
    this.idProduto = idProduto;
    return this;
  }

  /**
   * Precisamos retornar todos os dados referentes ao boleto gerado.
   * @return idProduto
  */
  
  @Schema(name = "idProduto", description = "Precisamos retornar todos os dados referentes ao boleto gerado.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("idProduto")
  public String getIdProduto() {
    return idProduto;
  }

  public void setIdProduto(String idProduto) {
    this.idProduto = idProduto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BoletoRapidoResponse boletoRapidoResponse = (BoletoRapidoResponse) o;
    return Objects.equals(this.idProduto, boletoRapidoResponse.idProduto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idProduto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BoletoRapidoResponse {\n");
    sb.append("    idProduto: ").append(toIndentedString(idProduto)).append("\n");
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

