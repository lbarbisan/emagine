package fr.umlv.ir3.emagine.apprentice;

import java.util.HashMap;
import java.util.Map;

<<<<<<< .mine
import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
=======

>>>>>>> .r503
<<<<<<< .mine
public class DepartmentEnum extends EmagineEnum{
	private static final long serialVersionUID = -2714890313691705005L;
=======
public enum DepartmentEnum {
	
	D1("Ain"),
	D2("Aisne"),
	D3("Allier"),
	D4("Alpes-de-Haute-Provence"),
	D5("Hautes-Alpes"),
	D6("Alpes-Maritimes"),
	D7("Ard�che"),
	D8("Ardennes"),
	D9("Ari�ge"),
	D10("Aube"),
	D11("Aude"),
	D12("Aveyron"),
	D13("Bouches-du-Rh�ne"),
	D14("Calvados"),
	D15("Cantal"),
	D16("Charente"),
	D17("Charente-Maritime"),
	D18("Cher"),
	D19("Corr�ze"),
	D2A("Corse-du-Sud"),
	D2B("Haute-Corse"),
	D21("C�te-d'Or"),
	D22("C�tes-d'Armor"),
	D23("Creuse"),
	D24("Dordogne"),
	D25("Doubs"),
	D26("Dr�me"),
	D27("Eure"),
	D28("Eure-et-Loir"),
	D29("Finist�re"),
	D30("Gard"),
	D31("Haute-Garonne"),
	D32("Gers"),
	D33("Gironde"),
	D34("H�rault"),
	D35("Ille-et-Vilaine"),
	D36("Indre"),
	D37("Indre-et-Loire"),
	D38("Is�re"),
	D39("Jura"),
	D40("Landes"),
	D41("Loir-et-Cher"),
	D42("Loire"),
	D43("Haute-Loire"),
	D44("Loire-Atlantique"),
	D45("Loiret"),
	D46("Lot"),
	D47("Lot-et-Garonne"),
	D48("Loz�re"),
	D49("Maine-et-Loire"),
	D50("Manche"),
	D51("Marne"),
	D52("Haute-Marne"),
	D53("Mayenne"),
	D54("Meurthe-et-Moselle"),
	D55("Meuse"),
	D56("Morbihan"),
	D57("Moselle"),
	D58("Ni�vre"),
	D59("Nord"),
	D60("Oise"),
	D61("Orne"),
	D62("Pas-de-Calais"),
	D63("Puy-de-D�me"),
	D64("Pyr�n�es-Atlantiques"),
	D65("Hautes-Pyr�n�es"),
	D66("Pyr�n�es-Orientales"),
	D67("Bas-Rhin"),
	D68("Haut-Rhin"),
	D69("Rh�ne"),
	D70("Haute-Sa�ne"),
	D71("Sa�ne-et-Loire"),
	D72("Sarthe"),
	D73("Savoie"),
	D74("Haute-Savoie"),
	D75("Paris"),
	D76("Seine-Maritime"),
	D77("Seine-et-Marne"),
	D78("Yvelines"),
	D79("Deux-S�vres"),
	D80("Somme"),
	D81("Tarn"),
	D82("Tarn-et-Garonne"),
	D83("Var"),
	D84("Vaucluse"),
	D85("Vend�e"),
	D86("Vienne"),
	D87("Haute-Vienne"),
	D88("Vosges"),
	D89("Yonne"),
	D90("Territoire de Belfort"),
	D91("Essonne"),
	D92("Hauts-de-Seine"),
	D93("Seine-Saint-Denis"),
	D94("Val-de-Marne"),
	D95("Val-d'Oise"),
	D971("Guadeloupe"),
	D972("Martinique"),
	D973("Guyane"),
	D974("R�union"),
	D975("Saint-Pierre-et-Miquelon"),
	D984("Terres australes et antarctiques fran�aise"),
	D985("Mayotte"),
	D986("Wallis-et-Futuna"),
	D987("Polyn�sie fran�aise"),
	D988("Nouvelle-Cal�donie");
	
	private String name;
	private DepartmentEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
>>>>>>> .r503

	public String getId() {
		return this.toString();
	}
}
