package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.util.RequestParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public interface FirmSearchParam extends SearchParams {

	@RequestParam("firm.name")
	public String getName();

	@RequestParam("user.department.id")
	public String getDepartment();
}