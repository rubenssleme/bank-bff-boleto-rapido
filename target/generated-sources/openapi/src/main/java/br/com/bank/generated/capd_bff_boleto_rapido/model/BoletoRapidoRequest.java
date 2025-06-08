package br.com.bank.generated.capd_bff_boleto_rapido.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * BoletoRapidoRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-08T22:43:07.164479981Z[Etc/UTC]")
public class BoletoRapidoRequest {

  private String valorNominalTitulo;

  /**
   * Este campo refere-se ao tipo de dispositivo que está cahamdo o bff
   */
  public enum DispositivoEnum {
    WEB("WEB"),
    
    MOBILE("MOBILE");

    private String value;

    DispositivoEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DispositivoEnum fromValue(String value) {
      for (DispositivoEnum b : DispositivoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private DispositivoEnum dispositivo;

  public BoletoRapidoRequest valorNominalTitulo(String valorNominalTitulo) {
    this.valorNominalTitulo = valorNominalTitulo;
    return this;
  }

  /**
   * Este valor refere-se ao valor que será depositado. Nome do atributo no srv vlNominalTitulo.
   * @return valorNominalTitulo
  */
  
  @Schema(name = "valorNominalTitulo", example = "10,00", description = "Este valor refere-se ao valor que será depositado. Nome do atributo no srv vlNominalTitulo.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("valorNominalTitulo")
  public String getValorNominalTitulo() {
    return valorNominalTitulo;
  }

  public void setValorNominalTitulo(String valorNominalTitulo) {
    this.valorNominalTitulo = valorNominalTitulo;
  }

  public BoletoRapidoRequest dispositivo(DispositivoEnum dispositivo) {
    this.dispositivo = dispositivo;
    return this;
  }

  /**
   * Este campo refere-se ao tipo de dispositivo que está cahamdo o bff
   * @return dispositivo
  */
  
  @Schema(name = "dispositivo", example = "MOBILE", description = "Este campo refere-se ao tipo de dispositivo que está cahamdo o bff", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dispositivo")
  public DispositivoEnum getDispositivo() {
    return dispositivo;
  }

  public void setDispositivo(DispositivoEnum dispositivo) {
    this.dispositivo = dispositivo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BoletoRapidoRequest boletoRapidoRequest = (BoletoRapidoRequest) o;
    return Objects.equals(this.valorNominalTitulo, boletoRapidoRequest.valorNominalTitulo) &&
        Objects.equals(this.dispositivo, boletoRapidoRequest.dispositivo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valorNominalTitulo, dispositivo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BoletoRapidoRequest {\n");
    sb.append("    valorNominalTitulo: ").append(toIndentedString(valorNominalTitulo)).append("\n");
    sb.append("    dispositivo: ").append(toIndentedString(dispositivo)).append("\n");
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

