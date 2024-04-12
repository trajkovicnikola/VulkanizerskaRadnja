package auto_radnja;

import java.util.List;
import java.util.LinkedList;
import auto_radnja.gume.AutoGuma;

public class VulkanizerskaRadnja implements Radnja {

	private List<AutoGuma> gume = new LinkedList<AutoGuma>();

	@Override
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.add(a);
	}

	@Override
	public List<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		List<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (AutoGuma g:gume)
			if (g.getMarkaModel().equals(markaModel))
				novaLista.add(g);
		return novaLista;
	}

	@Override
	public List<AutoGuma> vratiSveGume() {
		return gume;
	}

}
