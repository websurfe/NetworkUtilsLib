package com.freedii.app.spike.utilslibrary.model

import com.fasterxml.jackson.annotation.JsonProperty

/*Example of data--------
"tags":["glossary"],
"categories":["glossary"],
"topics":[],
"title":"Affordability Exemption",
"es-title":"Exención de accesibilidad",
"url":"/glossary/affordability-exemption/",
"bite":"An exemption that’s needed when applying for Catastrophic coverage for people 30 years or older whose coverage is unaffordable. Affordability exemptions are ...",
"es-bite":"Una exención que se necesita al solicitar cobertura catastrófica para personas de 30 años o más cuya cobertura no es accesible. Las exenciones de accesibilid...",
"audience":[],
"segment":[],
"insurance-status":[],
"state":[],
"condition":[]
//-------*/
data class Document(
    val tags: List<String>,
    val categories: List<String>,
    val topics: List<String>,
    val title: String,
    @JsonProperty("es-title")
    val esTitle: String,
    val url: String,
    val bite: String,
    @JsonProperty("es-bite")
    val esBite: String,
    val audience: List<String>,
    val segment: List<String>,
    @JsonProperty("insurance-status")
    val insuranceStatus: List<String>,
    val state: List<String>,
    val condition: List<String>
)
