package br.com.guilherme.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2025-07-23T14:37:56.563-0300")
@StaticMetamodel(Aula.class)
public class Aula_ {
	public static volatile SingularAttribute<Aula, Integer> id;
	public static volatile SingularAttribute<Aula, String> nome;
	public static volatile SingularAttribute<Aula, Integer> duracao;
	public static volatile SingularAttribute<Aula, Integer> posicao;
	public static volatile SingularAttribute<Aula, Modulo> modulo;
}
