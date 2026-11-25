package com.exemplo.webservices.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private long id;
    private String nome;
    private double preco;
    private boolean disponivel;

}
