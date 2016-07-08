package jmp.training.one.volumetric;

import java.util.ArrayList;
import java.util.List;

public class ComplexFigure implements Volumetric {
	public boolean add(Volumetric e) {
		return content.add(e);
	}

	public boolean remove(Object o) {
		return content.remove(o);
	}

	public Volumetric get(int index) {
		return content.get(index);
	}

	public Volumetric remove(int index) {
		return content.remove(index);
	}

	private List<Volumetric> content = new ArrayList<Volumetric>();

	public double getVolume() {
		double allVolume = 0;
		for (Volumetric volumetric : content) {
			allVolume += volumetric.getVolume();
		}
		return allVolume;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ComplexFigure is from:");
		sb.append(content.toString());
		return sb.toString();
	}

}
