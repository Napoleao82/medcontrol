package br.com.medcontrol.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cirugiao",
        "paciente",
        "dataCirurgia",
        "tipoCirurgia"
})
@Generated("jsonschema2pojo")
public class Cirurgia {

    @JsonProperty("cirugiao")
    private String cirugiao;
    @JsonProperty("paciente")
    private String paciente;
    @JsonProperty("dataCirurgia")
    private String dataCirurgia;
    @JsonProperty("tipoCirurgia")
    private String tipoCirurgia;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("cirugiao")
    public String getCirugiao() {
        return cirugiao;
    }

    @JsonProperty("cirugiao")
    public void setCirugiao(String cirugiao) {
        this.cirugiao = cirugiao;
    }

    @JsonProperty("paciente")
    public String getPaciente() {
        return paciente;
    }

    @JsonProperty("paciente")
    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    @JsonProperty("dataCirurgia")
    public String getDataCirurgia() {
        return dataCirurgia;
    }

    @JsonProperty("dataCirurgia")
    public void setDataCirurgia(String dataCirurgia) {
        this.dataCirurgia = dataCirurgia;
    }

    @JsonProperty("tipoCirurgia")
    public String getTipoCirurgia() {
        return tipoCirurgia;
    }

    @JsonProperty("tipoCirurgia")
    public void setTipoCirurgia(String tipoCirurgia) {
        this.tipoCirurgia = tipoCirurgia;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
