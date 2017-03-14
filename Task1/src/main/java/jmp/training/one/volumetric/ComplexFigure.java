package jmp.training.one.volumetric;

import java.util.ArrayList;
import java.util.List;

import jmp.training.one.core.Figure;
import jmp.training.one.core.Volumetric;

public class ComplexFigure implements Figure {

	private List<Volumetric> content = new ArrayList<Volumetric>();


	public boolean remove(Object o) {
		return content.remove(o);
	}

	public Volumetric get(int index) {
		return content.get(index);
	}

	public Volumetric remove(int index) {
		return content.remove(index);
	}
	
	@Override
	public boolean add(Volumetric e) {
		return content.add(e);
	}
	
	@Override
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

	@Override
	public List<Volumetric> getAll() {
		return content;
	}

}
