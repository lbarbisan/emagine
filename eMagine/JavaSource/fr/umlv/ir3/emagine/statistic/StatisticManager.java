package fr.umlv.ir3.emagine.statistic;

import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;

@MustHaveRights("statistic")
public interface StatisticManager extends EditableManager<Statistic, StatisticDAO> {

}